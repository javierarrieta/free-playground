package es.techdelivery.free.pg.users.alg

import es.techdelivery.free.pg.users.model.{EmailAddress, User, UserId, Username}
import freestyle._

@free trait UserRepository {
  def storeUser(name: Username, email: EmailAddress): FS[User]

  def getUser(id: UserId): FS[Option[User]]
}
