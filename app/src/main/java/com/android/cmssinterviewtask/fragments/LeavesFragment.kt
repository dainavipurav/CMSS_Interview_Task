package com.android.cmssinterviewtask.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.android.cmssinterviewtask.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

class LeavesFragment : Fragment(R.layout.fragment_leaves),View.OnClickListener {

    private lateinit var mFloatingActionButtonLeavesApplyLeave : FloatingActionButton
    private lateinit var mFloatingActionButtonLeavesHolidayCalendar : FloatingActionButton

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mFloatingActionButtonLeavesApplyLeave = view.findViewById(R.id.floatingActionButtonLeavesApplyLeave)
        mFloatingActionButtonLeavesApplyLeave.setOnClickListener(this@LeavesFragment)

        mFloatingActionButtonLeavesHolidayCalendar = view.findViewById(R.id.floatingActionButtonLeavesHolidayCalendar)
        mFloatingActionButtonLeavesHolidayCalendar.setOnClickListener(this@LeavesFragment)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.floatingActionButtonLeavesApplyLeave ->
            {
                Toast.makeText(context,"You Clicked Apply Leave", Toast.LENGTH_SHORT).show()
            }
            R.id.floatingActionButtonLeavesHolidayCalendar ->
            {
                Toast.makeText(context,"You Clicked Holiday Calendar", Toast.LENGTH_SHORT).show()
            }
        }
    }

}