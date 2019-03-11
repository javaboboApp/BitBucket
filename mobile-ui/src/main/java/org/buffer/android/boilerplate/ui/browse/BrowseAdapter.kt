package org.buffer.android.boilerplate.ui.browse

import android.content.ClipData
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import org.buffer.android.boilerplate.domain.model.Statement
import org.buffer.android.boilerplate.ui.R
import javax.inject.Inject

class BrowseAdapter @Inject constructor(): RecyclerView.Adapter<BrowseAdapter.ViewHolder>() {

    var transactions: List<Statement> = arrayListOf()



    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val element = transactions[position]
        holder.from.text ="From: "+ element.from
        holder.to.text = "To: " +element.to

        holder.details.text = element.details

       holder.status.text = "Status: " + element.status

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater
                .from(parent.context)
                .inflate(R.layout.item_transaction, parent, false)
        return ViewHolder(itemView)
    }



    override fun getItemCount(): Int {
        return transactions.size
    }

    fun getItem( elem : Int): Statement{
        return transactions[elem];
    }

    inner class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        var from: TextView
        var to: TextView

        var details: TextView

        var status: TextView
        private var view: View = v

        init {

            from = view.findViewById(R.id.from)
            to = view.findViewById(R.id.to)

            details = view.findViewById(R.id.details)

            status  =view.findViewById(R.id.status)

        }


    }

}