package com.example.calculatorproject

fun main() {
    val calc = Calculator()
    println("1 더하기 2 결과는 : ${calc.addOperation(AddOperation(), 1, 2)} 입니다")
    println("1 빼기 2 결과는 : ${calc.subtractOperation(SubtractOperation(), 1, 2)} 입니다")
    println("1 곱하기 2 결과는 : ${calc.multiflyOperation(MultiflyOperation(), 1, 2)} 입니다")
    println("1 나누기 2 결과는 : ${calc.divideOperation(DivideOperation(), 1, 2)} 입니다")


}

class AddOperation{
    fun operate(num1: Int, num2: Int): Double = (num1 + num2).toDouble()
}

class SubtractOperation{
    fun operate(num1: Int, num2: Int): Double = (num1 - num2).toDouble()
}

class MultiflyOperation{
    fun operate(num1: Int, num2: Int): Double = (num1 * num2).toDouble()
}

class DivideOperation{
    fun operate(num1: Int, num2: Int): Double = (num1.toDouble() / num2.toDouble())
}


class Calculator {
    fun addOperation(A: AddOperation, num1: Int, num2: Int): Double {
        return A.operate(num1, num2)
    }

    fun subtractOperation(A: SubtractOperation, num1: Int, num2: Int): Double {
        return A.operate(num1, num2)

    }

    fun multiflyOperation(A: MultiflyOperation, num1: Int, num2: Int): Double {
        return A.operate(num1, num2)
    }

    fun divideOperation(A: DivideOperation, num1: Int, num2: Int): Double {
        return A.operate(num1, num2)
    }


}