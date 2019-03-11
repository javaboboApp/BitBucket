package org.buffer.android.boilerplate.domain.usecase.transaction

import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import io.reactivex.Single
import org.buffer.android.boilerplate.domain.executor.PostExecutionThread
import org.buffer.android.boilerplate.domain.executor.ThreadExecutor
import org.buffer.android.boilerplate.domain.interactor.browse.GetTransactions
import org.buffer.android.boilerplate.domain.model.Transaction
import org.buffer.android.boilerplate.domain.repository.TransactionsRepository
import org.buffer.android.boilerplate.domain.test.factory.TransactionFactory
import org.junit.Before
import org.junit.Test

class GetTransactionsTest {

    private lateinit var getTransaction: GetTransactions

    private lateinit var mockThreadExecutor: ThreadExecutor
    private lateinit var mockPostExecutionThread: PostExecutionThread
    private lateinit var mockTransactionRepository: TransactionsRepository

    @Before
    fun setUp() {
        mockThreadExecutor = mock()
        mockPostExecutionThread = mock()
        mockTransactionRepository = mock()
        getTransaction = GetTransactions(mockTransactionRepository, mockThreadExecutor,
                mockPostExecutionThread)
    }

    @Test
    fun buildUseCaseObservableCallsRepository() {
        getTransaction.buildUseCaseObservable(null)
        //Verify if getTransaction is called
        verify(mockTransactionRepository).getTransactions()
    }

    @Test
    fun buildUseCaseObservableCompletes() {
        stubTransactionRepositoryGetTrasaction(Single.just(TransactionFactory.makeTransaction(10)))
        val testObserver = getTransaction.buildUseCaseObservable(null).test()
        testObserver.assertComplete()
    }

    @Test
    fun buildUseCaseObservableReturnsData() {
       val transaction = TransactionFactory.makeTransaction(10)
        stubTransactionRepositoryGetTrasaction(Single.just(transaction))
        val testObserver = getTransaction.buildUseCaseObservable(null).test()
        testObserver.assertValue(transaction)
    }

    private fun stubTransactionRepositoryGetTrasaction(single: Single<Transaction>) {
        whenever(mockTransactionRepository.getTransactions())
                .thenReturn(single)
    }

}