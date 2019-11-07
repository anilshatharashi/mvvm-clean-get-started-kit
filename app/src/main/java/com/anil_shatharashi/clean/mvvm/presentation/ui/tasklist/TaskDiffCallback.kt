package com.anil_shatharashi.clean.mvvm.presentation.ui.tasklist

import androidx.recyclerview.widget.DiffUtil

class TaskDiffCallback(private val old: List<Int>,
                       private val new: List<Int>) : DiffUtil.Callback() {
    override fun getOldListSize() = old.size

    override fun getNewListSize() = new.size

    override fun areItemsTheSame(oldIndex: Int, newIndex: Int): Boolean {
        return old[oldIndex] == new[newIndex]
    }

    override fun areContentsTheSame(oldIndex: Int, newIndex: Int): Boolean {
        return old[oldIndex] == new[newIndex]
    }
}