package com.example.app.serializers

import com.example.app.models.User
import org.json4s.CustomSerializer
import org.json4s._

class UserSerializer extends CustomSerializer[User](format => ({
  case JObject(
  ("id", JInt(id)) ::
    ("email", JString(email)) ::
    ("firstName" , JString(firstName)) ::
    ("lastName", JString(lastName)) :: Nil) =>
    new User(1,email)
}, {
  case user: User =>
    JObject.apply(
      "email" -> JString(user.email),
      "id" -> JInt(user.id),
      "status" -> JInt(200)
    )
    }))
