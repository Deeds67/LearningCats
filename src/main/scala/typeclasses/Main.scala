package typeclasses

import cats.syntax.eq._
import cats.instances.int._    // for Eq
import cats.instances.string._
import cats.Eq
object Main extends App {
  val cat1 = Cat("Caesar", 3, "White")
  val cat2 = Cat("Caesar", 3, "White")
  val cat3 = Cat("Caesar", 3, "White2")


  implicit val catEq: Eq[Cat] =
    Eq.instance { (cat1, cat2) =>
      cat1.age === cat2.age &&
      cat1.color === cat2.color &&
      cat1.name === cat2.name
    }

  println(cat1 === cat2)
  println(cat1 === cat3)
}

