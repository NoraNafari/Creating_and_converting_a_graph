package com.noran.graphx.demo.model.dto;

import com.noran.graphx.demo.model.Relation;
import com.noran.graphx.demo.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GraphDto implements Serializable {
    private List<User> vertices;
    private List<Relation> edges;
}
