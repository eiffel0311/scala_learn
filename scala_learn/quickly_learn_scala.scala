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