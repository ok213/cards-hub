package simulations

import java.util.concurrent.TimeUnit

import io.gatling.core.Predef._
import io.gatling.http.Predef._

import scala.concurrent.duration._
import scala.util.Random

class AdvancedSimulationMongo extends Simulation {

  private val targetUrl: String = "localhost:8080/hub/cards?currentDate=1500197400000"
  private val numberOfUserRequests: Int = System.getProperty("REQ").toInt
  private val simUsers: Int = System.getProperty("SIM_USERS").toInt
  private val userId: String = "20"

//  private val userIdFeeder = Iterator.from(0).map(i => Map("userId" -> i))
//  private val userIdFeederRandom = Iterator.continually(Map("userIdRandom" -> Random.nextInt(simUsers)))
//  private val mailFeeder = Iterator.continually(Map("email" -> (Random.alphanumeric.take(20).mkString + "@foo.com")))

  private val httpConf = http("GET-API")
    .get(targetUrl)
    .header("userId", userId)
    .header("longitude", "51.7908562")
    .header("latitude", "54.962341")
    .check(status.is(200))

  private val scn = scenario("Test cards-hub")
    .exec(httpConf).pause(Duration.apply(5, TimeUnit.MILLISECONDS))

  setUp(scn.inject(rampUsers(simUsers) during(30 seconds))).maxDuration(60 minutes)

}
