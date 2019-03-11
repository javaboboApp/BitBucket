package org.buffer.android.boilerplate.remote

import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.whenever
import io.reactivex.Single
import org.buffer.android.boilerplate.data.model.TransactionEntity
import org.buffer.android.boilerplate.remote.mapper.TransactionEntityMapper
import org.buffer.android.boilerplate.remote.models.TransactionModel
import org.buffer.android.boilerplate.remote.test.factory.TransactionFactory
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class TransactionRemoteImplTest {

    private lateinit var entityMapper: TransactionEntityMapper
    private lateinit var transationService: TransationService

    private lateinit var transactionRemoteImpl: TransactionRemoteImpl

    @Before
    fun setup() {
        entityMapper = mock()
        transationService = mock()
        transactionRemoteImpl = TransactionRemoteImpl(transationService, entityMapper)
    }

    //<editor-fold desc="Get Transaction">
    @Test
    fun getTransactionCompletes() {
        stubTransactionServiceGetTransaction(Single.just(TransactionFactory.makeTransactionResponse()))
        val testObserver = transactionRemoteImpl.getTransaction().test()
        testObserver.assertComplete()
    }

    @Test
    fun getTransactionReturnsData() {
        val transfResponse: TransactionModel = TransactionFactory.makeTransactionResponse()
        stubTransactionServiceGetTransaction(Single.just(transfResponse))
        val tranEntity: TransactionEntity = entityMapper.mapFromRemote(transfResponse)
        val testObserver = transactionRemoteImpl.getTransaction().test()
        testObserver.assertValue(tranEntity)
    }
    //</editor-fold>

    private fun stubTransactionServiceGetTransaction(single: Single<TransactionModel>) {
        whenever(transationService.getTransations())
                .thenReturn(single)
    }
}