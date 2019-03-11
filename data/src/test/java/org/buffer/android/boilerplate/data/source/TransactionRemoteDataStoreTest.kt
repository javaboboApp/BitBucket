package org.buffer.android.boilerplate.data.source

import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.whenever
import io.reactivex.Single
import org.buffer.android.boilerplate.data.model.TransactionEntity
import org.buffer.android.boilerplate.data.repository.TransactionRemote
import org.buffer.android.boilerplate.data.test.factory.TransactionFactory
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class TransactionRemoteDataStoreTest {

    private lateinit var transactionRemoteDataStore: TransactionRemoteDataStore

    private lateinit var transactionRemote: TransactionRemote

    @Before
    fun setUp() {
        transactionRemote = mock()
        transactionRemoteDataStore = TransactionRemoteDataStore(transactionRemote)
    }

 

    //<editor-fold desc="Get Transaction">
    @Test
    fun getStatementsCompletes() {
        getTransaction(Single.just(TransactionFactory.makeTransactionEntity(10)))
        val testObserver = transactionRemote.getTransaction().test()
        testObserver.assertComplete()
    }
    private fun getTransaction(single: Single<TransactionEntity>) {
        whenever(transactionRemote.getTransaction())
                .thenReturn(single)
    }
    //</editor-fold>

}