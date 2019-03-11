package org.buffer.android.boilerplate.ui.injection.module

import dagger.Module
import dagger.Provides
import org.buffer.android.boilerplate.domain.interactor.browse.GetTransactions
import org.buffer.android.boilerplate.presentation.browse.TransactionContract
import org.buffer.android.boilerplate.presentation.browse.TransactionPresenter
import org.buffer.android.boilerplate.presentation.mapper.TransationMapper
import org.buffer.android.boilerplate.ui.browse.BrowseActivity
import org.buffer.android.boilerplate.ui.injection.scopes.PerActivity



/**
 * Module used to provide dependencies at an activity-level.
 */
@Module
open class BrowseActivityModule {

    @PerActivity
    @Provides
    internal fun provideBrowseView(browseActivity: BrowseActivity): TransactionContract.View {
        return browseActivity
    }

    @PerActivity
    @Provides
    internal fun provideBrowsePresenter(mainView: TransactionContract.View,
                                        getTransactions: GetTransactions):
            TransactionContract.Presenter {
        return TransactionPresenter(mainView, getTransactions)
    }

}
