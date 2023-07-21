package com.example.calculatorproject
//
//fun main() {
//
//    println("숫자1를 입력 : ")
//    var num1 = readLine()!!.toInt()
//    println("숫자2를 입력 : ")
//    var num2 = readLine()!!.toInt()
//
//    println("$num1 더하기 $num2 결과는: ${Calculator(AddOperation()).operate(num1, num2)} 입니다")
//    println("$num1 빼기 $num2 결과는:: ${Calculator(SubtractOperation()).operate(num1, num2)} 입니다")
//    println("$num1 곱하기 $num2 결과는: ${Calculator(MultiplyOperation()).operate(num1, num2)} 입니다")
//    println("$num1 나누기 $num2 결과는: ${Calculator(DivideOperation()).operate(num1, num2)} 입니다")
//}
//
//abstract class AbstractOperation {
//    abstract fun operate(num1: Int, num2: Int): Double
//}
//
//class Calculator(var operation: AbstractOperation) {
//    fun operate(num1: Int, num2: Int): Double {
//        return operation.operate(num1, num2)
//    }
//}
//
//class AddOperation : AbstractOperation() {
//    override fun operate(num1: Int, num2: Int) = (num1 + num2).toDouble()
//}
//
//class SubtractOperation : AbstractOperation() {
//    override fun operate(num1: Int, num2: Int) = (num1 - num2).toDouble()
//}
//
//class MultiplyOperation : AbstractOperation() {
//    override fun operate(num1: Int, num2: Int) = (num1 * num2).toDouble()
//}
//
//class DivideOperation : AbstractOperation() {
//    override fun operate(num1: Int, num2: Int) = (num1.toDouble() / num2.toDouble())
//}
