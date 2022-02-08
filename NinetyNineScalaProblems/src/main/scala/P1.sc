//P01 (*) Find the last element of a list.
//Example:
//  scala> last(List(1, 1, 2, 3, 5, 8))
//res0: Int = 8

val ls = List(1, 1, 2, 3, 5, 8)

def lastRecursive[A](ls: List[A]): A = {
  ls match {
    case h :: Nil => h
    case _ :: tail => lastRecursive(tail)
    case _ => throw new NoSuchElementException
  }
}
lastRecursive(ls)