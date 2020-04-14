package com.noran.graphx.demo.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;


@Getter
@Setter
public class ShortestPathDto {
    private String id;
    private Map<String, Integer> distances;
}
