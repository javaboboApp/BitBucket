package org.buffer.android.boilerplate.data.mapper

import org.buffer.android.boilerplate.data.model.TransactionEntity
import org.buffer.android.boilerplate.domain.model.Transaction
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class TransactionMapperTest {

    private lateinit var transactionMapper: TransactionMapper

   /* @Before
    fun setUp() {
        transactionMapper = TransactionMapper()
    }

    @Test
    fun mapFromEntityMapsData() {
        val bufferooEntity = TransacionFactory.makeTransactionEntity(count)
        val bufferoo = transactionMapper.mapFromEntity(bufferooEntity)

        assertBufferooDataEquality(bufferooEntity, bufferoo)
    }

    @Test
    fun mapToEntityMapsData() {
        val cachedBufferoo = TransacionFactory.makeTransaction()
        val bufferooEntity = transactionMapper.mapToEntity(cachedBufferoo)

        assertBufferooDataEquality(bufferooEntity, cachedBufferoo)
    }*/

    private fun assertBufferooDataEquality(transactionEntity: TransactionEntity,
                                           transaction: Transaction) {
       /* assertEquals(transactionEntity.name, transaction.name)
        assertEquals(transactionEntity.title, transaction.title)
        assertEquals(transactionEntity.avatar, transaction.avatar)*/
    }

}