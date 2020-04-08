package com.noran.graphx.demo.service;

import com.noran.graphx.demo.model.User;
import org.apache.spark.sql.Encoders;
import org.graphframes.GraphFrame;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GraphVerticesConverterService {

    public List<User> convertVertices(GraphFrame graphFrame){

        return graphFrame.vertices().as(Encoders.bean(User.class)).collectAsList();

    }
}
