package com.noran.graphx.demo.service;

import com.noran.graphx.demo.model.Relation;
import com.noran.graphx.demo.model.User;
import org.apache.spark.graphx.Edge;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.graphframes.GraphFrame;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import scala.Tuple2;

@Service
public class CreateGraphService {

    @Autowired
    SparkSession session;
    @Autowired
    SampleUsersAndRelations sampleUsersAndRelations;

    public GraphFrame createGraphFrame(){
        Dataset<Row> userDataset = session.createDataFrame(sampleUsersAndRelations.insertUsers(), User.class);
        Dataset<Row> relationsDataset = session.createDataFrame(sampleUsersAndRelations.insertRelations(), Relation.class);

        return GraphFrame.apply(userDataset, relationsDataset);
    }
}
