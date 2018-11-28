import Dependencies._

lazy val root = (project in file(".")).
  settings(
    inThisBuild(
      List(
        organization := "com.example",
        scalaVersion := "2.12.7",
        version      := "0.1.0-SNAPSHOT",
        scalacOptions := Seq(
          "-deprecation",
          "-feature",
          "-unchecked",
          "-Xlint",
          "-Ywarn-adapted-args",
          "-Ywarn-dead-code",
          "-Ywarn-inaccessible",
          "-Ywarn-nullary-override",
          "-Ywarn-numeric-widen",
          "-language:higherKinds"
        )
      )
    ),
    name := "hiring-peer-code",
    libraryDependencies ++= Seq(
      cats,
      scalaTest % Test
    )
  )
