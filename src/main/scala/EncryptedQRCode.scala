import java.io.File
import java.nio.file.Files

import com.google.gson.Gson
import net.glxn.qrgen.QRCode

object EncryptedQRCode extends App {
  val genKey = "klix8TW3SMGtHLVO0ZbhwO8ggW0p+npHfB71epkvmE0="//AES.encodeBase64(AES.generateKey("AES", 256))

  val userData: String = """{"username": "abc@gmail.com","address": "!Earth"}"""

  val encrypted: Array[Byte] = AES.encrypt(userData.toString.getBytes("UTF-8"), genKey)

  val encryptedData: String = AES.encodeBase64(encrypted)

  System.out.println("encryptedData is:" + encryptedData)

  val f = QRCode.from(encryptedData).file

  val result = new File("E:/Development/Scala/Makeathon4/result1.png")

  Files.copy(f.toPath, result.toPath)
}
