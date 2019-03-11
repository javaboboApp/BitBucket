package org.buffer.android.boilerplate.presentation.mapper

import org.buffer.android.boilerplate.domain.model.Transaction
import org.buffer.android.boilerplate.presentation.model.TransationView
import javax.inject.Inject

/**
 * Map a [TransationView] to and from a [Transaction] instance when data is moving between
 * this layer and the Domain layer
 */
open class TransationMapper @Inject constructor(): Mapper<TransationView, Transaction> {

    /**
     * Map a [Transaction] instance to a [TransationView] instance
     */
    override fun mapToView(type: Transaction): TransationView {
        return TransationView(type.culture, type.status)
    }


}