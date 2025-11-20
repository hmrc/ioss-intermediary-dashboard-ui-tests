import sbt.*

object Dependencies {

  val test: Seq[ModuleID] = Seq(
    "uk.gov.hmrc"       %% "ui-test-runner"     % "0.50.0" % Test,
    "junit"              % "junit"              % "4.13.2" % Test,
    "org.mongodb.scala" %% "mongo-scala-driver" % "5.5.1" cross CrossVersion.for3Use2_13
  )

}
