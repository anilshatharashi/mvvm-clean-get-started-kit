package com.anil_shatharashi.clean.mvvm.domain.usecases

import com.anil_shatharashi.clean.mvvm.domain.executor.SchedulerProvider
import com.anil_shatharashi.clean.mvvm.domain.gateway.TasksNetworkGateway
import com.anil_shatharashi.clean.mvvm.domain.util.RxSchedulerRule
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import io.reactivex.Single
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Matchers.any

class GetTasksListUseCaseTest {
    private lateinit var gateway: TasksNetworkGateway
    private lateinit var scheduler: SchedulerProvider
    @Rule
    @JvmField
    var testSchedulerRule = RxSchedulerRule()

    private lateinit var useCase: GetTaskListUseCase

    @Before
    fun setup() {
        gateway = mockk(relaxed = true)
        scheduler = mockk(relaxed = true)
        useCase = GetTaskListUseCase(gateway, scheduler)
    }

    @Test
    fun execute_success() {
        every { gateway.getTasks() } returns Single.just(listOf(1,38, 281, 28, 7, 30))

        val testObserver =  useCase.execute(any()).test()
        testObserver.assertComplete()
        testObserver.assertNoErrors()
        testObserver.assertValue(listOf(1,38, 281, 28, 7, 30))
        verify(exactly = 1) { gateway.getTasks() }
    }

    @Test
    fun execute_error() {
        val exception = Exception()
        every { gateway.getTasks() } returns Single.error(exception)

        val testObserver =  useCase.execute(any()).test()
        testObserver.assertNotComplete()
        testObserver.assertError(exception)
        verify(exactly = 1) { gateway.getTasks() }
    }
}