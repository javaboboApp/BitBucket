package org.buffer.android.boilerplate.ui.injection.module

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import org.buffer.android.boilerplate.data.TransactionDataRepository
import org.buffer.android.boilerplate.data.executor.JobExecutor
import org.buffer.android.boilerplate.data.mapper.TransactionMapper
import org.buffer.android.boilerplate.data.repository.TransactionRemote
import org.buffer.android.boilerplate.data.source.TransactionDataStoreFactory
import org.buffer.android.boilerplate.domain.executor.PostExecutionThread
import org.buffer.android.boilerplate.domain.executor.ThreadExecutor
import org.buffer.android.boilerplate.domain.repository.TransactionsRepository
import org.buffer.android.boilerplate.remote.TransactionRemoteImpl
import org.buffer.android.boilerplate.remote.TransationService
import org.buffer.android.boilerplate.remote.TransationServiceFactory
import org.buffer.android.boilerplate.ui.BuildConfig
import org.buffer.android.boilerplate.ui.UiThread
import org.buffer.android.boilerplate.ui.injection.scopes.PerApplication

/**
 * Module used to provide dependencies at an application-level.
 */
@Module
open class ApplicationModule {

    @Provides
    @PerApplication
    fun provideContext(application: Application): Context {
        return application
    }




    @Provides
    @PerApplication
    internal fun provideTransactionRepository(factory: TransactionDataStoreFactory,
                                              mapper: TransactionMapper): TransactionsRepository {
        return TransactionDataRepository(factory, mapper)
    }


    @Provides
    @PerApplication
    internal fun provideTransactionRemote(service: TransationService,
                                          factory: org.buffer.android.boilerplate.remote.mapper.TransactionEntityMapper): TransactionRemote {
        return TransactionRemoteImpl(service, factory)
    }

    @Provides
    @PerApplication
    internal fun provideThreadExecutor(jobExecutor: JobExecutor): ThreadExecutor {
        return jobExecutor
    }

    @Provides
    @PerApplication
    internal fun providePostExecutionThread(uiThread: UiThread): PostExecutionThread {
        return uiThread
    }

    @Provides
    @PerApplication
    internal fun provideTransactionService(): TransationService {
        return TransationServiceFactory.makeTransactionService(BuildConfig.DEBUG)
    }
}
