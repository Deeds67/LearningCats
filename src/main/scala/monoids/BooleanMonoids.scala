package monoids

object BooleanMonoids {
  val andBooleanMonoid: Monoid[Boolean] =
    new Monoid[Boolean] {
      override def empty = true

      override def combine(a: Boolean, b: Boolean) = a && b
    }

  val orBooleanMonoid: Monoid[Boolean] =
    new Monoid[Boolean] {
      override def empty = false

      override def combine(a: Boolean, b: Boolean) = a || b
    }

  val eitherBooleanMonoid: Monoid[Boolean] =
    new Monoid[Boolean] {
      override def empty = false

      override def combine(a: Boolean, b: Boolean) = (a && !b) || (!a && b)
    }

  val xorBooleanMonoid: Monoid[Boolean] =
    new Monoid[Boolean] {
      override def empty = true

      override def combine(a: Boolean, b: Boolean) = (a || !b) && (!a || b)
    }
}