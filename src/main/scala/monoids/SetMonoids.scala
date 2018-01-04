package monoids

object SetMonoids {
  implicit def setUnionMonoid[A]: Monoid[Set[A]] =
    new Monoid[Set[A]] {
      override def empty = Set.empty[A]

      override def combine(a: Set[A], b: Set[A]) = a union b
    }

  implicit val intMonoid: Monoid[Int] =
    new Monoid[Int] {
      override def empty = 0

      override def combine(a: Int, b: Int) = a + b
    }

  val intSetMonoid = Monoid[Set[Int]]

  intSetMonoid.combine(Set(1, 2, 3), Set(1, 2, 4, 5, 6))

  implicit def setIntersectionSemigroup[A]: Semigroup[Set[A]] = (a: Set[A], b: Set[A]) => a intersect b
}