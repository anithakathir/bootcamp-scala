package com.indix.bootcamp.tautology

import org.scalatest.{ShouldMatchers, FlatSpec}
import bootcamp.tautology.TautologyVerifier
import com.indix.bootcamp.tautology.Tautology

class TautologyVerifierTest extends FlatSpec with ShouldMatchers {

  "Given an expression, application" should "say if it's a tautology" in {
    TautologyVerifier.verifyTautology("(!a | (a & a))") shouldEqual 1
    TautologyVerifier.verifyTautology("(!a | a)") shouldEqual 1
    TautologyVerifier.verifyTautology("((a & (!b | b)) | (!a & (!b | b)))") shouldEqual 1
  }

  it should "say if it not a tautological expression" in {
    TautologyVerifier.verifyTautology("(!a | (b & !a))") shouldEqual 0
  }


}
