package com.android.cmssinterviewtask.helper

import android.content.Context
import androidx.appcompat.content.res.AppCompatResources.getDrawable
import com.android.cmssinterviewtask.R
import com.android.cmssinterviewtask.models.AttendanceModel
import com.android.cmssinterviewtask.models.LeavesModel
import com.android.cmssinterviewtask.models.SlidingBannersModel

class InfoHelper(var mContext : Context) {
    fun slidingBannersDataLoader(mSlidingBannersModel: ArrayList<SlidingBannersModel>){
        mSlidingBannersModel.add(
            SlidingBannersModel(
                "1",
                getDrawable(mContext,R.drawable.ic_favorite)
            )
        )
        mSlidingBannersModel.add(
            SlidingBannersModel(
                "2",
                getDrawable(mContext,R.drawable.ic_calendar)
            )
        )
        mSlidingBannersModel.add(
            SlidingBannersModel(
                "3",
                getDrawable(mContext,R.drawable.ic_approval)
            )
        )
        mSlidingBannersModel.add(
            SlidingBannersModel(
                "4",
                getDrawable(mContext,R.drawable.ic_team)
            )
        )
        mSlidingBannersModel.add(
            SlidingBannersModel(
                "4",
                getDrawable(mContext,R.drawable.ic_notifications)
            )
        )
    }

    fun leavesDataLoader(mLeavesModel: ArrayList<LeavesModel>) {
        mLeavesModel.add(
            LeavesModel(
                "1",
                "03 Sept",
                "07 Sept",
                mContext.getString(R.string.text_string_leave_without_pay),
                mContext.getString(R.string.text_string_in_process)
            )
        )
        mLeavesModel.add(
            LeavesModel(
                "2",
                "25 Aug",
                "25 Aug",
                mContext.getString(R.string.text_string_could_not_sign_in),
                mContext.getString(R.string.text_string_in_process)
            )
        )
        mLeavesModel.add(
            LeavesModel(
                "3",
                "03 July",
                "07 July",
                mContext.getString(R.string.text_string_leave_without_pay),
                mContext.getString(R.string.text_string_rejected)
            )
        )
        mLeavesModel.add(
            LeavesModel(
                "4",
                "25 Jun",
                "25 Jun",
                mContext.getString(R.string.text_string_paid_leave),
                mContext.getString(R.string.text_string_approved)
            )
        )
        mLeavesModel.add(
            LeavesModel(
                "5",
                "03 May",
                "07 May",
                mContext.getString(R.string.text_string_leave_without_pay),
                mContext.getString(R.string.text_string_rejected)
            )
        )
        mLeavesModel.add(
            LeavesModel(
                "6",
                "03 Sep",
                "07 Sep",
                mContext.getString(R.string.text_string_leave_without_pay),
                mContext.getString(R.string.text_string_in_process)
            )
        )
    }

    fun attendanceDataLoader(mAttendanceModel: ArrayList<AttendanceModel>){
        mAttendanceModel.add(
            AttendanceModel(
                "1",
                "25 Aug",
                "Friday",
                mContext.getString(R.string.text_string_late_muster),
                mContext.getString(R.string.text_string_go)
            )
        )
        mAttendanceModel.add(
            AttendanceModel(
                "2",
                "26 Aug",
                "Saturday",
                mContext.getString(R.string.text_string_late_muster),
                mContext.getString(R.string.text_string_go)
            )
        )
        mAttendanceModel.add(
            AttendanceModel(
                "3",
                "27 Aug",
                "Sunday",
                mContext.getString(R.string.text_string_weekly_off),
                mContext.getString(R.string.text_string_present)
            )
        )
        mAttendanceModel.add(
            AttendanceModel(
                "4",
                "28 Aug",
                "Monday",
                mContext.getString(R.string.text_string_working),
                mContext.getString(R.string.text_string_present)
            )
        )
        mAttendanceModel.add(
            AttendanceModel(
                "5",
                "29 Aug",
                "Tuesday",
                mContext.getString(R.string.text_string_working),
                mContext.getString(R.string.text_string_present)
            )
        )
        mAttendanceModel.add(
            AttendanceModel(
                "6",
                "30 Aug",
                "Wednesday",
                mContext.getString(R.string.text_string_seak_leave),
                mContext.getString(R.string.text_string_absent)
            )
        )
    }
}