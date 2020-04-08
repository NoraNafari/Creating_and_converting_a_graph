package com.noran.graphx.demo.service;

import com.noran.graphx.demo.model.Relation;
import org.apache.spark.sql.Encoders;
import org.graphframes.GraphFrame;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GraphEdgesConverterService {

    public List<Relation> convertEdges(GraphFrame graphFrame){
        return graphFrame.edges().as(Encoders.bean(Relation.class)).collectAsList();
    }
}
