package org.buffer.android.boilerplate.presentation.browse

import com.nhaarman.mockito_kotlin.*
import io.reactivex.observers.DisposableSingleObserver
import org.buffer.android.boilerplate.domain.interactor.browse.GetTransactions
import org.buffer.android.boilerplate.domain.model.Transaction
import org.buffer.android.boilerplate.presentation.test.factory.TransactionFactory
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class TransactionPresenterTest {

    private lateinit var mockTransactionView: TransactionContract.View

    private lateinit var mockGetTransactions: GetTransactions

    private lateinit var transactionPresenter: TransactionPresenter
    private lateinit var captor: KArgumentCaptor<DisposableSingleObserver<Transaction>>

    @Before
    fun setup() {
        captor = argumentCaptor<DisposableSingleObserver<Transaction>>()
        mockTransactionView = mock()

        mockGetTransactions = mock()
        transactionPresenter = TransactionPresenter(mockTransactionView,
                mockGetTransactions)
    }

    //<editor-fold desc="Retrieve Bufferoos">
    @Test
    fun retrieveTransactionHidesErrorState() {
        transactionPresenter.retrieveTransactions()

        verify(mockGetTransactions).execute(captor.capture(), eq(null))
        captor.firstValue.onSuccess(TransactionFactory.makeTransaction(2))
        //Verify hideErrorState is colled
        verify(mockTransactionView).hideErrorState()
    }

    @Test
    fun retrieveTransactionHidesEmptyState() {
        transactionPresenter.retrieveTransactions()

        verify(mockGetTransactions).execute(captor.capture(), eq(null))

        captor.firstValue.onSuccess(TransactionFactory.makeTransaction(2))

        //Verify hideEmptyState is colled
        verify(mockTransactionView).hideEmptyState()
    }

    @Test
    fun retrieveTransacionShowsTransaction() {
        val transaction = TransactionFactory.makeTransaction(2)

        transactionPresenter.retrieveTransactions()

        verify(mockGetTransactions).execute(captor.capture(), eq(null))
        captor.firstValue.onSuccess(transaction)

        //Verify showStataments is colled
        verify(mockTransactionView).showStataments(transaction.statements)
    }

    @Test
    fun retrieveTransactionShowsEmptyState() {
        transactionPresenter.retrieveTransactions()

        verify(mockGetTransactions).execute(captor.capture(), eq(null))
        captor.firstValue.onSuccess(TransactionFactory.makeTransaction(0))
        verify(mockTransactionView).showEmptyState()
    }

    @Test
    fun retrieveTransactionHidesTransaction() {
        transactionPresenter.retrieveTransactions()

        verify(mockGetTransactions).execute(captor.capture(), eq(null))
        captor.firstValue.onSuccess(TransactionFactory.makeTransaction(0))
        verify(mockTransactionView).hideTransictions()
    }

    @Test
    fun retrieveTransactionShowsErrorState() {
        transactionPresenter.retrieveTransactions()

        verify(mockGetTransactions).execute(captor.capture(), eq(null))
        captor.firstValue.onError(RuntimeException())
        verify(mockTransactionView).showErrorState()
    }

    @Test
    fun retrieveTransactionHidesTransactionWhenErrorThrown() {
        transactionPresenter.retrieveTransactions()

        verify(mockGetTransactions).execute(captor.capture(), eq(null))
        captor.firstValue.onError(RuntimeException())
        verify(mockTransactionView).hideTransictions()
    }

    @Test
    fun retrieveTransactionHidesEmptyStateWhenErrorThrown() {
        transactionPresenter.retrieveTransactions()

        verify(mockGetTransactions).execute(captor.capture(), eq(null))
        captor.firstValue.onError(RuntimeException())
        verify(mockTransactionView).hideEmptyState()
    }
    //</editor-fold>

}