
organization := "com.cloudphysics.hbridge"

name := "hbridge"

version := "1.0.0"

scalaVersion := "2.10.0"

retrieveManaged := true

// Global Repository resolver
resolvers ++= Seq(
		"Thrift-Repo" at "http://people.apache.org/~rawson/repo",
		"Cloudera-jdo" at "https://repository.cloudera.com/artifactory/cdh-build",
		"ClouderaRepo" at "https://repository.cloudera.com/content/repositories/releases",
		"ClouderaRcs" at "https://repository.cloudera.com/artifactory/cdh-releases-rcs",
		"CRepos" at "https://repository.cloudera.com/artifactory/cloudera-repos/",
		"scala-snapshots" at "http://scala-tools.org/repo-snapshots",
		"scala-releases"  at "http://scala-tools.org/repo-releases",
		"Codahale" at "http://conikeec.github.com/jerkson/repository/",
		"Apache HBase" at "https://repository.apache.org/content/repositories/releases",
		"Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases",
		"Typesafe Snapshots Repository" at "http://repo.typesafe.com/typesafe/snapshots/",
		"Twitter Repository" at "http://maven.twttr.com",
		"Local Ivy Repository" at "file://" + System.getProperty("user.home") + "/.iv2/local"
	)
	

libraryDependencies ++= Seq(
    "org.apache.hadoop" % "hadoop-client" % "2.0.0-cdh4.0.1" excludeAll (
     ExclusionRule(organization = "org.jruby"),
     ExclusionRule(organization = "org.slf4j")) ,
    "org.apache.hbase" % "hbase" % "0.92.1-cdh4.0.1" excludeAll (
     ExclusionRule(organization = "org.jruby"),
     ExclusionRule(organization = "org.slf4j")),
	"org.clapper" % "grizzled-slf4j_2.10" % "1.0.1",
	"joda-time" % "joda-time" % "2.0",
	"org.joda" % "joda-convert" % "1.1"
	)

/* publishing */
publishMavenStyle := true

publishTo <<= version { (v: String) =>
  val cphy = "https://cloudphysics.artifactoryonline.com/cloudphysics/"
  if (v.trim.endsWith("SNAPSHOT")) Some(
    "cphy snapshots" at cphy + "oss-snapshots-local"
  )
  else Some("releases" at cphy + "oss-releases-local")
}

credentials += Credentials(Path.userHome / ".ivy2" / ".credentials")

publishArtifact in Test := false

pomIncludeRepository := { _ => false }

pomExtra := (
  <developers>
    <developer>
      <id>cphy</id>
      <name>CloudPhysics Inc</name>
      <email>opensource@cloudphysics.com</email>
    </developer>
  </developers>
)

