package com.noran.graphx.demo.mapping;

import com.noran.graphx.demo.model.Relation;
import com.noran.graphx.demo.model.User;
import com.noran.graphx.demo.model.dto.GraphDto;
import com.noran.graphx.demo.service.GraphEdgesConverterService;
import com.noran.graphx.demo.service.GraphVerticesConverterService;
import org.graphframes.GraphFrame;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GraphToGraphDto {
    @Autowired
    GraphEdgesConverterService graphEdgesConverterService;
    @Autowired
    GraphVerticesConverterService graphVerticesConverterService;

    public GraphDto convertGraphToGraphDto(GraphFrame graphFrame){

        GraphDto graphDto = new GraphDto();
        List<User> userList = graphVerticesConverterService.convertVertices(graphFrame);
        List<Relation> relationList = graphEdgesConverterService.convertEdges(graphFrame);

        graphDto.setVertices(userList);
        graphDto.setEdges(relationList);

        return graphDto;
    }
}
