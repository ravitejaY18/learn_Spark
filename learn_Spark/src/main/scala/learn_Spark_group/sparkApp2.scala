package learn_Spark_group

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._
import scala.io.StdIn // 1. Added missing import for StdIn

object sparkApp2 {

  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder()
      .appName("Spark Example")
      .master("local[*]")
      .getOrCreate()

    try {
      // Your job logic here
      val df = spark.range(1000)
      println(s"Total count: ${df.count()}")

      // --- PAUSE HERE ---
      println("Job finished! View Spark UI at http://localhost:4040")
      println("Press [ENTER] to shutdown the job and close the UI...")
      StdIn.readLine()

    } finally {
      spark.stop()
    }
  } // 2. Fixed closing brace for main method
}   // 3. Added closing brace for object sparkApp