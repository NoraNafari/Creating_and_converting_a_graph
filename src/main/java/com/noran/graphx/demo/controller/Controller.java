package com.noran.graphx.demo.controller;

import com.noran.graphx.demo.mapping.GraphToGraphDto;
import com.noran.graphx.demo.model.dto.*;
import com.noran.graphx.demo.service.CreateGraphService;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Encoders;
import org.apache.spark.sql.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class Controller {

    @Autowired
    CreateGraphService createGraphService;
    @Autowired
    GraphToGraphDto graphToGraphDto;

    @GetMapping
    GraphDto createJsonFromGraph() {
        return graphToGraphDto.convertGraphToGraphDto(createGraphService.createGraphFrame());
    }

    @GetMapping("/pageRank")
    List<PageRankDto> calculatePageRank() {
        return createGraphService.createGraphFrame()
                .pageRank().maxIter(20).resetProbability(0.15)
                .run().vertices().select("id", "pagerank")
                .as(Encoders.bean(PageRankDto.class))
                .collectAsList();
    }

    @PostMapping("/shortestPath")
    List<ShortestPathDto> calculateShortestPath(@RequestBody LandmarksDto landmarksDto) {
        return createGraphService.createGraphFrame()
                .shortestPaths().landmarks(landmarksDto.getUsers())
                .run().select("id", "distances")
                .as(Encoders.bean(ShortestPathDto.class))
                .collectAsList();
    }

    @GetMapping("/triangleCount")
    List<TriangleCountDto> calculateTriangles(){
        return createGraphService.createGraphFrame()
                .triangleCount().run().select("count", "id")
                .as(Encoders.bean(TriangleCountDto.class))
                .collectAsList();
    }

}
