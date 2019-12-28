package com.codingkapoor.passwordless.api.model

import play.api.libs.json.{Format, Json}

case class Tokens(jwt: String, refresh: String)

object Tokens {
  implicit val format: Format[Tokens] = Json.format[Tokens]
}
