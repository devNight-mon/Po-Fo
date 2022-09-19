package com.efesen.po_fo.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewEmptyObserver(
    private val recyclerView: RecyclerView,
    private val emptyView: View?
): RecyclerView.AdapterDataObserver() {

    private fun checkIfEmpty(){
        if (emptyView != null && recyclerView.adapter != null) {
            val emptyViewVisible = recyclerView.adapter!!.itemCount == 0
            if (emptyViewVisible) {
                emptyView.visibility = View.VISIBLE
                recyclerView.visibility = View.GONE
            }else {
                emptyView.visibility = View.GONE
                recyclerView.visibility = View.VISIBLE
            }
        }
    }

    override fun onChanged() {
        super.onChanged()
        checkIfEmpty()
    }

    override fun onItemRangeChanged(positionStart: Int, itemCount: Int) {
        super.onItemRangeChanged(positionStart, itemCount)
        checkIfEmpty()
    }

    override fun onItemRangeRemoved(positionStart: Int, itemCount: Int) {
        super.onItemRangeRemoved(positionStart, itemCount)
        checkIfEmpty()
    }
}