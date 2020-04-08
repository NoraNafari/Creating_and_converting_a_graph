package com.noran.graphx.demo.controller;

import com.noran.graphx.demo.mapping.GraphToGraphDto;
import com.noran.graphx.demo.model.dto.GraphDto;
import com.noran.graphx.demo.service.CreateGraphService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
