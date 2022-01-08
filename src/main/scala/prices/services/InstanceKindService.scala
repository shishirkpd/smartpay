package prices.services

import scala.util.control.NoStackTrace

import prices.data._

trait InstanceKindService[F[_]] {
  def getAll(): F[List[InstanceKind]]

  def getPriceByKind(kind: String): F[InstanceKindWithPrice]
}

object InstanceKindService {

  sealed trait Exception extends NoStackTrace
  object Exception {
    case class APICallFailure(message: String) extends Exception
  }

}
