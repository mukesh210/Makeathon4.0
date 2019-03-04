object EncryptDecryptDemo extends App {
  val dataToEncrypt = "my name is mukesh"

  val genKey = AES.encodeBase64(AES.generateKey("AES", 256))
  println(s"genKey: $genKey")
  println(s"string: `$dataToEncrypt`")
  val encrypted = AES.encrypt(dataToEncrypt.getBytes("UTF-8"), genKey)
  println(s"encrypted: ${AES.encodeBase64(encrypted)}")
  val decrypted = AES.decrypt(encrypted, genKey)
  println(s"decrypted: ${new String(decrypted, "UTF-8")}")
}
