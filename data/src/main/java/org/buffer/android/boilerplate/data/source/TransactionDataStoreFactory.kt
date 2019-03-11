package org.buffer.android.boilerplate.data.source

import org.buffer.android.boilerplate.data.repository.TransactionDataStore
import javax.inject.Inject

/**
 * Create an instance of a TransactionsDataStore
 */
open class TransactionDataStoreFactory @Inject constructor(
        private val transactionRemoteDataStore: TransactionRemoteDataStore) {



    /**
     * Return an instance of the Remote Data store
     */
    open fun retrieveDataStore(): TransactionDataStore {
        return transactionRemoteDataStore
    }

}