package com.android.cmssinterviewtask.adapter

import android.content.Context
import android.graphics.Color
import android.os.Build
import android.provider.CalendarContract
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.android.cmssinterviewtask.R
import com.android.cmssinterviewtask.interfaces.IOnCancelLeaveClick
import com.android.cmssinterviewtask.models.LeavesModel
import com.google.android.material.floatingactionbutton.FloatingActionButton
import de.hdodenhof.circleimageview.CircleImageView

class LeavesRecyclerAdapter(
    var mContext: Context,
    var mLeavesModelList: ArrayList<LeavesModel>,
    var mItemLayout: Int,
    var mIOnCancelLeaveClick: IOnCancelLeaveClick
) : RecyclerView.Adapter<LeavesRecyclerAdapter.MyViewHolder>() {

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

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.mTextViewCustomLayoutLeavesRowLeaveDateBox.text =
            mLeavesModelList[position].startDate
        holder.mTextViewCustomLayoutLeavesRowLeaveType.text = mLeavesModelList[position].type
        holder.mTextViewCustomLayoutLeavesRowLeaveDates.text =
            "${mLeavesModelList[position].startDate} - ${mLeavesModelList[position].endDate}"
        holder.mTextViewCustomLayoutLeavesRowLeaveStatus.text = mLeavesModelList[position].status

        when (mLeavesModelList[position].status) {
            mContext.getString(R.string.text_string_in_process) -> {
                holder.mViewCustomLayoutLeavesRow.setBackgroundColor(mContext.getColor(R.color.colorAccent))
                holder.mCircleImageViewCustomLayoutLeavesRowLeaveCancel.visibility = View.VISIBLE
            }
            mContext.getString(R.string.text_string_approved) -> {
                holder.mViewCustomLayoutLeavesRow.setBackgroundColor(Color.GREEN)
                holder.mCircleImageViewCustomLayoutLeavesRowLeaveCancel.visibility = View.GONE
            }
            mContext.getString(R.string.text_string_rejected) -> {
                holder.mViewCustomLayoutLeavesRow.setBackgroundColor(mContext.getColor(R.color.red))
                holder.mCircleImageViewCustomLayoutLeavesRowLeaveCancel.visibility = View.GONE
            }
        }
    }

    override fun getItemCount(): Int {
        return mLeavesModelList.size
    }

    inner class MyViewHolder(mItemView: View) : RecyclerView.ViewHolder(mItemView),View.OnClickListener {
        var mConstraintLayoutCustomLayoutLeavesRow: ConstraintLayout =
            mItemView.findViewById(R.id.constraintLayoutCustomLayoutLeavesRow)
        var mCardViewCustomLayoutLeavesRowLeaveDate: CardView =
            mItemView.findViewById(R.id.cardViewCustomLayoutLeavesRowLeaveDate)
        var mViewCustomLayoutLeavesRow: View =
            mItemView.findViewById(R.id.viewCustomLayoutLeavesRow)
        var mTextViewCustomLayoutLeavesRowLeaveDateBox: TextView =
            mItemView.findViewById(R.id.textViewCustomLayoutLeavesRowLeaveDateBox)
        var mTextViewCustomLayoutLeavesRowLeaveType: TextView =
            mItemView.findViewById(R.id.textViewCustomLayoutLeavesRowLeaveType)
        var mTextViewCustomLayoutLeavesRowLeaveDates: TextView =
            mItemView.findViewById(R.id.textViewCustomLayoutLeavesRowLeaveDates)
        var mTextViewCustomLayoutLeavesRowLeaveStatus: TextView =
            mItemView.findViewById(R.id.textViewCustomLayoutLeavesRowLeaveStatus)
        var mCircleImageViewCustomLayoutLeavesRowLeaveCancel: CircleImageView =
            mItemView.findViewById(R.id.circleImageViewCustomLayoutLeavesRowLeaveCancel)

        init {
            mCircleImageViewCustomLayoutLeavesRowLeaveCancel.setOnClickListener(this@MyViewHolder)
        }

        override fun onClick(v: View?) {
            v?.let {
                mIOnCancelLeaveClick.onCancelLeaveClick(mLeavesModelList[adapterPosition])
            }
        }
    }

}