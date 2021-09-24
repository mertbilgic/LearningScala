def listOfDuplicates[A](x: A, length: Int): List[A] = {
  if (length < 1)
    Nil
  else
    x :: listOfDuplicates(x, length - 1)
}

println(listOfDuplicates(3,4))
println(listOfDuplicates[Int](4,4))
println(listOfDuplicates("La",8))