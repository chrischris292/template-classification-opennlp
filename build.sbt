import AssemblyKeys._

assemblySettings

name := "pio-corenlp"

organization := "io.prediction"

libraryDependencies ++= Seq(
  "io.prediction"    %% "core"          % pioVersion.value % "provided",
  "org.apache.spark" %% "spark-core"    % "1.2.0" % "provided",
  "org.apache.spark" %% "spark-mllib"   % "1.2.0" % "provided",
  "org.apache.opennlp" % "opennlp-maxent" % "3.0.3",
 "edu.stanford.nlp" % "stanford-corenlp" % "3.5.1",
  "org.scalatest" % "scalatest_2.10" % "2.2.1" % "test")
