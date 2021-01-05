package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class Calculate : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculate)

        val operator:Operator= Operator()
        Log.d("더하기",""+operator.plus(4,5))
        Log.d("빼기",""+operator.minus(4,5))
        Log.d("곱하기",""+operator.multi(4,5))

        val operator2:Operator2=Operator2()
        Log.d("더하기",""+operator2.plus(1,2,3,4,5))
        Log.d("빼기",""+operator2.minus(10,1,2,3))
        Log.d("곱하기",""+operator2.multi(1,2,3,4))
        Log.d("나누기",""+operator2.divide(12,2,3))

        val operator3:Operator3= Operator3(12)
        Log.d("곱하고 나누기",""+operator3.multi(2).divide(6))
                                          //operator3(24).divide(6)

    }
}
class Operator(){
    fun plus(a: Int, b: Int): Int {
        return a+b
    }
    fun minus(a: Int, b: Int): Int{
        return a-b
    }
    fun multi(a: Int, b: Int): Int{
        return a*b
    }
    fun divi(a: Int, b: Int): Int{
        return a/b
    }
}

class Operator2(){
    fun plus(vararg number:Int):Int{
        var result =0
        number.forEach{
            result+=it
        }
        return result
    }
    fun minus(vararg number: Int):Int{
        var result:Int=number[0]
        for(i in 0 until number.size){
            if(i!=0){
                result -=number[i]
            }
        }
        return result
    }
    fun multi(vararg number:Int):Int{
       var result:Int=1
        number.forEach{
            result=result*it
        }
        return result
    }
    fun divide(vararg number: Int):Int {
        var result: Int = number[0]
        number.forEachIndexed { index, value ->
            if (index != 0 && value != 0) {
                result = result / value
            }
        }
            return result
    }
}

class Operator3(val initialValue:Int){
    fun plus(number:Int):Operator3{
        //반환값이 Operator3 -> 뒤에 이어 다른 멤버함수를 붙여 사용하겠다는 뜻
        val result=this.initialValue+number
        return Operator3(result)
    }
    fun minus(number:Int):Operator3{
        val result=this.initialValue-number
        return Operator3(result)
    }
    fun multi(number:Int):Operator3{
        val result=this.initialValue*number
        return Operator3(result)
    }
    fun divide(number:Int):Operator3{
        val result=this.initialValue/number
        return Operator3(result)
    }
}