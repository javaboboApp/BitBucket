package org.buffer.android.boilerplate.ui.browse

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import com.nhaarman.mockito_kotlin.whenever
import io.reactivex.Single
import io.reactivex.schedulers.TestScheduler
import org.buffer.android.boilerplate.domain.model.Statement
import org.buffer.android.boilerplate.domain.model.Transaction
import org.buffer.android.boilerplate.ui.R
import org.buffer.android.boilerplate.ui.test.TestApplication
import org.buffer.android.boilerplate.ui.test.factory.ui.TransactionFactory
import org.buffer.android.boilerplate.ui.test.util.RecyclerViewMatcher
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.util.concurrent.TimeUnit


@RunWith(AndroidJUnit4::class)
class BrowseActivityTest {

    @Rule
    @JvmField
    val activity = ActivityTestRule<BrowseActivity>(BrowseActivity::class.java, false, false)

    @Test
    fun activityLaunches() {
        stubTransactionRepositoryGetTransaction(Single.just(TransactionFactory.makeTransaction(2)))
        activity.launchActivity(null)
    }

    @Test
    fun statementsDisplay() {
        val transaction = TransactionFactory.makeTransaction(10)

        stubTransactionRepositoryGetTransaction(Single.just(transaction))
        activity.launchActivity(null)
        checkTransactionDetailsDisplay(transaction.statements, 0)
    }


    private fun checkTransactionDetailsDisplay(statements: List<Statement>, position: Int) {
        onView(RecyclerViewMatcher.withRecyclerView(R.id.recycler_browse).atPosition(position))
                .check(matches(hasDescendant(withText(statements[position].to))))

        onView(RecyclerViewMatcher.withRecyclerView(R.id.recycler_browse).atPosition(position))
                .check(matches(hasDescendant(withText(statements[position].details))))
    }

    private fun stubTransactionRepositoryGetTransaction(single: Single<Transaction>) {
        whenever(TestApplication.appComponent().transactionRepository().getTransactions())
                .thenReturn(single)
    }

}