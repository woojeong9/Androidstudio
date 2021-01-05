package com.example.myapplication

class Calcuate1 {
    var num1: Int = 0
    var num2: Int = 0
    fun plus(): Int{
       return num1+num2
    }
    fun minus(): Int{
        return num1-num2
    }
    fun multiply(): Int{
       return num1*num2
    }
    fun divide(): Int{
       return num1/num2
    }
    constructor(Num1:Int,Num2:Int){
        this.num1=Num1
        this.num2=Num2
    }
}
fun main(){
    val calculate:Calcuate1=Calcuate1(Num1=10,Num2 = 2)
    println(calculate.plus())
    println(calculate.minus())
    println(calculate.multiply())
    println(calculate.divide())
}