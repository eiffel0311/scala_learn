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


import scala.collection.immutable.ListSet
import scala.collection.{immutable, mutable}
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


/*
第六章 对象
 */

// 1 单例对象， 用来存放常量， 共享数据
object Account{
  private var lastNumber:Int = 0
  def newUniqNumber(): Int ={
    lastNumber = lastNumber + 1
    lastNumber
  }
}
// Account的构造器只会执行一次
println(Account.newUniqNumber())
println(Account.newUniqNumber())
println(Account.newUniqNumber())

// 数据库连接例子
object DBConection{
  private var dbConection: String = null
  def getInstance():String ={
    if(dbConection == null){
      dbConection = "you get a connection"
    }
    dbConection
  }
}
println(DBConection.getInstance())
println(DBConection.getInstance())

// 2 伴生对象(Object 的同名类)
class Account(){
  val id = Account.newUniqNumber()
}
println(new Account().id)

// 3 扩展类或特质的对象
abstract class UndoableAction(){ // 扩展类的方法可以实现， 也可以不实现
  def test():Unit
  def test2():Unit ={
    println("i am abstrac class method")
  }
}

trait UndoableAction2{} // 特质
trait UndoableAction3{}

object DoNoththing extends UndoableAction() with UndoableAction2 with UndoableAction3{ // 单继承多实现
  override def test(): Unit ={
    println("i was overwrite")
  }
  def myselfMethod(): Unit ={
    println("i blongs to myself")
  }
}
DoNoththing.test()
DoNoththing.myselfMethod()
DoNoththing.test2()

// 4 apply 方法, 借用伴生对象生成实例对象
class ApplyTest(){
  private var x: Int = 0
  def this(x: Int){
    this()
    this.x = x
  }
  def printtest():Unit ={
    println("i am test methods")
  }

}
object ApplyTest{
  def apply(x: Int): ApplyTest ={
    new ApplyTest(x)
  }
}
val myApplyTest = ApplyTest(1)
myApplyTest.printtest()

// 5 应用程序对象， 继承App， main 方法的替代
object AppClass{
  def main(args: Array[String]): Unit ={
    println("i am main methods")
  }
}

object AppClass2 extends  App{
  println("i am main methods")
}

// 6 枚举, 主要用来保存常量
object TrafficLightColor extends Enumeration{
  val Red = 1
  val Yellow = 2
  val Green = 3
}
println(TrafficLightColor.Red)
println(TrafficLightColor.Yellow)
println(TrafficLightColor.Green)

/*
第七章 包和引入, 代码参考package_ex.scala
 */
// 1 包的手动编译执行
// 创建维文件 package_ex.scala, 添加如下代码：
/*
package pack1.pack2

class testClass(){
  def testMethods():Unit ={
    println("i am package test class method")
  }
}
*/
// 执行命令scalac package_ex.scala， 然后执行如下脚本， 必要的时候使用 -cp 参数
// import pack1.pack2
// new pack1.pack2.testClass().testMethods()


// 2 包的命名 以及 作用域规则
// 顶文件头写 package a.b.c
// 嵌套 package a{ package b{ package c}}
// 作用越 package 内部可以向上访问



// 3 串联式包语句
// package a.b { package {}}


// 4 文件顶部标记
// pack a.b.c

// 5 包对象
/*
package pack1.pack2

class testClass(){
  def testMethods():Unit ={
    println("i am package test class method")
  }
}

package object testPackageOject{
  val name = "defaultName"
}
 */
// 可以直接访问name : pack1.pack2.testPackageObject.name

// 6 包的可见性, 实际定义方法的可见性
// private[pack2] 说明 此方法在pack2 下可见
// protected[pack2] 说明在 pack2 以及以下 可见


// 7 引入
// import a.b.TestClass
// import a.b.{TestClass, TestClass2}
// import a.b._


// 8 任何地方都可以引入
// 引入后， 效果向下延伸


// 9 重命名和隐藏方法
// 重命名
// import a.b.{TestClass => TestClass2}
// 隐藏引入， ex: TestClass 被隐藏， 解决类名冲突
// import a.b.{TestClass => _, _}


// 10 隐式引入, 已经引入， 不用显示引入的包
/*
import java.lang._
import scala._
import Predef._
 */

/*
10 继承

 */
// 抽象类
abstract class abstractClass{
  // 抽象字段
  val abstractField: String
  // 抽象方法
  def abstracMethod: String
}

