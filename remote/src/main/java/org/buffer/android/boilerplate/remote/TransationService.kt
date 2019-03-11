package org.buffer.android.boilerplate.remote

import io.reactivex.Single
import org.buffer.android.boilerplate.domain.model.Statement
import org.buffer.android.boilerplate.remote.models.TransactionModel
import retrofit2.http.GET

/**
 * Defines the abstract methods used for interacting with the Statement API
 */
interface TransationService {

    @GET("exam.json")
    fun getTransations(): Single<TransactionModel>



}
