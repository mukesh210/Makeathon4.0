package repo

import java.nio.ByteBuffer

case class User(name: String, email: String, mobileNumber: Long, qr: ByteBuffer)