class extendsClassFather() extends abstractClass{
  val abstractField = "defaultField"
  val name: String = "defaultName"
  // 受保护的字段, 可以被子类访问
  protected val age:Int = 21
  // 私有字段， 不能被子类访问
  private val address: String = "BeiJing"

  def abstracMethod():String ={""}

  def testMethod(): Unit={ println("i am do nothing")}
  // 类比字段
  protected def testMetho2():Unit ={
  }
  // 类比字段
  private def testMethods3():Unit ={

  }
}

// 继承
class extendsClassSun extends extendsClassFather{
  // 匿名子类
  val test = new extendsClassFather(){
    def testMethods4():Unit ={
      println("i am anonymous class")
    }
  }
  // 重写字段
  override val age:Int = 22
  // 重写方法
  override def testMethod():Unit ={
    println("i was overide by extendClassSun")
  }
}

val extendsClassSun = new extendsClassSun()
// 类型检查
if(extendsClassSun.isInstanceOf[extendsClassSun]){
  println("i am sun")
}
else if(extendsClassSun.isInstanceOf[extendsClassFather]){
  println("i am father")
}
// 类型转换
extendsClassSun.asInstanceOf[extendsClassFather].testMethod()


/*
第九章 文件和正则
 */

// 1 读取文本文件
import scala.io.Source
val source = Source.fromFile("./README", "UTF-8")
for(line <- source.getLines()){
  println(line)
}
source.close()

// 2 读取字符
val source2 = Source.fromFile("./README", "UTF-8")
for(c <- source2.buffered){
  println(c)
}
source2.close()

// 3 读取命令行
//println("Please input anythind")
//println("your input :" + readLine())

// 4 URL 读取
//for(line <- Source.fromURL("https://www.baidu.com", "UTF-8").getLines()){
//  println(line)
//}

// 5 进程控制
import sys.process._
// 状态码返回
val process_result = "ls -l".!
println(process_result)
// 执行结果以字符串返回
val process_result2 = "ls -l".!!
println(process_result2)

// 6 正则表达式
val pattern1 = "[0-9]+".r
val pattern2 = """\s+[0-9]+\s""".r // 不考虑转义

for(c <- pattern1.findAllIn("2434sadfas344")){
  println(c)
}

val pattern3 = "([0-9]+) ([a-z]+)".r // 正则数组
for(pattern3(num, item) <- pattern3.findAllIn("34 boys, 45, 56 girls")){
  println(num)
  println(item)
}


/*
第十章 特质
 */

// 1 特质通过关键词extends , 当有多个特质的时候， 使用 with 关键词， 特质的方法重写不需要override
// 2 带特质的对象
trait Logged{
  def log(msg: String): Unit={}
}

trait ConsoleLogger extends Logged{
  // 自身类型， 限制了混入ConsoleLogger 的类必须是 Exception 的子类
  this: Exception =>
  override def log(msg: String):Unit ={
    println(msg)
  }
}

class MyAccount extends Exception with Logged{
  def testMethods(msg: String): Unit ={
    log(msg)
  }
}

val objectWithTrait = new MyAccount() with ConsoleLogger// 带有特质的对象
objectWithTrait.testMethods("with trait object")

// 3 叠加在一起的特质， 顺序靠后的优先级高

// 4 扩展类的特质： trait extends class

// 5 自身类型, 只能被自身类型的子类继承


/*
第十一章 操作符
 */

// 1 标识符

// 2 中置操作符

// 3 一元操作符

// 4 赋值操作符

// 5 优先级

// 6 结合性

// 7 apply 和 update 方法
class ApplyAndUpdateTest(){
  var name: String = "defaultName"

  def this(name: String){
    this()
    this.name = name
  }

  def update(key: String, value: String):Unit={
     this.name = value
  }

  def printTest():Unit ={
    println("--------" + this.name)
  }

}

object ApplyAndUpdateTest{

  def apply(name: String): ApplyAndUpdateTest ={
    new ApplyAndUpdateTest(name)
  }

//  def unapply(applyAndUpdateTest: ApplyAndUpdateTest): Option[(String)] ={
//    Some((applyAndUpdateTest.name))
//  }

  def unapplySeq(applyAndUpdateTest: ApplyAndUpdateTest): Option[Seq[String]] ={
    Some("firstnamelastname".split(" "))
  }
}

val MyApplyAndUpdateTest =  ApplyAndUpdateTest("eiffel")
MyApplyAndUpdateTest.printTest()
MyApplyAndUpdateTest("name") = "name_of_my"
MyApplyAndUpdateTest.printTest()

