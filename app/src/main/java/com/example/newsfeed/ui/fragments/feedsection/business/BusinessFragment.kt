package com.example.newsfeed.ui.fragments.feedsection.business


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newsfeed.data.repository.TopStoryRepository
import com.example.newsfeed.databinding.FragmentBusinessBinding
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
class BusinessFragment : ScopedFragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var feedViewModel: FeedViewModel
    private lateinit var recyclerAdapter: FeedResultRecyclerAdapter

    @Inject
    lateinit var topStoryRepository: TopStoryRepository
    private lateinit var binding: FragmentBusinessBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentBusinessBinding.inflate(inflater, container, false)
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
//        val connectivityInterceptor = ConnectivityInterceptorImpl(context!!)
//        val apiService = NewsFeedApiService(connectivityInterceptor)
//        val feedDataSource = FeedDataSourceImpl(apiService)
//        val db = NewsFeedDatabase.invoke(context!!)
//        val topStoryRepository  = TopStoryRepositoryImpl(db.topStoryDao(),feedDataSource)

        val factory = FeedViewModelFactory(
            topStoryRepository,
            "business"
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
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance() =
            BusinessFragment()
    }
}
