package org.buffer.android.boilerplate.domain.model

import java.io.Serializable

/**
 * Representation for a [Statement] fetched from the API
 * from	"Bank"
to	"RedCloud"
dateTime	"2019-02-26T10:34:01.0306612Z"
credit	"75,30"
debit	"0,00"
details	"Credit to Merchant"
status	"Success"
transactionID	500199
currencyCode	"$"
reference	null
 */
class Statement(val from: String, val to: String,val dateTime: String?, val credit: String,
                val debit: String, val details: String, val status: String, val transactionID: Long,
                var currencyCode:String, var reference: String?) : Serializable