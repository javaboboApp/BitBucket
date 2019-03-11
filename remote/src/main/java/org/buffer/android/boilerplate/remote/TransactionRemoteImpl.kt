package org.buffer.android.boilerplate.remote

import io.reactivex.Single
import org.buffer.android.boilerplate.data.model.TransactionEntity
import org.buffer.android.boilerplate.data.repository.TransactionRemote
import org.buffer.android.boilerplate.remote.mapper.TransactionEntityMapper
import javax.inject.Inject

/**
 * Remote implementation for retrieving Transaction instances. This class implements the
 * [TransactionRemote] from the Data layer as it is that layers responsibility for defining the
 * operations in which data store implementation layers can carry out.
 */
class TransactionRemoteImpl @Inject constructor(private val transationService: TransationService,
                                                private val entityMapper: TransactionEntityMapper) :
        TransactionRemote {

    /**
     * Retrieve a list of [TransactionEntity] instances from the [TransationService].
     */
    override fun getTransaction(): Single<TransactionEntity> {
        return transationService.getTransations()
                .map {

                    entityMapper.mapFromRemote(it)
                }
    }

}