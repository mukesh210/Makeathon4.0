import com.google.gson.Gson

object DecryptQRData extends App {
  val key = "klix8TW3SMGtHLVO0ZbhwO8ggW0p+npHfB71epkvmE0="
  val data = "/e9darXrNx2uTaEgvMNgzfeW8fbVNV9tD2mKyHd0QqXgAn33dKrS/xsMtjS2ygvIuiG2vVRThHndBCESDJVt3A=="
  val bytesArray: Array[Byte] = AES.decodeBase64(data)
  val finalData: Array[Byte] = AES.decrypt(bytesArray, key)

  val jsonString: String = new String(finalData)
  val gson: Gson = new Gson()
  val extractedJson: User = gson.fromJson(jsonString, classOf[User])
  println(s"user is: ${extractedJson}")
}

case class User(username: String, address: String)