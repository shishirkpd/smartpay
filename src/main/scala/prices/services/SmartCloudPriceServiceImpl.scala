package prices.services

import io.circe.Json

object SmartCloudPriceServiceImpl extends SmartCloudPriceService {

  override def getAllInstance(baseUri: String, token: String): List[String] = ???

  override def getPriceOfInstanceByKind(baseUri: String, token: String, kind: String): Json = ???
}
