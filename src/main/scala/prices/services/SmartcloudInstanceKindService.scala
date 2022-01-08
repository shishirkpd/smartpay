package prices.services

import cats.implicits._
import cats.effect._
import org.http4s._
import org.http4s.circe._
import prices.data._

object SmartcloudInstanceKindService {

  final case class Config(
                           baseUri: String,
                           token: String
                         )

  def make[F[_]: Concurrent](config: Config): InstanceKindService[F] = new SmartcloudInstanceKindService(config)

  private final class SmartcloudInstanceKindService[F[_]: Concurrent](
                                                                       config: Config
                                                                     ) extends InstanceKindService[F] {

    implicit val instanceKindsEntityDecoder: EntityDecoder[F, List[String]] = jsonOf[F, List[String]]
    implicit val instanceKindsWithPriceEntityDecoder: EntityDecoder[F, String] = jsonOf[F, String]

    override def getAll(): F[List[InstanceKind]] =
      SmartCloudPriceServiceImpl.getAllInstance(config.baseUri, config.token)
        .map(InstanceKind(_))
        .pure[F]

    override def getPriceByKind(kind: String): F[InstanceKindWithPrice] = ???
  }

}
