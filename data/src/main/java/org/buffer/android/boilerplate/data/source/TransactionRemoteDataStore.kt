package org.buffer.android.boilerplate.data.source

import io.reactivex.Single
import org.buffer.android.boilerplate.data.model.TransactionEntity
import org.buffer.android.boilerplate.data.repository.TransactionDataStore
import org.buffer.android.boilerplate.data.repository.TransactionRemote
import javax.inject.Inject

/**
 * Implementation of the [TransactionDataStore] interface to provide a means of communicating
 * with the remote data source
 */
open class TransactionRemoteDataStore @Inject constructor(private val transactionRemote: TransactionRemote) :
        TransactionDataStore {


    /**
     * Retrieve a list of [TransactionEntity] instances from the API
     */
    override fun getTransactions(): Single<TransactionEntity> {
        return transactionRemote.getTransaction()
    }

}