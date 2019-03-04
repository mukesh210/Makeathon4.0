import java.io.File
import java.nio.file.Files

import net.glxn.qrgen.QRCode

object QRCodeGenerator extends App {
  val f = QRCode.from("http://brizzled.clapper.org/").file
  val result = new File("E:/Development/Scala/Makeathon4/target1.png")
  Files.copy(f.toPath, result.toPath)
}
