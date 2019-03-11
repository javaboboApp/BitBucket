package org.buffer.android.boilerplate.remote.test.factory

import org.buffer.android.boilerplate.data.model.StatementEntity
import org.buffer.android.boilerplate.data.model.TransactionEntity
import org.buffer.android.boilerplate.domain.model.Statement
import org.buffer.android.boilerplate.domain.model.Transaction
import org.buffer.android.boilerplate.remote.models.TransactionModel

/**
 * Factory class for Transaction related instances
 */
class TransactionFactory {

    companion object Factory {

        fun makeTransactionResponse(): TransactionModel {

            val transactionResponse: TransactionModel = TransactionModel();
            transactionResponse.culture = DataFactory.randomUuid();
            transactionResponse.status = DataFactory.randomUuid();
            transactionResponse.result = TransactionModel.Result()
            transactionResponse.result.statements =makeStatementsEntities(5)
            return transactionResponse
        }


        fun makeStatementEntity() : StatementEntity{
            return StatementEntity(DataFactory.randomUuid(), DataFactory.randomUuid(), DataFactory.randomUuid(), DataFactory.randomUuid()
                    , DataFactory.randomUuid(), DataFactory.randomUuid(), DataFactory.randomUuid(), DataFactory.randomLong(), DataFactory.randomUuid(), DataFactory.randomUuidWithNulls())
        }

        fun makeStatementsEntities(count: Int) : List<StatementEntity> {
            val statementsEntities = mutableListOf<StatementEntity>()
            repeat(count) {
                statementsEntities.add(makeStatementEntity())
            }
            return statementsEntities
        }

    }

}