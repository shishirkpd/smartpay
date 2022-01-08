package prices.routes.protocol

import org.http4s.dsl.impl.QueryParamDecoderMatcher

object KindQueryParamMatcher extends QueryParamDecoderMatcher[String]("kind")