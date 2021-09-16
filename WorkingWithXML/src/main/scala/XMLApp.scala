import scala.xml.{Elem, NodeSeq}

object XMLApp extends App {

  val bookStore: Elem = <bookstore>
    <book category="children">
      <title>Harry Potter</title>
      <author>J K. Rowling</author>
      <year>2005</year>
      <price>29.99</price>
    </book>
    <book category="web">
      <title>Learning XML</title>
      <author>Erik T. Ray</author>
      <year>2003</year>
      <price>39.95</price>
    </book>
  </bookstore>

  val seq: NodeSeq = bookStore \ "book"
  seq.map(book => println("---> " + book))

  val seqCategory: NodeSeq = bookStore \\ "title"
  seq.map(book => println("---> " + seqCategory))

}
