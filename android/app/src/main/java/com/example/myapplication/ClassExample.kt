package com.example.myapplication

class ClassExample {

}
class Car{
    lateinit var engine: String
    lateinit var body: String
    lateinit var door: String

    constructor(Engine: String, Body: String, Door: String){
        this.engine=Engine
        this.body=Body
        this.door=Door
        //생성자(함수의 형태임)
    }
    constructor(Engine: String,Body: String){
        this.engine=Engine
        this.body=Body
    }
}

class RunableCar(engine: String, body: String){
    fun navi(destination: String){
        println("목적지는 $destination 입니다.")
    }
}
fun main(array: Array<String>) {
    val supercar: Car = Car("good", "big", "white")
    val supercar1: Car= Car("soso","simple")

    val runableCar: RunableCar= RunableCar("bad","small")
    runableCar.navi("서울")

}