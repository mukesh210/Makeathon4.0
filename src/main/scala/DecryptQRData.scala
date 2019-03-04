import com.google.gson.{Gson, GsonBuilder}
// not working currently
object DecryptQRData extends App {

  val key = "klix8TW3SMGtHLVO0ZbhwO8ggW0p+npHfB71epkvmE0="
  val data = "c3NbCs3KQ6uC9d1kplSOg9vIN47oErTg1mAL9tmzVQOPvsTTyYmN08TQ/of+5J+CGjX1nlP7N0cWKgzGswNPYDc8XJw0r1ZWtZgTKhKJC9NG5nZyKeQKnuT880FV/ZCxyrA2SpUtU+Rh28oXsL6MdA=="
  val bytesArray: Array[Byte] = AES.decodeBase64(data)
  val finalData: Array[Byte] = AES.decrypt(bytesArray, key)

  //val result: String = "{\"username\": \"mukeshsprajapati210@gmail.com\",\"address\": \"A7-104, Splendour, Megapolis\"}"//new String(finalData)
  val result: String = new String(finalData)
  println(s"result: $result")
  val result1 = result.replaceAll("^\"|\"$", "")
  println(s"result1: ${result1}")
  val gson: Gson = new Gson()
  val extractedJson: User = gson.fromJson(result1, classOf[User])
  println(s"user is: ${extractedJson}")
}

case class User(username: String, address: String)