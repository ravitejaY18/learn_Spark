package learn_Spark_group

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._

object sparkApp {

  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder()
      .appName("Spark Example")
      .master("local[*]")
      .getOrCreate()

    import spark.implicits._

    // Create a DataFrame
    val data = Seq(
      ("Alice", 25),
      ("Bob", 30),
      ("Charlie", 35)
    )

    val df = data.toDF("name", "age")

    // Show the DataFrame
    df.show()

    // Perform a simple transformation
    val dfWithAgePlusTen = df.withColumn("age_plus_ten", col("age") + 10)

    // Show the transformed DataFrame
    dfWithAgePlusTen.show()

    // Stop the SparkSession
    spark.stop()
  }

}
