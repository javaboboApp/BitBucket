package org.buffer.android.boilerplate.data.mapper

import org.buffer.android.boilerplate.data.model.TransactionEntity
import org.buffer.android.boilerplate.domain.model.Statement
import org.buffer.android.boilerplate.domain.model.Transaction
import javax.inject.Inject
import javax.naming.OperationNotSupportedException


/**
 * Map a [TransactionEntity] to and from a [Transaction] instance when data is moving between
 * this later and the Domain layer
 */
open class TransactionMapper @Inject constructor(private val statementMapper: StatementMapper):
        Mapper<TransactionEntity, Transaction> {


    /**
     * Map a [TransactionEntity] instance to a [Transaction] instance
     */
    override fun mapFromEntity(type: TransactionEntity): Transaction {
        var myList: ArrayList<Statement> = ArrayList<Statement>()
        for (i in type.statements ) {
          myList.add( statementMapper.mapFromEntity(i))
        }

        return Transaction(type.culture, type.status,myList)


    }

    /**
     * Map a [Transaction] instance to a [TransactionEntity] instance
     */
    override fun mapToEntity(type: Transaction): TransactionEntity {
        throw OperationNotSupportedException();
    }


}