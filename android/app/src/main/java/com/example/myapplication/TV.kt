package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class TV : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val tv =TvMake(listOf<String>("KBS","MBC","SBS"))
        tv.switch()
        Log.d("TV",""+tv.onoff)
        tv.channelUp()
        tv.channelUp()
        tv.channelUp()
        tv.channelUp()
        Log.d("TV",""+tv.checkCurrentChannel())
        tv.channelDown()
        tv.channelDown()
        Log.d("TV",""+tv.checkCurrentChannel())


    }
}
class TvMake(val channels: List<String>){
    var onoff: Boolean=false
    var currentChannel=0
    set(value){
        field=value
        if(field>2){
            field=0
        }
        if(field<0){
            field=2
        }
    }
    get(){
        println("TV호출")
        return field
    }
    fun switch(){
        onoff=!onoff
    }
    fun channelUp(){
        channels.forEachIndexed{index,value->
            if(currentChannel==index){
                currentChannel+=1
                return
            }
        }
    }
    fun channelDown(){
        channels.forEachIndexed{index, value->
            if(currentChannel==index){
                currentChannel-=1
                return
            }
        }
    }
    fun checkCurrentChannel(): String{
        return channels[currentChannel]
    }
}