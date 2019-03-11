package org.buffer.android.boilerplate.domain.interactor.browse

import io.reactivex.Single
import org.buffer.android.boilerplate.domain.executor.PostExecutionThread
import org.buffer.android.boilerplate.domain.executor.ThreadExecutor
import org.buffer.android.boilerplate.domain.interactor.SingleUseCase
import org.buffer.android.boilerplate.domain.model.Transaction
import org.buffer.android.boilerplate.domain.repository.TransactionsRepository
import javax.inject.Inject

/**
 * Use case used for retreiving a [List] of [Transaction] instances from the [TransactionsRepository]
 */
open class GetTransactions @Inject constructor(val transactionRepository: TransactionsRepository,
                                               threadExecutor: ThreadExecutor,
                                               postExecutionThread: PostExecutionThread):
        SingleUseCase<Transaction, Void?>(threadExecutor, postExecutionThread) {

    public override fun buildUseCaseObservable(params: Void?): Single<Transaction> {
        return transactionRepository.getTransactions()
    }

}