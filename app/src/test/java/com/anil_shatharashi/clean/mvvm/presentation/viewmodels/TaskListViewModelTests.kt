package com.anil_shatharashi.clean.mvvm.presentation.viewmodels

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.anil_shatharashi.clean.mvvm.domain.usecases.GetTaskListUseCase
import com.anil_shatharashi.clean.mvvm.presentation.model.Resource
import com.anil_shatharashi.clean.mvvm.presentation.util.UIRxSchedulerRule
import com.anil_shatharashi.clean.mvvm.presentation.viewmodel.TaskListViewModel
import io.mockk.every
import io.mockk.mockk
import io.mockk.spyk
import io.mockk.verify
import io.reactivex.Single
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule

class TaskListViewModelTests {

    private lateinit var viewModel: TaskListViewModel
    private lateinit var getTaskListUseCase: GetTaskListUseCase

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    @Rule
    @JvmField
    var testSchedulerRule = UIRxSchedulerRule()

    @Before
    fun setup() {
        getTaskListUseCase = mockk(relaxed = true)
        viewModel = spyk(TaskListViewModel(getTaskListUseCase))
    }

    @Test
    fun getTaskList_calls_use_case() {
        viewModel.loadListOfTasks()

        verify(exactly = 1) { getTaskListUseCase.execute(any()) }
    }

    @Test
    fun getTaskList_success() {
        val taskListResponse = listOf(2,3,5,19,22)

        every { getTaskListUseCase.execute(any()) } returns Single.just(taskListResponse)

        viewModel.loadListOfTasks()

        Assert.assertEquals(Resource.success(taskListResponse), viewModel.taskListLiveData.value)
    }

    @Test
    fun getPupilsRequiredManualMarking_error() {
        val response = Exception()

        every { getTaskListUseCase.execute(any()) } returns Single.error(response)

        viewModel.loadListOfTasks()

        Assert.assertEquals(Resource.error<Exception>("Error in fetching Tasks"), viewModel.taskListLiveData.value)
    }

}