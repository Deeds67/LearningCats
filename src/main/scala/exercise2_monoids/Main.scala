package exercise2_monoids

import cats.instances.int._
import cats.instances.option._

object Main extends App {

  def add(list: List[Int]): Int = {
    cats.Monoid[Int].combineAll(list)
  }

  def add2(list: List[Option[Int]]): Option[Int] = {
    cats.Monoid[Option[Int]].combineAll(list)
  }

//  def add[A](list: List[Option[A]]): Int = {
//    list.foldLeft(0)
//  }
}