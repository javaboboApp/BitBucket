package org.buffer.android.boilerplate.presentation.browse

import org.buffer.android.boilerplate.domain.model.Statement
import org.buffer.android.boilerplate.presentation.BasePresenter
import org.buffer.android.boilerplate.presentation.BaseView
import org.buffer.android.boilerplate.presentation.model.TransationView

/**
 * Defines a contract of operations between the Browse Presenter and Browse View
 */
interface TransactionContract {

    interface View : BaseView<Presenter> {

        fun showProgress()

        fun hideProgress()

        fun showStataments(transations: List<Statement>)

        fun hideTransictions()

        fun showErrorState()

        fun hideErrorState()

        fun showEmptyState()

        fun hideEmptyState()

    }

    interface Presenter : BasePresenter {

        fun retrieveTransactions()

    }

}