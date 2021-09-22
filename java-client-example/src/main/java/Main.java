import org.apache.spark.SparkContext;
import org.apache.spark.SparkFiles;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.sql.SparkSession;

import java.nio.file.FileSystems;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) {
        Path path = FileSystems.getDefault().getPath("data/200 words.txt");
        String absolutePath = path.toAbsolutePath().toUri().toString();

        SparkSession session = SparkSession.builder()
                .appName("Example Application")
                .master("spark://localhost:7077")
                .getOrCreate();
    //JavaRDD<String> peopleRDD =
        try {
            SparkContext sc = session.sparkContext();
            sc.textFile("data/200-words.txt", 2)
                    .toJavaRDD()
                    .map(line -> {
                        String[] parts = line.split(" ");
                        return "123";
                    });
        } catch (Exception ex) {
            String s = ex.getMessage();
            System.out.println(s);
        }



//        JavaPairRDD<String, Integer> counts = textFile
//                .flatMap(s -> Arrays.asList(s.split(" ")).iterator())
//                .mapToPair(word -> new Tuple2<>(word, 1))
//                .reduceByKey((a, b) -> a + b);
        //counts.saveAsTextFile("hdfs://...");
    }
}