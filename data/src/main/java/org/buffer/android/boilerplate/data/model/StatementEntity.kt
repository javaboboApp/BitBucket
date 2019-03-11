package org.buffer.android.boilerplate.data.model

/**
 * Representation for a [StatementEntity] fetched from the API
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

class StatementEntity(var from: String, val to: String, val dateTime: String, val credit: String,
                      val debit: String, val details: String, var status: String, val transactionID: Long,
                      var currencyCode:String, var reference: String?){

        override fun equals(o: Any?): Boolean {
            var obj = o as StatementEntity;
            if (obj != this)
                return false
            if(obj.hashCode() != this.hashCode())
                return false;


             return from.equals(obj.from)
        }
}