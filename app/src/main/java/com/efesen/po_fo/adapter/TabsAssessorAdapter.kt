package com.efesen.po_fo.adapter


import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.efesen.po_fo.view.TasksDoneFragment
import com.efesen.po_fo.view.TasksPendingFragment

class TabsAssessorAdapter(fragmentManager : FragmentManager) : FragmentPagerAdapter(fragmentManager) {
    override fun getCount(): Int {
      return 2
    }


    override fun getItem(position: Int): Fragment {
        return when(position ) {
            0 -> {
                TasksPendingFragment()
            }
            1 -> {
                TasksDoneFragment()
            }
           else -> throw IllegalStateException("position $position is invalid for this viewpager")
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when(position) {
            0 -> "Pending"

            1 -> "Done"

            else -> null
        }
    }
}