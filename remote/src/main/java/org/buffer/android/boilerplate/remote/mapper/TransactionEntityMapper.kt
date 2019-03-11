package org.buffer.android.boilerplate.remote.mapper

import org.buffer.android.boilerplate.data.model.TransactionEntity
import org.buffer.android.boilerplate.remote.TransationService
import org.buffer.android.boilerplate.domain.model.Statement
import org.buffer.android.boilerplate.remote.models.TransactionModel
import javax.inject.Inject

/**
 * Map a [Statement] to and from a [TransactionEntity] instance when data is moving between
 * this later and the Data layer
 */
open class TransactionEntityMapper @Inject constructor(): EntityMapper<TransactionModel, TransactionEntity> {

    /**
     * Map an instance of a [Statement] to a [TransactionEntity] model
     */
    override fun mapFromRemote(type: TransactionModel): TransactionEntity {
        return TransactionEntity(type.culture, type.status,type.result.statements)
    }

}