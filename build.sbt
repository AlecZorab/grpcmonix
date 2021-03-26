import scalapb.compiler.Version.scalapbVersion

organization in ThisBuild := "io.zorab"
version in ThisBuild := "0.1.1"
scalaVersion in ThisBuild := "2.12.12"

lazy val runtime = (project in file("runtime"))
  .settings(
    scalaVersion := "2.13.3",
    name := "GrpcMonixRuntime",
    libraryDependencies ++= Seq(
      "com.thesamet.scalapb" %% "scalapb-runtime-grpc" % scalapb.compiler.Version.scalapbVersion,
      "io.monix" %% "monix" % "3.2.2"
    )
  )

lazy val generator = (project in file("generator"))
  .settings(
    name := "GrpcMonixGenerator",
    crossScalaVersions := Seq("2.12.12", "2.10.6"),
    libraryDependencies ++= Seq(
      "com.thesamet.scalapb" %% "compilerplugin" % scalapb.compiler.Version.scalapbVersion % "provided",
      "com.thesamet.scalapb" %% "scalapb-runtime-grpc" % scalapb.compiler.Version.scalapbVersion % "provided",
    ),
  )
