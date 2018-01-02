package exercise3_functors

import cats.Functor
import cats.implicits._

sealed trait Tree[+A]
final case class Branch[A](left: Tree[A], right: Tree[A]) extends Tree[A]
final case class Leaf[A](value: A) extends Tree[A]

object Tree {
  def branch[A](left: Tree[A], right: Tree[A]): Tree[A] =
    Branch(left, right)
  def leaf[A](value: A): Tree[A] =
    Leaf(value)
  implicit val treeFunctor: Functor[Tree] = new Functor[Tree] {
    override def map[A, B](tree: Tree[A])(func: A => B): Tree[B] = {
      tree match {
        case Branch(l, r) =>
          Branch(map(l)(func), map(r)(func))
        case Leaf(v) =>
          Leaf(func(v))
      }
    }
  }
}

object Main extends App {
  val tree = Tree.branch(Leaf(2), Leaf(4))
  val tree2 = tree.map(_ * 2)

  println(tree)
  println(tree2)
}

