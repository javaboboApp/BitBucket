package org.buffer.android.boilerplate.data.mapper

import org.buffer.android.boilerplate.data.model.StatementEntity
import org.buffer.android.boilerplate.data.model.TransactionEntity
import org.buffer.android.boilerplate.domain.model.Statement
import org.buffer.android.boilerplate.domain.model.Transaction
import javax.inject.Inject
import javax.naming.OperationNotSupportedException


/**
 * Map a [TransactionEntity] to and from a [Transaction] instance when data is moving between
 * this later and the Domain layer
 */
open class StatementMapper @Inject constructor(): Mapper<StatementEntity, Statement> {

    /**
     * Map a [TransactionEntity] instance to a [Transaction] instance
     * val from: String, val to: String, val dateTime: String, val credit: String,
    val debit: String, val details: String, val status: String, val transactionID: Integer,
    var currencyCode:String, var reference: String
     */
    override fun mapFromEntity(type: StatementEntity): Statement {
        return Statement(type.from, type.to, type.dateTime,type.credit,type.debit,type.details,
                type.status,type.transactionID,type.currencyCode,type.reference)




    }

    /**
     * Map a [Transaction] instance to a [TransactionEntity] instance
     */
    override fun mapToEntity(type: Statement): StatementEntity {
        throw OperationNotSupportedException();
    }


}