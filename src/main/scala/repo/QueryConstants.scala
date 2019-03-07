package repo
import Constants._

object QueryConstants {
  val CREATE_NEW_USER = s"INSERT INTO local1.$USER($ID, $NAME, $EMAIL, $MOBILENUMBER, $QR) values(:$ID, :$NAME, :$EMAIL," +
    s":$MOBILENUMBER, :$QR)"

  val GET_USER = s"SELECT $ID, $NAME, $EMAIL, $MOBILENUMBER, $QR FROM local1.$USER WHERE id=:$ID"
}
