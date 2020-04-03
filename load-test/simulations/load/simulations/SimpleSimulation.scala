package simulations

import io.gatling.core.Predef._
import io.gatling.core.structure.ScenarioBuilder
import io.gatling.http.Predef._

class SimpleSimulation extends Simulation {

  private val targetUrl: String = "http://localhost:8080"
  private val pathUrl: String = "/hub/cards"
  private val userId: String = "20"

  private val httpProtocol = http.baseUrl(targetUrl)
    .header("userId", userId)
    .header("longitude", "51.7908562")
    .header("latitude", "54.962341")
    .check(status.is(200))

  private val scn = scenario("Simple Get Request")
    .exec(http("Get HTTP")
      .get(pathUrl)
      .queryParam("currentDate", "1500197400000")
    )

  setUp(scn.inject(atOnceUsers(700))).protocols(httpProtocol)
}
