package com.android.cmssinterviewtask.fragments

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.android.cmssinterviewtask.R
import com.android.cmssinterviewtask.adapter.SlidingBannerRecyclerAdapter
import com.android.cmssinterviewtask.helper.InfoHelper
import com.android.cmssinterviewtask.models.SlidingBannersModel
import com.google.android.material.tabs.TabLayout


class FavoritesFragment : Fragment(R.layout.fragment_favorites) {
    private lateinit var mConstraintLayoutCustomLayoutAnnouncements: ConstraintLayout
    private lateinit var mTextViewCustomLayoutAnnouncements: TextView
    private lateinit var mRecyclerViewCustomLayoutAnnouncements: RecyclerView
    private lateinit var mConstraintLayoutCustomLayoutTabs: ConstraintLayout
    private lateinit var mTabLayoutCustomLayoutTabs: TabLayout
    private lateinit var mViewpagerCustomLayoutTabs: ViewPager
    private lateinit var mSlidingBannerRecyclerAdapter: SlidingBannerRecyclerAdapter
    private var mSlidingBannersModelList: ArrayList<SlidingBannersModel> = ArrayList()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mConstraintLayoutCustomLayoutAnnouncements =
            view.findViewById(R.id.constraintLayoutCustomLayoutAnnouncements)
        mTextViewCustomLayoutAnnouncements =
            view.findViewById(R.id.textViewCustomLayoutAnnouncements)
        mRecyclerViewCustomLayoutAnnouncements =
            view.findViewById(R.id.recyclerViewCustomLayoutAnnouncements)
        mConstraintLayoutCustomLayoutTabs = view.findViewById(R.id.constraintLayoutCustomLayoutTabs)
        mTabLayoutCustomLayoutTabs = view.findViewById(R.id.tabLayoutCustomLayoutTabs)
        mViewpagerCustomLayoutTabs = view.findViewById(R.id.viewpagerCustomLayoutTabs)


        setUpViewPager(mViewpagerCustomLayoutTabs)

        mTabLayoutCustomLayoutTabs.setupWithViewPager(mViewpagerCustomLayoutTabs)
        mTabLayoutCustomLayoutTabs.setTabGravity(TabLayout.GRAVITY_FILL);

        context?.let {
            InfoHelper(it).slidingBannersDataLoader(mSlidingBannersModelList)
            mSlidingBannerRecyclerAdapter = SlidingBannerRecyclerAdapter(
                it,
                R.layout.custom_layout_sliding_banners,
                mSlidingBannersModelList
            )
            mRecyclerViewCustomLayoutAnnouncements.adapter = mSlidingBannerRecyclerAdapter
        }
    }

    private fun setUpViewPager(mViewPager: ViewPager) {
        val mAdapter: Adapter = Adapter(childFragmentManager)
        mAdapter.addFragment(LeavesFragment(), getString(R.string.text_string_leaves))
        mAdapter.addFragment(AttendanceFragment(), getString(R.string.text_string_attendance))

        mViewPager.adapter = mAdapter
    }


    class Adapter(mFragmentManager: FragmentManager) : FragmentPagerAdapter(mFragmentManager) {

        var mFragmentList: ArrayList<Fragment> = ArrayList()
        var mFragmentTitleList: ArrayList<String> = ArrayList()

        override fun getCount(): Int {
            return mFragmentList.size
        }

        override fun getItem(position: Int): Fragment {
            return mFragmentList.get(position)
        }

        fun addFragment(mFragment: Fragment, mTitle: String) {
            mFragmentList.add(mFragment)
            mFragmentTitleList.add(mTitle)
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return mFragmentTitleList.get(position)
        }

    }


}