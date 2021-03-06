package org.buffer.android.boilerplate.domain.test.factory


import org.buffer.android.boilerplate.data.test.factory.DataFactory.Factory.randomLong
import org.buffer.android.boilerplate.data.test.factory.DataFactory.Factory.randomUuid
import org.buffer.android.boilerplate.data.test.factory.DataFactory.Factory.randomUuidWithNulls
import org.buffer.android.boilerplate.domain.model.Statement
import org.buffer.android.boilerplate.domain.model.Transaction

/**
 * Factory class for Transaction related instances
 */
class TransactionFactory {

    companion object Factory {



        fun makeStatement() : Statement{
            return Statement(randomUuid(), randomUuid(),randomUuid(), randomUuid()
                    ,randomUuid(), randomUuid(),randomUuid(), randomLong(),randomUuid(), randomUuidWithNulls())
        }

        fun makeStatements(count: Int) : List<Statement> {
            val statements = mutableListOf<Statement>()
            repeat(count) {
                statements.add(makeStatement())
            }
            return statements
        }

        fun makeTransaction(countStatements: Int): Transaction {
             return Transaction(randomUuid(), randomUuid(), makeStatements(countStatements));
        }



    }

}