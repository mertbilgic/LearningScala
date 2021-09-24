def withFileWriter[T](fileName: String)(handler: java.io.BufferedWriter => T) = {
  val output = java.nio.file.Files.newBufferedWriter(java.nio.file.Paths.get(fileName))
  try handler(output)
  finally output.close()
}

def withFileReader[T](fileName: String)(handler: java.io.BufferedReader => T) = {
  val input = java.nio.file.Files.newBufferedReader(java.nio.file.Paths.get(fileName))
  try handler(input)
  finally input.close()
}

withFileWriter("File.txt") { writer =>
  writer.write("Hello\n"); writer.write("World!")
}
val result = withFileReader("File.txt") { reader =>
  reader.readLine() + "\n" + reader.readLine()
}
assert(result == "Hello\nWorld!")