val number = 10


val symbol: String = if (number > 10) {
  "> 10"
} else if (number == 10){
  "== 10"
}
else{
  "<= 10"
}

val symbol2: String = if (number > 10) "> 10" else "<= 10"