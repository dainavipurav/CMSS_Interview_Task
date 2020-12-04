package com.android.cmssinterviewtask.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.android.cmssinterviewtask.R
import com.android.cmssinterviewtask.models.SlidingBannersModel

class SlidingBannerRecyclerAdapter(
    var mContext: Context,
    var mItemLayout: Int,
    var mSlidingBannersModelList: ArrayList<SlidingBannersModel>
) : RecyclerView.Adapter<SlidingBannerRecyclerAdapter.MyViewHolder>() {

    class MyViewHolder(mItemView: View) : RecyclerView.ViewHolder(mItemView) {
        var mConstraintLayoutCustomLayoutSlidingBanners: ConstraintLayout = mItemView.findViewById(
            R.id.constraintLayoutCustomLayoutSlidingBanners
        )
        var imageViewCustomLayoutSlidingBanners: ImageView =
            mItemView.findViewById(R.id.imageViewCustomLayoutSlidingBanners)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(mContext)
                .inflate(
                    mItemLayout,
                    parent,
                    false
                )
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.imageViewCustomLayoutSlidingBanners.setImageDrawable(mSlidingBannersModelList[position].image)
    }

    override fun getItemCount(): Int {
        return mSlidingBannersModelList.size
    }

}