package org.buffer.android.boilerplate.data.source

import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.whenever
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class TransactionDataStoreFactoryTest {

    private lateinit var transactionDataStoreFactory: TransactionDataStoreFactory


    private lateinit var transactionRemoteDataStore: TransactionRemoteDataStore

    @Before
    fun setUp() {
        //We create the object using the function mock()
        transactionRemoteDataStore = mock()
        //We create the objecto transactionDataStoreFactory using the moked object
        transactionDataStoreFactory = TransactionDataStoreFactory(transactionRemoteDataStore)
    }

    //<editor-fold desc="Retrieve Data Store">
    @Test
    fun retrieveDataStoreWhenNotCachedReturnsRemoteDataStore() {

        val bufferooDataStore = transactionDataStoreFactory.retrieveDataStore()
        assert(bufferooDataStore is TransactionRemoteDataStore)
    }



    //</editor-fold>




}