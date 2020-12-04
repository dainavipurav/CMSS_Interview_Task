package com.android.cmssinterviewtask.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.android.cmssinterviewtask.R
import com.android.cmssinterviewtask.adapter.AttendanceRecyclerAdapter
import com.android.cmssinterviewtask.helper.InfoHelper
import com.android.cmssinterviewtask.interfaces.IOnRegularizeAttendanceClick
import com.android.cmssinterviewtask.models.AttendanceModel

class AttendanceFragment : Fragment(R.layout.fragment_attendance),IOnRegularizeAttendanceClick {

    private lateinit var mConstraintLayoutAttendance : ConstraintLayout
    private lateinit var mRecyclerViewAttendance : RecyclerView
    private lateinit var mAttendanceRecyclerAdapter : AttendanceRecyclerAdapter
    private var mAttendanceModelList : ArrayList<AttendanceModel> = ArrayList()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mConstraintLayoutAttendance = view.findViewById(R.id.constraintLayoutAttendance)
        mRecyclerViewAttendance = view.findViewById(R.id.recyclerViewAttendance)

        context?.let {
            InfoHelper(it).attendanceDataLoader(mAttendanceModelList)
            mAttendanceRecyclerAdapter = AttendanceRecyclerAdapter(
                it,
                R.layout.custom_layout_attendance_row,
                mAttendanceModelList,
                this@AttendanceFragment
            )
            mRecyclerViewAttendance.adapter = mAttendanceRecyclerAdapter
        }
    }

    override fun onRegularizeAttendanceClick(mAttendanceModel: AttendanceModel) {
        Toast.makeText(context,"You Clicked on Regularize",Toast.LENGTH_SHORT).show()
    }
}