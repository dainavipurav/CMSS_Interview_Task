package com.android.cmssinterviewtask.adapter

import android.content.Context
import android.graphics.Color
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.android.cmssinterviewtask.R
import com.android.cmssinterviewtask.interfaces.IOnRegularizeAttendanceClick
import com.android.cmssinterviewtask.models.AttendanceModel
import de.hdodenhof.circleimageview.CircleImageView

class AttendanceRecyclerAdapter(
    var mContext: Context,
    var mItemLayout: Int,
    var mAttendanceModelList: ArrayList<AttendanceModel>,
    var mIOnRegularizeAttendanceClick: IOnRegularizeAttendanceClick
) : RecyclerView.Adapter<AttendanceRecyclerAdapter.MyViewHolder>() {

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
        holder.mTextViewCustomLayoutAttendanceRowAttendanceDateBox.text =
            mAttendanceModelList[position].day
        holder.mTextViewCustomLayoutAttendanceRowAttendanceWeekDay.text =
            mAttendanceModelList[position].weekDay
        holder.mTextViewCustomLayoutAttendanceRowAttendanceReason.text =
            mAttendanceModelList[position].reason
        holder.mTextViewCustomLayoutAttendanceRowAttendanceType.text =
            mAttendanceModelList[position].type

        when (mAttendanceModelList[position].type) {
            mContext.getString(R.string.text_string_present) -> {
                holder.mViewCustomLayoutAttendanceRow.setBackgroundColor(Color.GREEN)
                holder.mCircleImageViewCustomLayoutAttendanceRowRegularizeAttendance.visibility =
                    View.GONE
            }
            mContext.getString(R.string.text_string_go) -> {
                holder.mViewCustomLayoutAttendanceRow.setBackgroundColor(mContext.getColor(R.color.colorAccent))
                holder.mCircleImageViewCustomLayoutAttendanceRowRegularizeAttendance.visibility =
                    View.GONE
            }
            mContext.getString(R.string.text_string_absent) -> {
                holder.mViewCustomLayoutAttendanceRow.setBackgroundColor(Color.RED)
                holder.mCircleImageViewCustomLayoutAttendanceRowRegularizeAttendance.visibility =
                    View.VISIBLE
            }
        }
    }

    override fun getItemCount(): Int {
        return mAttendanceModelList.size
    }

    inner class MyViewHolder(mItemView: View) : RecyclerView.ViewHolder(mItemView),
        View.OnClickListener {

        var mConstraintLayoutCustomLayoutAttendanceRow: ConstraintLayout =
            mItemView.findViewById(R.id.constraintLayoutCustomLayoutAttendanceRow)
        var mCardViewCustomLayoutAttendanceRowAttendanceDate: CardView =
            mItemView.findViewById(R.id.cardViewCustomLayoutAttendanceRowAttendanceDate)
        var mViewCustomLayoutAttendanceRow: View =
            mItemView.findViewById(R.id.viewCustomLayoutAttendanceRow)
        var mTextViewCustomLayoutAttendanceRowAttendanceDateBox: TextView =
            mItemView.findViewById(R.id.textViewCustomLayoutAttendanceRowAttendanceDateBox)
        var mTextViewCustomLayoutAttendanceRowAttendanceWeekDay: TextView =
            mItemView.findViewById(R.id.textViewCustomLayoutAttendanceRowAttendanceWeekDay)
        var mTextViewCustomLayoutAttendanceRowAttendanceReason: TextView =
            mItemView.findViewById(R.id.textViewCustomLayoutAttendanceRowAttendanceReason)
        var mTextViewCustomLayoutAttendanceRowAttendanceType: TextView =
            mItemView.findViewById(R.id.textViewCustomLayoutAttendanceRowAttendanceType)
        var mCircleImageViewCustomLayoutAttendanceRowRegularizeAttendance: CircleImageView =
            mItemView.findViewById(R.id.circleImageViewCustomLayoutAttendanceRowRegularizeAttendance)

        init {
            mCircleImageViewCustomLayoutAttendanceRowRegularizeAttendance.setOnClickListener(this@MyViewHolder)
        }

        override fun onClick(v: View?) {
            mIOnRegularizeAttendanceClick.onRegularizeAttendanceClick(mAttendanceModelList[adapterPosition])
        }
    }

}