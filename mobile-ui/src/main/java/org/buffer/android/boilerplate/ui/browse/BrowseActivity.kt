package org.buffer.android.boilerplate.ui.browse

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.Toast
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_browse.*
import org.buffer.android.boilerplate.domain.model.Statement
import org.buffer.android.boilerplate.presentation.browse.TransactionContract
import org.buffer.android.boilerplate.ui.R
import javax.inject.Inject

class BrowseActivity: AppCompatActivity(), TransactionContract.View {

    @Inject lateinit var onboardingPresenter: TransactionContract.Presenter
    @Inject lateinit var browseAdapter: BrowseAdapter

    override fun setPresenter(presenter: TransactionContract.Presenter) {
        onboardingPresenter = presenter
    }

    override fun hideProgress() {
        progress.visibility = View.VISIBLE
    }

    override fun showProgress() {
        progress.visibility = View.GONE
    }

    override fun showStataments(list: List<Statement>) {
        browseAdapter.transactions = list
        browseAdapter.notifyDataSetChanged()
        recycler_browse.visibility = View.VISIBLE
    }

    override fun hideTransictions() {
        recycler_browse.visibility = View.VISIBLE
    }

    override fun showErrorState() {
    }

    override fun hideErrorState() {
    }

    override fun showEmptyState() {
    }

    override fun hideEmptyState() {
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_browse)
        AndroidInjection.inject(this)
        setupBrowseRecycler()
    }

    override fun onStart() {
        super.onStart()
        onboardingPresenter.start()

    }


    private fun setupBrowseRecycler() {
        recycler_browse.layoutManager = LinearLayoutManager(this)
        recycler_browse.adapter = browseAdapter
        recycler_browse.addOnItemClickListener(object: OnItemClickListener {
            override fun onItemClicked(position: Int, view: View) {
                val showDetailsTransactionIntent = Intent(view.context, DetailsTransactionActivity::class.java)
                showDetailsTransactionIntent.putExtra("item",browseAdapter.getItem(position))
                view.context.startActivity(showDetailsTransactionIntent)
                Toast.makeText(view.context, "Item: " +position+ "clicked",Toast.LENGTH_LONG).show()
            }
        })

    }
    interface OnItemClickListener {
        fun onItemClicked(position: Int, view: View)
    }

    fun RecyclerView.addOnItemClickListener(onClickListener: OnItemClickListener) {
        this.addOnChildAttachStateChangeListener(object: RecyclerView.OnChildAttachStateChangeListener {
            override fun onChildViewDetachedFromWindow(view: View?) {
                view?.setOnClickListener(null)
            }

            override fun onChildViewAttachedToWindow(view: View?) {
                view?.setOnClickListener({
                    val holder = getChildViewHolder(view)
                    onClickListener.onItemClicked(holder.adapterPosition, view)
                })
            }
        })
    }

}