package org.buffer.android.boilerplate.data.model

import org.buffer.android.boilerplate.domain.model.Statement

/**
 * Representation for a [TransactionEntity] fetched from an external layer data source
 */
data class TransactionEntity(val culture: String, val status: String, val statements: List<StatementEntity>)
