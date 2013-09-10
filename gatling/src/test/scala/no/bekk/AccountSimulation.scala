package no.bekk

import io.gatling.core.Predef._
import io.gatling.http.Predef._

import scala.concurrent.duration._

class AccountSimulation extends Simulation {

  val httpConf = http
    .baseURL("http://localhost:8080")

  val scn = scenario("Scenario")
    .feed(csv("users.csv").random)
    .exec(
      http("Index page")
        .get("/"))
    .exec(
      http("Account page")
        .get("/banking/account")
    )
    .exec(
      http("Login to account")
        .post("/j_security_check")
          .param("j_username", "${user}")
          .param("j_password", "password")
        .check(regex("Account balance for user ${user}")))
    .exec(
      http("Logout")
        .get("/logout"))


  //setUp(scn.inject(atOnce(1 user))).protocols(httpConf)

  setUp(scn.inject(constantRate(5 usersPerSec) during (60 seconds))).protocols(httpConf)

}
