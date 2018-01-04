package monads

import scala.language.higherKinds
import cats.Id

trait Monad[F[_]] {
  def pure[A](a: A): F[A]
  def flatMap[A, B](value: F[A])(func: A => F[B]): F[B]
  def map[A, B](value: F[A])(func: A => B): F[B] = {
    flatMap(value)(x => pure(func(x)))
  }
}

object TestId {
  def pure[A](value: A): Id[A] =
    value

  def map[A, B](value: Id[A])(func: A => B): Id[B] = {
    func(value)
  }

  def flatMap[A, B](value: Id[A])(func: A => Id[B]): Id[B] = {
    func(value)
  }
}