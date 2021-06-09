package com.example.android.navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.example.android.navigation.databinding.FragmentTabBinding
import com.example.tablayout.fragments.Fragment1
import com.example.tablayout.fragments.Fragment2
import com.example.tablayout.fragments.Fragment3
import com.google.android.material.tabs.TabLayout


class Fragment_tab : Fragment() {

    private var _binding: FragmentTabBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        //return inflater.inflate(R.layout.fragment_tab, container, false)

        _binding = FragmentTabBinding.inflate(inflater, container, false)
        binding.tabs
        binding.viewpager


        val tabLayout: TabLayout = binding.tabs
        val viewpager: ViewPager = binding.viewpager
        val viewPagerAdapter = ViewPagerAdapter(childFragmentManager)

        viewPagerAdapter.addFragment(Fragment1(),"home")
        viewPagerAdapter.addFragment(Fragment2(),"chat")
        viewPagerAdapter.addFragment(Fragment3(),"setting")

        viewpager.adapter = viewPagerAdapter
        tabLayout.setupWithViewPager(viewpager)


        return binding.root


    }


    internal class ViewPagerAdapter(fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager)
    {
        private val fragments: ArrayList<Fragment>
        private val titles: ArrayList<String>

        init {
            fragments = ArrayList<Fragment>()
            titles = ArrayList<String>()
        }

        override fun getCount(): Int {
            return fragments.size
        }

        override fun getItem(position: Int): Fragment {
            return fragments[position]
        }

        fun addFragment(fragment: Fragment,title: String)
        {
            fragments.add(fragment)
            titles.add(title)
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return titles[position]
        }

    }

}