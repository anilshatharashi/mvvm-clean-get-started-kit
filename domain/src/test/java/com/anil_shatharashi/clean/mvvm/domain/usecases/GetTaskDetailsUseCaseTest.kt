package com.anil_shatharashi.clean.mvvm.domain.usecases

import com.anil_shatharashi.clean.mvvm.domain.executor.SchedulerProvider
import com.anil_shatharashi.clean.mvvm.domain.gateway.AnyApiGateway
import com.anil_shatharashi.clean.mvvm.domain.model.Task
import com.anil_shatharashi.clean.mvvm.domain.util.RxSchedulerRule
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import io.reactivex.Single
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Matchers.any

class GetTaskDetailsUseCaseTest {
    private lateinit var gateway: AnyApiGateway
    private lateinit var scheduler: SchedulerProvider
    @Rule
    @JvmField
    var testSchedulerRule = RxSchedulerRule()

    private lateinit var useCase: GetTaskDetailsUseCase

    @Before
    fun setup() {
        gateway = mockk(relaxed = true)
        scheduler = mockk(relaxed = true)
        useCase = GetTaskDetailsUseCase(gateway, scheduler)
    }

    @Test
    fun execute_success() {
        every { gateway.getTaskDetail(1) } returns Single.just(Task(1, "Task One", "Task Description ", "Notification"))

        val testObserver =  useCase.execute(any()).test()
        testObserver.assertComplete()
        testObserver.assertNoErrors()
        testObserver.assertValue(Task(1, "Task One", "Task Description ", "Notification"))
        verify(exactly = 1) { gateway.getTaskDetail(1) }
    }

    @Test
    fun execute_error() {
        val exception = Exception()
        every { gateway.getTaskDetail(1) } returns Single.error(exception)

        val testObserver =  useCase.execute(any()).test()
        testObserver.assertNotComplete()
        testObserver.assertError(exception)
        verify(exactly = 1) { gateway.getTaskDetail(1) }
    }
}