// val ApplyAndUpdateTest(name) = MyApplyAndUpdateTest
// println(name)

// unapply, applySeq 测试
MyApplyAndUpdateTest match {
  case ApplyAndUpdateTest(name) => println("unapplySeq was call1")
  case ApplyAndUpdateTest(name1, name2) => println("unapplySeq was call2")
  case _ => println("---NONE--")
}
// 8 提取器, 参考上面unapply()方法

// 9 带单个参数和无参数的提取器

// 10 unapplySeq 方法, 和unapply 只能使用一个


/*
第十二章 高阶函数
 */
// 1 作为值的函数
val fun = scala.math.ceil _ // _ 操作符把一个方法转换成函数， 给变量赋值
println(fun(3.14))
Array(3.14, 1.42, 2.0).map(x => fun(x)).foreach(x => println(x))

// 2 匿名函数, 没有名字
Array(3.14, 1.42, 2.0).map(x => 2*x)
Array(3.14, 1.42, 2.0).map((x: Double) => 2*x)

val fun2 = (x:Double) => 2*x
Array(3.14, 1.42, 2.0).map(fun2)

// 3 带函数参数的函数, 函数作为参数
val fun3 = (x:Double) => 2*x
def functionWithFunctionMethods(x:Double, f:(Double) => Double):Double ={
  f(x)
}
println(functionWithFunctionMethods(3.3, fun3))

// 4 参数类型推断, 不用声明入口参数的类型

// 5 有用的高阶函数
(1 to 20).map(x => " " * (9 - x/2) + "*" * x).foreach(println)
println((1 to 9).reduceLeft((x, y) => x + y))

// 6 闭包 可以访问一个函数里面局部变量的另外一个函数
def mulBy(factor: Double) = (x: Double) => factor * x
val mymulBy = mulBy(3)
println(mymulBy(4))

def mulBy2(factor: Double) = (x: Double, y:Double) => factor * (x + y)
val mymulBy2 = mulBy2(3)
println(mymulBy2(4, 3))

// 7 SAM(single abstract method)转换, 通过传递对象的方式传递对象的方法， 相当于传递函数
abstract class SAMTest{
  def testMethods()
}

class SAMTest2(){
  def testMethod(x: SAMTest): Unit ={
    x.testMethods()
  }
}

new SAMTest2().testMethod(new SAMTest {
  override def testMethods(): Unit = {println("SAMTest")}
})

// 8 柯里化， 把接受多个参数的函数变成接受变成接受一个参数的函数
def kelihua(x: Double, y:Double): Double ={ x + y}
def kelihua2(x: Double) = (y: Double) => {x + y}
println(kelihua(3, 3))
println(kelihua2(3)(3))

// 9 抽象控制, 给函数传递代码块, 没啥用， 忽略
def myuntil(x: Int)(f:(Int) => Unit) {
  var i = 1
  while(i < x){
    f(x)
    i = i + 1
  }
}
myuntil(9)( (x:Int) => println(x))

// 10 return 表达式， 默认返回最后一行执行的返回值， 也可以显示返回， 但是不建议





/*
第十三章 集合
set seq map， 了解集合的继承关系即可， 具体集合的使用查询API
 */






/*
第十四章 模式匹配和样例类
 */
val matchVal = 1

/*
类型判断
只要有一个case 判断成功， 接下来的case 将不会再判断
设置守卫判断（if）
case _ :当以上条件都不满足的时候， 执行该行代码
*/
matchVal match {
  case tempMatchVal1:Int => println("type judge test：" + tempMatchVal1)
  case 1 => println("matchval is 1")
  case tempMatchVal2 if (tempMatchVal2 == 1) => println("mactchVal is :" + tempMatchVal2)
  case _ => println("unknown nothing")
}

/*
数组(array)， 元组(tupple)， 列表(list)匹配
提取器， 正则匹配
for 循环匹配
 */

/*
样例类, copy 方法
 */

case class CaseClassTest(name: String, age:Int)
val myCaseClassTest = new CaseClassTest("eiffel", 21)
println(myCaseClassTest.name)
val myCaseClassTest2 = myCaseClassTest.copy()
println(myCaseClassTest2.name)
val myCaseClassTest3 = myCaseClassTest.copy(name = "eiffel2")
println(myCaseClassTest3.name)

/*
密封类， 不能在类定义之外定义任何新的子类, 所有的子类定义在同一个文件中
 */
sealed abstract class Class1
case class Class2() extends Class1
case class Class3() extends Class1


