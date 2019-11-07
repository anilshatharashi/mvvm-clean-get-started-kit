package com.anil_shatharashi.clean.mvvm.presentation.ui.tasklist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.Navigation.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.anil_shatharashi.clean.mvvm.R
import com.anil_shatharashi.clean.mvvm.presentation.ui.tasklist.TaskListFragmentDirections.actionTaskSelection
import com.anil_shatharashi.clean.mvvm.presentation.viewmodel.TaskListViewModel
import kotlinx.android.synthetic.main.fragment_task_list.tasksRecyclerView
import org.koin.android.viewmodel.ext.android.viewModel

class TaskListFragment : Fragment() {

    private val clickListener: ClickListener = this::onTaskClicked
    private val recyclerViewAdapter = TaskListAdapter(clickListener)
    private val viewModel: TaskListViewModel by viewModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_task_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()

        viewModel.taskListLiveData.observe(this, Observer { tasks ->
            tasks.data?.let { render(it) }
        })

    }

    override fun onResume() {
        super.onResume()
        viewModel.loadListOfTasks()
    }

    private fun render(tasks: List<Int>) {
        recyclerViewAdapter.taskList = tasks
    }

    private fun onTaskClicked(task: Int) {
        val navDirections = actionTaskSelection(task)
        view?.let {
            findNavController(it).navigate(navDirections)
        }
    }

    private fun setupRecyclerView() {
        val linearLayoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
        val itemDecor = DividerItemDecoration(activity, linearLayoutManager.orientation)

        tasksRecyclerView.apply {
            this.setHasFixedSize(true)
            layoutManager = linearLayoutManager
            adapter = recyclerViewAdapter
            addItemDecoration(itemDecor)
        }
    }
}