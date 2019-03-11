package org.buffer.android.boilerplate.ui.browse

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;
import android.view.View
import org.buffer.android.boilerplate.ui.R

import kotlinx.android.synthetic.main.activity_details_transaction.*
import kotlinx.android.synthetic.main.content_details_transaction.*
import org.buffer.android.boilerplate.domain.model.Statement

class DetailsTransactionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details_transaction)
        setSupportActionBar(toolbar)
        var bundle: Bundle? = intent.extras
        var s: Statement = bundle!!.getSerializable("item") as Statement;

        to.setText("To: " + s.to)
        from.setText("From: " + s.from)
        details.setText("Details: " + s.details)
        status.setText("Status: " + s.status)
        dateTime.setText(s.dateTime)
        if (!s.credit.equals("0,00")) {
            credit.setText(s.credit)
            contDebit.visibility = View.GONE
        } else {
            debit.setText(s.debit)
            contCredit.visibility = View.GONE
        }
        id.setText("Transaction ID: " + s.transactionID)
        if (s.reference == null) {
            reference.visibility = View.GONE
        } else
            reference.setText("Reference: " + s.reference)
        currencyCode.setText("Currency Code: " + s.currencyCode)

    }

}
