package prices.services

import io.circe
import io.circe.{Json, parser}
import prices.services.InstanceKindService.Exception.APICallFailure
import sttp.client3._

object SmartCloudPriceServiceImpl extends SmartCloudPriceService {

  override def getAllInstance(baseUri: String, token: String): List[String] = {

    val request = basicRequest.get(
      uri"$baseUri").auth.bearer(token)

    val backend = HttpURLConnectionBackend()
    val response = request.send(backend)
    response.body match {
      case Right(jsonString) =>
        val parsedJson: Either[circe.Error, List[String]] = parser.decode[List[String]](jsonString)
        parsedJson match {
          case Left(ex) => throw APICallFailure(s"could not parse response $ex")
          case Right(value) => value
        }
      case Left(ex) => throw APICallFailure(s"could not parse response $ex")
    }
  }

  override def getPriceOfInstanceByKind(baseUri: String, token: String, kind: String): Json = ???
}
