package repo

import java.util.UUID

import com.datastax.driver.core.utils.UUIDs
import com.datastax.driver.core.{BoundStatement, ResultSet, Session}
import Constants._

trait Binder extends Mapper{
  val session: Session
  def createNewUser(user: User): Unit = {
    val preparedStatement = session.prepare(QueryConstants.CREATE_NEW_USER)
    val boundStatement = preparedStatement.bind()
    boundStatement.setUUID(ID, UUIDs.timeBased())
    boundStatement.setString(NAME, user.name)
    boundStatement.setString(EMAIL, user.email)
    boundStatement.setLong(MOBILENUMBER, user.mobileNumber)
    boundStatement.setBytes(QR, user.qr)

    val resultSet: ResultSet = session.execute(boundStatement)
    println(s"resultSet is: ${resultSet.wasApplied()}")
  }

  def getUser(id: UUID) = {
    println(s"id in getUser: ${id}")
    val preparedStatement = session.prepare(QueryConstants.GET_USER)
    val boundStatement = preparedStatement.bind()
    boundStatement.setUUID(ID, id)

    val resultSet = session.execute(boundStatement)
    userMapper(resultSet.one())
  }
}
