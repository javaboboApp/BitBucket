package org.buffer.android.boilerplate.data

import io.reactivex.Single
import org.buffer.android.boilerplate.data.mapper.TransactionMapper
import org.buffer.android.boilerplate.data.source.TransactionDataStoreFactory
import org.buffer.android.boilerplate.domain.model.Transaction
import org.buffer.android.boilerplate.domain.repository.TransactionsRepository
import javax.inject.Inject

/**
 * Provides an implementation of the [TransactionRepository] interface for communicating to and from
 * data sources
 */
class TransactionDataRepository @Inject constructor(private val factory: TransactionDataStoreFactory,
                                                    private val transactionMapper: TransactionMapper) :
        TransactionsRepository {




    override fun getTransactions(): Single<Transaction> {
        val dataStore = factory.retrieveDataStore()
        return dataStore.getTransactions().map {
                        transactionMapper.mapFromEntity(it)

                }
    }

}