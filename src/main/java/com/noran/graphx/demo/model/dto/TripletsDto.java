package com.noran.graphx.demo.model.dto;

import com.noran.graphx.demo.model.Relation;
import com.noran.graphx.demo.model.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TripletsDto {

    private User src;
    private Relation edge;
    private User dst;

}
