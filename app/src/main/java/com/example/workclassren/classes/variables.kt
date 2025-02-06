package com.example.workclassren.classes

//class variables {

    fun main () {

        // numeric variables
        val age: Int = 22
        val long_number: Long = 6282926
        val temperature: Float = 27.33f
        val weight: Double = 5.82827

        // string variables
        val gender: Char = 'M'
        val name: String = "Laysha"

        // bool variables
        val isGreater: Boolean = false

        // collection variables
        val names = arrayOf("Armando", "Juan", "Renatta")

        println(age)
        println(long_number)
        println(temperature)
        println(weight)
        println(gender)
        println(name)
        println(isGreater)
        println("Welcome $name, to your first Kotlin project")
        print(add())
        println(product(7, 3))
        printArray(names)

        val numbers = arrayOf(1,2,3,4,5,6,7,8,9,10)
    isEven(numbers)
    }

    fun add():Int {
        val x = 10
        val y = 5
        return (x + y)

    }
    fun product(x:Int, y:Int):Int {
        return (x + y)
    }
    fun printArray(names:Array<String>) {
        println(names)
        for (name in names) {
            println("Hello $name")
        }
    }
    fun isEven(numbers:Array<Int>){
        for (number in numbers){
            if(number % 2 == 0){
                println("the number $number is even")
            } else {
                println("the number $number is add")
            }
        }
    }

