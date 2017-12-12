package exercise1

trait Printable[A] {
  def format(value: A): String
}

object PrintableInstances extends {
  implicit val printableInt: Printable[Int] =
    new Printable[Int] {
      def format(value: Int): String = {
        value.toString
      }
    }

  implicit val printableDouble: Printable[Double] =
    new Printable[Double] {
      def format(value: Double): String = {
        value.toString
      }
    }

  implicit val printableString: Printable[String] =
    new Printable[String] {
      def format(value: String): String = value
    }

  implicit val printableCat: Printable[Cat] =
    new Printable[Cat] {
      def format(cat: Cat): String = {
        val name = Printable.format(cat.name)
        val age = Printable.format(cat.age)
        val color = Printable.format(cat.color)
        s"$name is a $age year-old $color cat"
      }
    }
}

object PrintableSyntax {
  implicit class PrintableOps[A](value: A) {
    def format(implicit printable: Printable[A]): String = {
      printable.format(value)
    }

    def print(implicit printable: Printable[A]): Unit = {
      println(printable.format(value))
    }
  }
}


object Printable {
  def format[A](value: A)(implicit printable: Printable[A]) = {
    printable.format(value)
  }

  def print[A](value: A)(implicit printable: Printable[A]) = {
    println(format(value))
  }
}