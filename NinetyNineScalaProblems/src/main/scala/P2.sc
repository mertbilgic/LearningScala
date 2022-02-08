//P02 (*) Find the last but one element of a list.
//Example:
//  scala> penultimate(List(1, 1, 2, 3, 5, 8))
//res0: Int = 5

val ls = List(1, 1, 2, 3, 5, 8)

def penultimateBuiltin[A](ls: List[A]): A =
  if (ls.isEmpty) throw new NoSuchElementException
  else ls.init.last

def penultimateRecursive[A](ls: List[A]): A = {
  ls match {
    case h :: _ :: Nil => h
    case _ :: tail => penultimateRecursive(tail)
    case _ => throw new NoSuchElementException
  }
}

def lastNthBuiltin[A](n: Int, ls: List[A]): A = {
  if (n <= 0) throw new IllegalArgumentException
  if (ls.length < n) throw new NoSuchElementException
  ls.takeRight(n).head
}

def lastNthRecursive[A](n: Int, ls: List[A]): A = {
  def lastNthR(count: Int, resultList: List[A], curList: List[A]): A =
    curList match {
      case Nil if count > 0 => throw new NoSuchElementException
      case Nil => resultList.head
      case _ :: tail =>
        lastNthR(count - 1,
          if (count > 0) resultList else resultList.tail, tail)
    }

  if (n <= 0) throw new IllegalArgumentException
  else lastNthR(n, ls, ls)
}

lastNthRecursive(2, ls)
lastNthBuiltin(2, ls)
penultimateBuiltin(ls)
penultimateRecursive(ls)
