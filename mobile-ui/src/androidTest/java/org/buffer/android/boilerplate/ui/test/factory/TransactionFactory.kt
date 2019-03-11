package org.buffer.android.boilerplate.ui.test.factory.ui

import org.buffer.android.boilerplate.domain.model.Statement
import org.buffer.android.boilerplate.domain.model.Transaction
import org.buffer.android.boilerplate.ui.test.factory.ui.DataFactory.Factory.randomLong
import org.buffer.android.boilerplate.ui.test.factory.ui.DataFactory.Factory.randomUuid
import org.buffer.android.boilerplate.ui.test.factory.ui.DataFactory.Factory.randomUuidWithNulls

/**
 * Factory class for Transaction related instances
 */
class TransactionFactory {

    companion object Factory {

        fun makeStatementsList(count: Int): List<Statement> {
            val statements = mutableListOf<Statement>()
            repeat(count) {
                statements.add(makeStatement())
            }
            return statements
        }

          fun makeStatement() : Statement{
            return Statement(randomUuid(), randomUuid(),randomUuid(), randomUuid()
                    ,randomUuid(), randomUuid(),randomUuid(), randomLong(),randomUuid(), randomUuidWithNulls())
        }


        fun makeTransaction(countStatements: Int): Transaction {
            return Transaction(DataFactory.randomUuid(), DataFactory.randomUuid(), makeStatementsList(countStatements));
        }


    }

}