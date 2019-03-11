package org.buffer.android.boilerplate.presentation.browse

import io.reactivex.observers.DisposableSingleObserver
import org.buffer.android.boilerplate.domain.interactor.browse.GetTransactions
import org.buffer.android.boilerplate.domain.model.Transaction
import org.buffer.android.boilerplate.presentation.mapper.TransationMapper
import javax.inject.Inject

class TransactionPresenter @Inject constructor(val browseView: TransactionContract.View,
                                               val getTransactionsUseCase: GetTransactions
                                             ):
        TransactionContract.Presenter {

    init {
        browseView.setPresenter(this)
    }

    override fun start() {
        retrieveTransactions()
    }

    override fun stop() {
        getTransactionsUseCase.dispose()
    }

    override fun retrieveTransactions() {
        getTransactionsUseCase.execute(TransactionSubscriber())
    }

    internal fun handleGetBufferoosSuccess(transactions: Transaction) {
        browseView.hideErrorState()
    if (transactions.statements.isNotEmpty()) {
            browseView.hideEmptyState()
            browseView.showStataments(transactions.statements)
      } else {
           browseView.hideTransictions()
           browseView.showEmptyState()
     }
    }

    inner class TransactionSubscriber: DisposableSingleObserver<Transaction>() {


        override fun onSuccess(t: Transaction) {
            handleGetBufferoosSuccess(t)
        }

        override fun onError(exception: Throwable) {
            browseView.hideTransictions()
            browseView.hideEmptyState()
            browseView.showErrorState()
        }

    }

}