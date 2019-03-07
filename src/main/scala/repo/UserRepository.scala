package repo

import java.io.FileInputStream
import java.nio.ByteBuffer
import java.util.UUID

import com.datastax.driver.core.Cluster
import com.datastax.driver.core.Session

object UserRepository extends Binder with App {

  val cluster: Cluster = Cluster.builder.addContactPoint("127.0.0.1").build
  val session = cluster.connect

  val fis: FileInputStream = new FileInputStream("E:\\Development\\Scala\\Makeathon4\\result1.png")
  val byteArr: Array[Byte] = new Array[Byte](fis.available()+1)
  fis.read(byteArr)
  val buffer: ByteBuffer = ByteBuffer.wrap(byteArr)

  val user = User("Mukesh", "mukesh@gmail.com", 9901821625L, buffer)

  // to create new user
  //createNewUser(user)

  val uuid = "469077c0-40fc-11e9-bb95-c19b14aadcff"
  getUser(UUID.fromString(uuid))
  //469077c0-40fc-11e9-bb95-c19b14aadcff
}
