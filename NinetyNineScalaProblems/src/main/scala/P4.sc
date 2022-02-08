//Find the number of elements of a list.
//Example:
//  scala> length(List(1, 1, 2, 3, 5, 8))
//res0: Int = 6

def lengthBuiltin[A](ls: List[A]): Int = ls.length

def lengthRecursive[A](ls: List[A]): Int = ls match {
  case Nil => 0
  case _ :: tail => 1 + lengthRecursive(ls)
}

