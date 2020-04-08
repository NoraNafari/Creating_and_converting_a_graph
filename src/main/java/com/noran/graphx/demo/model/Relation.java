package com.noran.graphx.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Random;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Relation {
    private String type;
    private String src;
    private String dst;
    private Long id;

    public Relation(String type, String src, String dst) {
        this.type = type;
        this.src = src;
        this.dst = dst;
        this.id = new Random().nextLong();
    }

}
