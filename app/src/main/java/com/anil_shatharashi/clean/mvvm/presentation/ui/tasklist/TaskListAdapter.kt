package com.anil_shatharashi.clean.mvvm.presentation.ui.tasklist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil.calculateDiff
import androidx.recyclerview.widget.RecyclerView
import com.anil_shatharashi.clean.mvvm.R
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.view_empty.view.tvEmpty
import kotlinx.android.synthetic.main.view_item_task.taskId

typealias ClickListener = (Int) -> Unit

private const val TYPE_EMPTY = -1
private const val TYPE_LIST = 1

class TaskListAdapter(private val clickListener: ClickListener) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var taskList = emptyList<Int>()
        set(tasks) {
            field = tasks
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            TYPE_EMPTY -> EmptyViewHolder(LayoutInflater.from(parent.context)
                    .inflate(R.layout.view_empty, parent, false),
                    R.string.data_empty_message
            )
            else -> TaskListViewHolder(View.inflate(parent.context, R.layout.view_item_task, null))
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is TaskListViewHolder -> {
                holder.clickListener = clickListener
                holder.bind(taskList[position])
            }
        }
    }

    override fun getItemCount(): Int {
        return if (taskList.isEmpty()) {
            1
        } else {
            taskList.size
        }
    }

    override fun getItemViewType(position: Int): Int = when {
        taskList.isEmpty() -> TYPE_EMPTY
        else -> TYPE_LIST
    }

    fun updateTasks(tasks: List<Int>) {
        val diffResult = calculateDiff(TaskDiffCallback(this.taskList, tasks))
        this.taskList = tasks
        diffResult.dispatchUpdatesTo(this)
    }

    class TaskListViewHolder(private val parent: View) : RecyclerView.ViewHolder(parent), LayoutContainer {
        lateinit var clickListener: (Int) -> Unit
        override val containerView: View?
            get() = itemView

        fun bind(task: Int) {
            taskId.text = parent.resources.getString(R.string.task, task)
            taskId.setOnClickListener { clickListener(task) }
        }
    }

    class EmptyViewHolder(parent: View, text: Int) : RecyclerView.ViewHolder(parent) {
        init {
            itemView.tvEmpty.setText(text)
        }
    }
}