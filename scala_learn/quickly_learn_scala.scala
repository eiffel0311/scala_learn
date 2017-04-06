/*
第一章 基础
*/
// 1 变量, 常量
var a = 1
val b = 1

// 2 常用数据类型
var byte: Byte = 1
var char: Char = 'c'
var short: Short = 1
var int: Int = 1
var long: Long = 1
var float: Float = 1
var double: Double = 1

val boolean: Boolean = false


/*
第二章 控制结构和函数
*/
// 1 if else
var tag = 1
if (tag == 1)
  println("if")
else if (tag == 2)
  println("else if")
else
  println("else")

// 2 代码块, 代码块返回值
var block = {if (1==1) 1 else 2}
println(block)

// 3 while
var while_index = 1
while (while_index < 3){
  println("i am while_index: " + while_index)
  while_index = while_index + 1
}

// 4 for
// --------------基本for循环
for(i <- 1 to 3){
  println("i am for index: " + i)
}

for(i <- 0 until 3){
  println("i am for index2: " + i)
}

for(i <- Range(0, 3)){
  println("i am for index3: " + i)
}

for(i <- "abcd"){
  println("i am for index4: " + i)
}
// --------------基本for循环

// --------------高级for循环， 推导式
// 循环嵌套
for(i <- 1 to 2; j <- 1 to 3){printf("%d + %d = %d\n", i, j, i + j)}
// 循环守卫
for(i <- 1 to 2; j <- 1 to 3 if i == j){printf("%d + %d = %d\n", i, j, i + j)}
// 循环中随意定义
for(i <- 1 to 2; from = i; j <- from to 3){printf("%d + %d = %d\n", i, j, i + j)}
// 循环构造集合
var for_vector = for(i <- 1 to 2; j <- 1 to 3) yield i + j
println(for_vector)
// --------------高级for循环， 推导式

// 5 函数
def test_function(x: Double): Double = {
  x
}
println(test_function(11))
// 默认参数，带名参数, 变长参数
def test_function2(x: Double, y: Double = 1): Double = {
  x + y
}
println(test_function2(1))
println(test_function2(1, 2))
println(test_function2(x = 1, y = 2))
def test_function3(x: Double, y:Double*): Double = {
  var sum = x
  for(i <- y){
    sum = sum + i
  }
  sum
}
println(test_function3(1, 1, 2, 3))

// 6 懒值， 第一次初始化是在使用的时候
lazy val lazy_val = 1
println(lazy_val)


/*
第三章 数组和相关操作
*/
// 1 定长， 变长数组
var array1 = new Array[Int](2)
array1(0) = 0
array1(1) = 1
var array2 = Array[Int](1, 2, 3)

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer
val array3 = new ArrayBuffer[Int]()
array3 += (1, 2, 3)
array3.insert(2, 6)
// 数组遍历
for(i <- array3){
  println(i)
}
// 多维数组
var metrix = Array.ofDim[Double](3, 4)
metrix(0)(0) = 1


/*
第四章 映射和元组
*/
// 1 映射 可变， 不可变
val map1 = Map("1" -> 1, "2" -> 2)
val map2 = new mutable.HashMap[String, Int]()
map2.put("1", 1)
map2.put("2", 2)
map2.put("3", 3)

map2.remove("1")
map2("2") = 4

for((k, v) <- map2){
  printf("key: %s   value: %s\n", k, v)
}

// 2 元组， 包含不同类型的集合
val tupple = (1, 1.1, "test")
println(tupple._1)
println(tupple._2)
println(tupple._3)


/*
第五章 类
 */
// 1 简单类
class testClass(){

  private var myage: Int = 0
  var name: String = "Tom"

  def testMethod(x: Int): Unit ={
    printf("i am testMethod, params is %d \n", x)
  }

  // getter setter 方法
  def age = myage

  def age_=(age: Int): Unit ={
    myage = age
  }

}

val mytestClass = new testClass()
mytestClass.testMethod(1)

printf("my age is : %s\n", mytestClass.age)
mytestClass.age = 21
printf("my age is : %s\n", mytestClass.age)

// public 字段自带setter, getter
printf("my name is : %s\n", mytestClass.name)
mytestClass.name = "Hack"
printf("my name is : %s\n", mytestClass.name)

// 2 辅助构造器

class Person(){

  private var nage: String = ""
  private var age: Int = 0
  private var address: String = ""

  def this(name: String){
    this()
    this.nage = name
  }

  def this(name: String, age: Int){
    this(name)
    this.age = age
  }

  def this(name: String, age: Int, address: String){
    this(name, age)
    this.address = address
  }
}
val person1 = new Person("Tom")
val person2 = new Person("Tom", 21)
val person3 = new Person("Tom", 21, "beijing")

// 3 主构造器, 同时 val 变量生成setter 方法， var 变量生成setter 和 getter 方法

class Person2(val name: String, val age: Int, var address: String){

}
val person2_1 = new Person2("Tome", 21, "beijing")
printf("name: %s  age: %d  address: %s\n", person2_1.name, person2_1.age, person2_1.address)

// 4 嵌套类

class Person3(){

  class Person4(){
    def testMethod(): Unit ={
      println("i am person4's test method")
    }
  }
  private var person:Person4 = new Person4()

  def testMethod(): Unit ={
    println("i am person3's test method")
    person.testMethod()
  }
}
var person3_1 = new Person3
person3_1.testMethod()