package org.buffer.android.boilerplate.remote.models

import org.buffer.android.boilerplate.data.model.StatementEntity
import org.buffer.android.boilerplate.domain.model.Statement

 class TransactionModel {

    class Result {
        lateinit var statements: List<StatementEntity>
    }

    lateinit var culture: String
    lateinit var status: String
    lateinit var result: Result


}
