package com.example.newsfeed.ui.fragments.feedsection.sports

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newsfeed.data.repository.TopStoryRepository
import com.example.newsfeed.databinding.FragmentSportsBinding
import com.example.newsfeed.ui.adapters.FeedResultRecyclerAdapter
import com.example.newsfeed.ui.base.ScopedFragment
import com.example.newsfeed.ui.fragments.feedsection.FeedViewModel
import com.example.newsfeed.ui.fragments.feedsection.FeedViewModelFactory
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

@AndroidEntryPoint
class SportsFragment : ScopedFragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var feedViewModel: FeedViewModel
    private lateinit var recyclerAdapter: FeedResultRecyclerAdapter

    @Inject
    lateinit var topStoryRepository: TopStoryRepository
    private lateinit var binding: FragmentSportsBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSportsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerAdapter = FeedResultRecyclerAdapter(
            listOf(),
            requireContext()
        )
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = recyclerAdapter

        val factory = FeedViewModelFactory(
            topStoryRepository,
            "sports"
        )
        feedViewModel = ViewModelProvider(this, factory).get(FeedViewModel::class.java)

        bindUi()
    }

    private fun bindUi() = launch {
        val topStory = feedViewModel.topStory.await()

        topStory.observe(viewLifecycleOwner, Observer {
            if (it == null) return@Observer

            //text_home.text = it.toString()
            binding.groupLoading.visibility = View.GONE

            //initRecyclerView(it.results)
            recyclerAdapter.updateFeed(it.results)


        })
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment SportsFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance() =
            SportsFragment()
    }
}
