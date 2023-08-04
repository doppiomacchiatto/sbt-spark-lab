package io.santisi.sbt
import org.apache.commons.csv.{CSVFormat, CSVPrinter}
import org.apache.spark.sql.{Row, SparkSession}

class SparkRddToCSV {
  def main(args:Array[String]):Unit={
    val spark: SparkSession = SparkSession.builder()
      .master("local[1]").appName("SbtSparkLab")
      .getOrCreate()

    import spark.implicits._
    val columns = Seq("language", "users_count")
    val data = Seq(("Java", "20000"), ("Python", "100000"), ("Scala", "3000"))
    val rdd = spark.sparkContext.parallelize(data)

    val dfFromRDD2 = spark.createDataFrame(rdd).toDF(columns: _*)
    dfFromRDD2.printSchema()

  }
}
/*
https://github.com/spark-examples/spark-scala-examples/blob/master/src/main/scala/com/sparkbyexamples/spark/dataframe/CreateDataFrame.scala
 */
