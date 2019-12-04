package io.github.sphrak.nestedrecyclerviewkotlin

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class MainViewPagerAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {

    override fun getItemCount(): Int = 3
    override fun createFragment(position: Int): Fragment =
        when (position) {
            0 -> MainFragment()
            1 -> ListFragment()
            2 -> ExtraFragment()
            else -> throw Exception("something went terribly wrong")
        }
}