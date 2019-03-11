package org.buffer.android.boilerplate.data.repository

import io.reactivex.Single
import org.buffer.android.boilerplate.data.model.TransactionEntity

/**
 * Interface defining methods for the caching of Bufferroos. This is to be implemented by the
 * cache layer, using this interface as a way of communicating.
 */
interface TransactionRemote {

    /**
     * Retrieve a list of Bufferoos, from the cache
     */
    fun getTransaction(): Single<TransactionEntity>

}