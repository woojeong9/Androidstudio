package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class Account : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val account:AccountMake=AccountMake("우정","20020101",10000)
        Log.d("잔고확인",""+account.checkBalance())
        Log.d("출금",""+account.withdraw(20000))
        Log.d("출금",""+account.withdraw(1000))
        Log.d("입금",""+account.save(5000))
        Log.d("잔고확인2",""+account.checkBalance())

        val account2:AccountMaker2= AccountMaker2("권우정","20020101",-10000)
        Log.d("잔고확인2",""+account2.checkBalance())
        Log.d("입금",""+account2.save(20000))
        Log.d("출금",""+account2.withdraw(5000))
        Log.d("잔고확인2-1",""+account2.checkBalance())
    }
}
class AccountMake(var Name:String, var Date:String, var Balance:Int){
    fun checkBalance(): Int{
        return Balance
    }
    fun withdraw(amount: Int):Boolean{
        if(Balance>=amount){
            Balance-=amount
            return true
        }
        else{
            return false
        }
    }
    fun save(amount:Int){
        Balance+=amount
    }
}
class AccountMaker2{
    lateinit var name:String
    lateinit var date:String
    var balance:Int = 0
    constructor(Name:String,Date: String,Balance: Int){
        this.name=Name
        this.date=Date
        this.balance=Balance

        if(Balance>=0){
            this.balance=Balance
        }
        else{
            this.balance=0
        }
    }
    fun checkBalance(): Int{
        return balance
    }
    fun withdraw(amount: Int):Boolean{
        if(balance>=0){
            balance-=amount
            return true
        }
        else{
            return false
        }
    }
    fun save(amount: Int){
        balance+=amount
    }

}

class AccountMaker3(var Name: String, var Date: String, var Balance: Int=1000){
    fun checkBalance():Int{
        return Balance
    }
    fun withdraw(amount: Int):Boolean{
        if(Balance>=amount){
            Balance-=amount
            return true
        }
        else{
            return false
        }
    }
    fun save(amount: Int){
        Balance+=amount
    }
}
