package es.techdelivery.free.pg.users

import java.util.UUID

import cats.data.Validated
import cats.data.Validated.Valid
import shapeless.tag, tag._

object model {

  sealed trait UsernameTag

  type Username = String @@ UsernameTag

  object Username {
    def apply(v : String): Validated[String, Username] = {
      val username = tag[UsernameTag](v)
      Valid(username)
    }
  }

  sealed trait EmailAddressTag

  type EmailAddress = String @@ EmailAddressTag

  object EmailAddress {
    def apply(v: String): Validated[String, EmailAddress] = {
      val email = tag[EmailAddressTag](v)
      Valid(email)
    }
  }

  sealed trait UserIdTag

  type UserId = UUID @@ UserIdTag

  object UserId {
    def apply(v: UUID) = tag[UserIdTag](v)
  }

  final case class User(id: UserId, name: Username, emailAddress: EmailAddress)
}
