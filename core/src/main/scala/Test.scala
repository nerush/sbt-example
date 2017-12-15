object Test extends App {
  import MacroConcat._

  val one = 1
  val two = "two"

  val result = sfi"one=$one, $two=2"

  println(result)
}
