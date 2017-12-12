package exercise1

import cats.Show
//import cats.implicits._

object CatImplicits {
  implicit val showCat = {
    new Show[Cat] {
      override def show(cat: Cat): String = {
        val name = cat.name
        val age = cat.age
        val color = cat.color
        s"$name is a $age year-old $color cat"
      }
    }
  }
}