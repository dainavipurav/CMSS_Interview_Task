package com.android.cmssinterviewtask.fragments

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.android.cmssinterviewtask.R
import com.android.cmssinterviewtask.adapter.LeavesRecyclerAdapter
import com.android.cmssinterviewtask.helper.InfoHelper
import com.android.cmssinterviewtask.interfaces.IOnCancelLeaveClick
import com.android.cmssinterviewtask.models.LeavesModel
import com.google.android.material.floatingactionbutton.FloatingActionButton

class LeavesFragment : Fragment(R.layout.fragment_leaves), View.OnClickListener,
    IOnCancelLeaveClick {

    private lateinit var mFloatingActionButtonLeavesApplyLeave: FloatingActionButton
    private lateinit var mFloatingActionButtonLeavesHolidayCalendar: FloatingActionButton
    private lateinit var mRecyclerViewLeaves: RecyclerView
    private lateinit var mLeavesRecyclerAdapter: LeavesRecyclerAdapter
    private var mLeavesModelList: ArrayList<LeavesModel> = ArrayList()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mFloatingActionButtonLeavesApplyLeave =
            view.findViewById(R.id.floatingActionButtonLeavesApplyLeave)
        mFloatingActionButtonLeavesApplyLeave.setOnClickListener(this@LeavesFragment)

        mFloatingActionButtonLeavesHolidayCalendar =
            view.findViewById(R.id.floatingActionButtonLeavesHolidayCalendar)
        mFloatingActionButtonLeavesHolidayCalendar.setOnClickListener(this@LeavesFragment)

        mRecyclerViewLeaves = view.findViewById(R.id.recyclerViewLeaves)

        context?.let {
            InfoHelper(it).leavesDataLoader(mLeavesModelList)
            mLeavesRecyclerAdapter = LeavesRecyclerAdapter(
                it,
                mLeavesModelList,
                R.layout.custom_layout_leaves_row,
                this@LeavesFragment
            )
            mRecyclerViewLeaves.adapter = mLeavesRecyclerAdapter
        }
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.floatingActionButtonLeavesApplyLeave -> {
                Toast.makeText(context, "You Clicked Apply Leave", Toast.LENGTH_SHORT).show()
            }
            R.id.floatingActionButtonLeavesHolidayCalendar -> {
                Toast.makeText(context, "You Clicked Holiday Calendar", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onCancelLeaveClick(mLeavesModel: LeavesModel) {
        Toast.makeText(context, mLeavesModel.startDate, Toast.LENGTH_SHORT).show()

        AlertDialog.Builder(context)
            .setTitle("Cancel Leave")
            .setMessage("Do you want to cancel leave?")
            .setPositiveButton("Yes", object : DialogInterface.OnClickListener {
                override fun onClick(dialog: DialogInterface, which: Int) {
                    mLeavesModelList.remove(mLeavesModel)
                    mLeavesRecyclerAdapter.notifyDataSetChanged()
                    dialog.dismiss()
                }
            })
            .setNegativeButton(android.R.string.no, object : DialogInterface.OnClickListener {
                override fun onClick(dialog: DialogInterface, which: Int) {
                    dialog.dismiss()
                }
            })
            .setIcon(android.R.drawable.ic_dialog_alert)
            .show()


    }

}