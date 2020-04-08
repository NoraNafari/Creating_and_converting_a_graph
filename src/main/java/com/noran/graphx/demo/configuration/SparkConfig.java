package com.noran.graphx.demo.configuration;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.SparkSession;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SparkConfig {

    @Bean
    SparkSession config(){
        SparkConf sparkConf = new SparkConf()
                .setAppName("graph")
                .setMaster("local[*]");

        JavaSparkContext javaSparkContext = new JavaSparkContext(sparkConf);
        javaSparkContext.setCheckpointDir("file:///C:/temp");
        return SparkSession.builder()
                .sparkContext(javaSparkContext.sc())
                .getOrCreate();
    }
}
