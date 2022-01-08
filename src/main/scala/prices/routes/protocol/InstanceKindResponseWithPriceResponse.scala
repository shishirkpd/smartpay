package prices.routes.protocol

import io.circe.Encoder
import prices.data.InstanceKindWithPrice

final case class InstanceKindResponseWithPriceResponse(value: InstanceKindWithPrice)

object InstanceKindResponseWithPriceResponse {

  implicit val encoder: Encoder[InstanceKindResponseWithPriceResponse] =
    Encoder.instance[InstanceKindResponseWithPriceResponse] {
      case InstanceKindResponseWithPriceResponse(k) =>
        k.json
    }

}