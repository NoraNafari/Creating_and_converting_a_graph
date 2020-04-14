package com.noran.graphx.demo.controller;

import com.noran.graphx.demo.mapping.GraphToGraphDto;
import com.noran.graphx.demo.model.dto.GraphDto;
import com.noran.graphx.demo.model.dto.LandmarksDto;
import com.noran.graphx.demo.model.dto.PageRankDto;
import com.noran.graphx.demo.model.dto.ShortestPathDto;
import com.noran.graphx.demo.service.CreateGraphService;
import org.apache.spark.sql.Encoders;
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
}
