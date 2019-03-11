package org.buffer.android.boilerplate.remote.mapper

import org.buffer.android.boilerplate.remote.test.factory.TransactionFactory
import org.junit.Assert.assertThat
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import kotlin.test.assertEquals

@RunWith(JUnit4::class)
class TransactionEntityMapperTest {

    private lateinit var transactionEntityMapper: TransactionEntityMapper

    @Before
    fun setUp() {
        transactionEntityMapper = TransactionEntityMapper()
    }

    @Test
    fun mapFromRemoteMapsData() {
        var transactionModel = TransactionFactory.makeTransactionResponse()
        val transactionEntity = transactionEntityMapper.mapFromRemote(transactionModel)

        assertEquals(transactionModel.culture, transactionEntity.culture)
        assertEquals(transactionModel.status, transactionEntity.status)

        val sizea: Int = transactionModel.result.statements.size;
        val sizeb = transactionEntity.statements.size

        assertEquals(sizea, sizeb)


        for (it in transactionModel.result.statements.indices) {
            assertEquals(transactionModel.result.statements[it].status, transactionEntity.statements[it].status)
            assertEquals(transactionModel.result.statements[it].from, transactionEntity.statements[it].from)
            assertEquals(transactionModel.result.statements[it].to, transactionEntity.statements[it].to)
            assertEquals(transactionModel.result.statements[it].transactionID, transactionEntity.statements[it].transactionID)
            assertEquals(transactionModel.result.statements[it].credit, transactionEntity.statements[it].credit)
            assertEquals(transactionModel.result.statements[it].currencyCode, transactionEntity.statements[it].currencyCode)
            assertEquals(transactionModel.result.statements[it].dateTime, transactionEntity.statements[it].dateTime)
            assertEquals(transactionModel.result.statements[it].debit, transactionEntity.statements[it].debit)
            assertEquals(transactionModel.result.statements[it].details, transactionEntity.statements[it].details)
            assertEquals(transactionModel.result.statements[it].reference, transactionEntity.statements[it].reference)
        }


    }

}