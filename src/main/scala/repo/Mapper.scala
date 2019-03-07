package repo

import java.io.{BufferedInputStream, ByteArrayInputStream, File, InputStream}
import java.nio.ByteBuffer

import Constants._
import com.datastax.driver.core.Row
import com.datastax.driver.core.utils.Bytes
import javax.imageio.ImageIO

trait Mapper {
  def userMapper(row: Row) = {
    val byteBuffer: ByteBuffer = row.getBytes(QR)
    val byteArray: Array[Byte] = Bytes.getArray(byteBuffer)
    val is: InputStream = new ByteArrayInputStream(byteArray)
    val bufferedImage = ImageIO.read(is)
    ImageIO.write(bufferedImage, "png", new File("output.png"))
    println("Image created")
  }
}
