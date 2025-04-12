import xerial.sbt.Sonatype._

ThisBuild / version      := "0.1.0"
ThisBuild / scalaVersion := "2.13.16"

lazy val root = project.in(file(".")).settings(publish / skip := true, publishLocal / skip := true)

lazy val core = crossProject(JVMPlatform, NativePlatform, JSPlatform)
  .crossType(CrossType.Pure)
  .in(file("core"))
  .settings(
    organization           := "net.andimiller",
    name                   := "decline-completion",
    crossScalaVersions     := List("2.13.16", "3.3.5"),
    libraryDependencies ++= List(
      "com.monovore"  %%% "decline" % "2.5.0",
      "org.scalameta" %%% "munit"   % "1.1.0" % Test
    ),
    publishTo              := sonatypePublishTo.value,
    licenses               := Seq("Apache 2.0" -> url("https://opensource.org/license/apache-2-0")),
    sonatypeProjectHosting := Some(GitHubHosting("andimiller", "decline-completion", "andi at andimiller dot net")),
    developers             := List(
      Developer(id = "andimiller", name = "Andi Miller", email = "andi@andimiller.net", url = url("http://andimiller.net"))
    )
  )
