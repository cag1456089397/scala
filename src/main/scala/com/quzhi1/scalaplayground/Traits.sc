println("/////////// Traits ///////////")

val iterator = new IntIterator(10)
val dog = new Dog("Harry")
val cat = new Cat("Sally")
iterator.next() // returns 0
iterator.next() // returns 1

println("/////////// Subtyping ///////////")

import scala.collection.mutable.ArrayBuffer
val animals = ArrayBuffer.empty[Pet]

trait Iterator[A] {
  def hasNext: Boolean

  def next(): A
}

trait Pet {
  val name: String
}

class IntIterator(to: Int) extends Iterator[Int] {
  private var current = 0

  override def next(): Int = {
    if (hasNext) {
      val t = current
      current += 1
      t
    } else 0
  }

  override def hasNext: Boolean = current < to
}

class Cat(val name: String) extends Pet

class Dog(val name: String) extends Pet
animals.append(dog)
animals.append(cat)
animals.foreach(pet => println(pet.name)) // Prints Harry Sally