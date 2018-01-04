import cats.Monad
import cats.syntax.functor._
import cats.syntax.flatMap._
import scala.language.higherKinds
import cats.instances.option._
import cats.instances.list._
import cats.Id

object Main extends App {
  def sumSquare[F[_]: Monad](a: F[Int], b: F[Int]): F[Int] =
    a.flatMap(x => b.map(y => x*x + y*y))

  sumSquare(Option(3), Option(4))
  sumSquare(List(1, 2, 3), List(4, 5))

  //Fails to compile:
  //sumSquare(1, 2)

  //Need to wrap with Id
  sumSquare(1: Id[Int], 2: Id[Int])
}
