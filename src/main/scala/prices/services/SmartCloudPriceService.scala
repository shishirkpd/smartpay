package prices.services

import io.circe.Json

trait SmartCloudPriceService {

  def getAllInstance(baseUri: String, token: String): List[String]
  def getPriceOfInstanceByKind(baseUri: String, token: String, kind: String): Json

}
