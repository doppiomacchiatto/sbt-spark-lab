# sbt-spark-lab
A simple project used to migrate from SBT version 0.13.x to 1.9.3.  This project uses sbt-assembly for building an Uber jar.

## Scala ##
Scala version 2.13.x is the version of choice, which requires Spark 3.4.x.  The main class creates a simple 2 dimensional RDD then
converts it to a DataFrame.
