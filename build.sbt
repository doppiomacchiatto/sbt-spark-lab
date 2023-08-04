ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.11"

ThisBuild / assemblyMergeStrategy := {
  case PathList("META-INF","io.netty.versions.properties", xs @ _*)  => MergeStrategy.first
  case PathList("META-INF","org","apache","logging","log4j","core","config","plugins","Log4j2Plugins.dat") => MergeStrategy.first
  case PathList("META-INF", "versions", "9", "module-info.class") => MergeStrategy.discard
  case PathList("org","apache","commons","logging","Log.class") => MergeStrategy.first
  case PathList("org","apache","commons","logging","LogConfigurationException.class") => MergeStrategy.first
  case PathList("org","apache","commons","logging","impl","NoOpLog.class") => MergeStrategy.first
  case PathList("org","apache","commons","logging","impl","SimpleLog.class") => MergeStrategy.first
  case PathList("org","apache","commons","logging","LogFactory.class") => MergeStrategy.first
  case PathList("google","protobuf","any.proto")  => MergeStrategy.first
  case PathList("google","protobuf","descriptor.proto")  => MergeStrategy.first
  case PathList("google","protobuf","empty.proto")  => MergeStrategy.first
  case "module-info.class"                       => MergeStrategy.first
  case "arrow-git.properties"                       => MergeStrategy.discard
  case "LICENSE.txt"                                => MergeStrategy.discard
  case x =>
    val oldStrategy = (ThisBuild / assemblyMergeStrategy).value
    oldStrategy(x)
}

lazy val root = (project in file("."))
  .settings(
    name := "sbt-spark-lab",
    libraryDependencies ++= Seq(
      "org.apache.spark" %% "spark-core" % "3.4.1",
      "org.apache.spark" %% "spark-sql" % "3.4.1"
    )
  )




