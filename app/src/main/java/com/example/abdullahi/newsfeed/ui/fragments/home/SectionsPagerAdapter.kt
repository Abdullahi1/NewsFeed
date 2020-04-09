package com.example.abdullahi.newsfeed.ui.fragments.home

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.abdullahi.newsfeed.R
import com.example.abdullahi.newsfeed.ui.fragments.feedsection.business.BusinessFragment
import com.example.abdullahi.newsfeed.ui.fragments.feedsection.entertainment.EntertainmentFragment
import com.example.abdullahi.newsfeed.ui.fragments.feedsection.science.ScienceStoryFragment
import com.example.abdullahi.newsfeed.ui.fragments.feedsection.sports.SportsFragment
import com.example.abdullahi.newsfeed.ui.fragments.feedsection.topStory.TopStoryFragment

private val TAB_TITLES = arrayOf(
    "Home",
    "business",
    "Entertainment",
    "Science",
    "Sports"

)

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
class SectionsPagerAdapter(private val context: Context, fm: FragmentManager) :
    FragmentPagerAdapter(fm,BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    private val fragmentList : List<Fragment> = listOf(TopStoryFragment.newInstance(),
        BusinessFragment.newInstance(),
        EntertainmentFragment.newInstance(),
        ScienceStoryFragment.newInstance(),
        SportsFragment.newInstance())

    override fun getItem(position: Int): Fragment {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
//        return when(position){
//            0 -> {
//                TopStoryFragment.newInstance()
//            }
//            1->{
//                BusinessFragment.newInstance()
//            }
//            2->{
//                EntertainmentFragment.newInstance()
//            }
//            3->{
//                ScienceStoryFragment.newInstance()
//            }
//            4->{
//                SportsFragment.newInstance()
//            }
//            else ->{
//                throw IllegalArgumentException()
//            }
//        }

        return fragmentList[position]
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return TAB_TITLES[position]
    }





    override fun getCount(): Int {
        // Show 2 total pages.
        return fragmentList.size
    }
}