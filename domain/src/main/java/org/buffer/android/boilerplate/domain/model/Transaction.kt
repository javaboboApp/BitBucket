package org.buffer.android.boilerplate.domain.model

/**
 * Representation for a [Transaction] fetched from an external layer data source
 */
data class Transaction(val culture: String, val status: String, val statements: List <Statement>)