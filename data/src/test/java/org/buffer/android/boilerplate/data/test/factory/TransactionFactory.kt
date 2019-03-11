package org.buffer.android.boilerplate.data.test.factory

import org.buffer.android.boilerplate.data.model.StatementEntity
import org.buffer.android.boilerplate.data.model.TransactionEntity
import org.buffer.android.boilerplate.data.test.factory.DataFactory.Factory.randomLong
import org.buffer.android.boilerplate.data.test.factory.DataFactory.Factory.randomUuid
import org.buffer.android.boilerplate.data.test.factory.DataFactory.Factory.randomUuidWithNulls

/**
 * Factory class for Transaction related instances
 */
class TransactionFactory {

    companion object Factory {



        fun makeStatementEntity() : StatementEntity{
            return StatementEntity(randomUuid(), randomUuid(),randomUuid(), randomUuid()
                    ,randomUuid(), randomUuid(),randomUuid(), randomLong(),randomUuid(), randomUuidWithNulls())
        }

        fun makeStatementsEntities(count: Int) : List<StatementEntity> {
            val statementsEntities = mutableListOf<StatementEntity>()
            repeat(count) {
                statementsEntities.add(makeStatementEntity())
            }
            return statementsEntities
        }

        fun makeTransactionEntity(countStatements: Int): TransactionEntity {
             return TransactionEntity(randomUuid(), randomUuid(), makeStatementsEntities(countStatements));
        }



    }

}