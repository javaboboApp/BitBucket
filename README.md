

   # Requirements for the app:
1) (Ticket : TICKET-1) When the app is launched it should fetch all the transactions from:
GET http://private-55d5f0-redcloud.apiary-mock.com/transactions
2) (Ticket : TICKET-2) Display the list of transactions in a view.
3) (Ticket : TICKET-3) Clicking a transaction should show the information about the transaction
in a new screen.
4) (Ticket : TICKET-4) When the transactions are viewed they should be identifiable visually if
they are credit or debit.


In this project I use clean architecture for solve a comom problem.

In the next image we can see how clean architecture is divided in differents abstraction layer.


<p align="center">
  <img  src="https://raw.githubusercontent.com/ImangazalievM/CleanArchitectureManifest/master/images/CleanArchitectureManifest.png">
</p>


I have tested the app in all the layers (presentacion,domain,ui,data,remote)

I have used the next tecnologies to resolve the problem:

 + Kotlin
 + Retrofit
 + Rxjava
 + Mokito
 + Expresso
