package com.anil_shatharashi.clean.mvvm.data.repository

import com.anil_shatharashi.clean.mvvm.data.repository.remote.api.AnyApi
import com.anil_shatharashi.clean.mvvm.data.util.UIRxSchedulerRule
import com.anil_shatharashi.clean.mvvm.domain.gateway.TasksNetworkGateway
import com.anil_shatharashi.clean.mvvm.domain.model.Task
import io.mockk.mockk
import io.mockk.spyk
import io.mockk.verify
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class AnyApiRepositoryTest {

    private lateinit var compositeDisposable: CompositeDisposable
    private lateinit var anyApiGateway: TasksNetworkGateway
    private lateinit var anyApi: AnyApi

    @Rule
    @JvmField
    var testSchedulerRule = UIRxSchedulerRule()

    @Before
    fun setup() {
        compositeDisposable = CompositeDisposable()
        anyApi = mockk(relaxed = true)
        anyApiGateway = spyk(AnyApiRepository(anyApi))
    }

    @After
    fun tearDown() {
        compositeDisposable.dispose()
    }

    @Test
    fun getOpportunitiesTasks_call() {
        val testObserver = anyApiGateway.getTasks()
        testObserver.test()

        verify(exactly = 1) { anyApiGateway.getTasks() }
    }

    @Test
    fun getTaskDetails_call() {
        val testObserver = anyApiGateway.getTaskDetail(1)
        testObserver.test()

        verify(exactly = 1) { anyApiGateway.getTaskDetail(1) }
    }

    @Test
    fun getOpportunitiesTasks_success() {
        val responseObservable = Single.just(listOf(2, 9, 10, 12, 13, 15))

        val responseObservableTest = responseObservable.test()
        val testObserver = anyApiGateway.getTasks().subscribe()
        compositeDisposable.add(testObserver)
        verify(exactly = 1) { anyApi.getTasks()}

        responseObservableTest.assertComplete()
        responseObservableTest.assertNoErrors()
        responseObservableTest.assertValueCount(1)
    }

    @Test
    fun getOpportunitiesTasks_error() {
        val exception = Exception()
        val errorResponse = Single.error<List<Int>>(exception)
        val responseObservableTest = errorResponse.test()

        val testObserver = anyApiGateway.getTasks().subscribe()
        compositeDisposable.add(testObserver)

        responseObservableTest.assertValueCount(0)
        responseObservableTest.assertError(exception)
    }

    @Test
    fun getTaskDetails_success() {
        val responseObservable = Single.just(Task(1, "Task One", "Task Description ", "Notification"))

        val responseObservableTest = responseObservable.test()
        val testObserver = anyApiGateway.getTaskDetail(1).subscribe()
        compositeDisposable.add(testObserver)
        verify(exactly = 1) { anyApi.getTaskDetails(1)}

        responseObservableTest.assertComplete()
        responseObservableTest.assertNoErrors()
        responseObservableTest.assertValueCount(1)
    }

    @Test
    fun getTaskDetail_error() {
        val exception = Exception()
        val errorResponse = Single.error<Task>(exception)
        val responseObservableTest = errorResponse.test()

        val testObserver = anyApiGateway.getTaskDetail(1).subscribe()
        compositeDisposable.add(testObserver)

        responseObservableTest.assertValueCount(0)
        responseObservableTest.assertError(exception)
    }
}