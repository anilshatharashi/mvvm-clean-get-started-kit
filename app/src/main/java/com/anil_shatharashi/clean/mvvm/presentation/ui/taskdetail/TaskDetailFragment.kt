package com.anil_shatharashi.clean.mvvm.presentation.ui.taskdetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.anil_shatharashi.clean.mvvm.ListAndDetailsApplication
import com.anil_shatharashi.clean.mvvm.R
import com.anil_shatharashi.clean.mvvm.domain.model.Task
import com.anil_shatharashi.clean.mvvm.presentation.di.ViewModelFactory
import com.anil_shatharashi.clean.mvvm.presentation.ui.taskdetail.TaskDetailFragmentArgs.fromBundle
import com.anil_shatharashi.clean.mvvm.presentation.viewmodel.TaskDetailViewModel
import kotlinx.android.synthetic.main.fragment_task_detail.*
import javax.inject.Inject

class TaskDetailFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private val viewModel: TaskDetailViewModel by activityViewModels { viewModelFactory }

    private val taskId by lazy {
        arguments?.let { fromBundle(it).taskId }
                ?: throw IllegalArgumentException("Expected arguments")
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        ListAndDetailsApplication.appComponent.inject(this)
        return inflater.inflate(R.layout.fragment_task_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.observableTask.observe(this, Observer { note ->
            note?.let { render(note) }
        })
    }

    override fun onResume() {
        super.onResume()
        viewModel.getTask(taskId)
    }

    private fun render(task: Task) {
        taskIdView.text = String.format(getString(R.string.task_id), task.id)
        taskName.text = String.format(getString(R.string.task_name), task.taskName)
        descriptionView.text = String.format(getString(R.string.description), task.description)
        notificationView.text = String.format(getString(R.string.notification), task.notification)
    }

}