/*
模拟枚举

sealed abstract class TrafficLightColors
case class Red extends TrafficLightColors
case class Yellow extends TrafficLightColors
case class Green extends TrafficLightColors

val myTrafficLightColors = new Red
myTrafficLightColors match {
  case x:Red => "STOP"
  case y:Yellow => "WAITING"
  case z:Green => "GO"
  case _ => "NOTHING"
}
 */

/*
OPTION 类型, 记得 getOrElse 方法即可
 */

/*
偏函数， 并非对所有输入值都有定义的函数, 一般用case 处理
 */
def inc: PartialFunction[Any, Any]= { // any 是入口参数， any 是返回值
    case i: Int => i + 1
    case j: String => "String:" + j
    case _ => None
}

val inc2 = new PartialFunction[Any, Double]{
    def apply(any: Any):Double = {
      any.asInstanceOf[Int] +  1
    }
    def isDefinedAt(any: Any):Boolean = {
      if(any.isInstanceOf[Int])
        true
      else
        false
    }
}

println(List(1, 2, 3).map(inc))
println(List(1, 2, 3).map(i => inc2(i)))
println(List(1, 2, "1", 3, 3.2).map(i => inc(i)))


/*
第十五章 注解
 */

/*
第十六章 XML处理
 */

/*
第十七章 类型参数
 */

// 1 泛型类, 类的构造函数是泛型
case class FanXingClass[T](val name:T)
val myFanXingClass = new FanXingClass("eiffel")
println(myFanXingClass.name)

// 2 泛型函数, 函数的入口参数是泛型
def FanXingMethod[T](a: T):Unit ={
  if(a.isInstanceOf[Int]){
    println("I am Int type")
  }else if(a.isInstanceOf[String]){
    println("I am String type")
  }
}
FanXingMethod(1)
FanXingMethod("1")

// 3 泛型变量界定, 参数的上下界
def FanXingMethod2[T >: scala.collection.immutable.ListSet[Any] <: scala.collection.immutable.Iterable[Any]](a: T):Unit ={
  a.foreach(println)
}
FanXingMethod2(scala.collection.immutable.Set(1, 2, 3, 4))

// 4 视图界定， 解决类的隐式转换问题
def FanXingMethod3[T <% Double](a: T):Unit ={
  println(a)
}
FanXingMethod3(1) // int 虽然不是Double类型， 但是可以隐式转换成Double
FanXingMethod3(2.3)

// 5 上下文界定
class FanXingClass2[T: Ordering](val a: T){} // 要求必须有一个Ordering[T] 的隐式转换

// 6 Manifest 上下文界定， 处理泛型数组
 def ManifestTest[T: Manifest](a: T): Array[T] ={
  val r = new Array[T](1)
  r(0) = a
  r
}
println(ManifestTest(2).asInstanceOf[Array[Int]](0))  // 类型转换

// 7 多重界定, 参考 3

// 8 类型约束
//  T =:= U
//  T <:< U
//  T %:% U
case class LeiXingYueShu[T](val age:T)(implicit env:T <:< Int){}  // implicit env:T <:< Int 是用来约束泛型的
val myLeiXingYueShu = new LeiXingYueShu(21)
println(myLeiXingYueShu.age)

// 9 型变: 协变和逆变都属于型变
// Ａ　是　Ｂ　的子类，C[A]　是 C[B] 的子类, + 号表示
// Ａ　是　Ｂ　的子类，C[B]　是 C[A] 的子类, -　号表示
class PersonDef()
class StudentDef extends PersonDef

class PairPesonStudent[+T](a:T)
class PairPesonStudent2[-T](a:T)

def xingbianTestMethod(a: PairPesonStudent[PersonDef]): Unit ={
  println("xian bian test")
}


def xingbianTestMethod2(a: PairPesonStudent2[StudentDef]): Unit ={
  println("xian bian test")
}
// xingbianTestMethod 需要一个PairPesonStudent[PersonDef]　的参数，　但是可以用它的子类替换　PairPesonStudent[StudentDef]
xingbianTestMethod(new PairPesonStudent[PersonDef](new StudentDef))
// 传递了一个父类，　最终做了子类用, 此处很绕口
xingbianTestMethod2(new PairPesonStudent2[PersonDef](new PersonDef).asInstanceOf[PairPesonStudent2[StudentDef]])


// 10 协变和逆变点, 很晦涩，　一辈子都可能用不着，　过

// 11 对象不能泛型

// 12 类型通配符　_　代替　Ｔ