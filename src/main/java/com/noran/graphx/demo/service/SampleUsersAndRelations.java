package com.noran.graphx.demo.service;

import com.noran.graphx.demo.model.Relation;
import com.noran.graphx.demo.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SampleUsersAndRelations {

    List<User> insertUsers(){
        List<User> users = new ArrayList<>();
        users.add(new User(1L, "a"));
        users.add(new User(2L, "b"));
        users.add(new User(3L, "c"));
        users.add(new User(4L, "d"));
        users.add(new User(5L, "e"));

        return users;
    }
    List<Relation> insertRelations(){
        List<Relation> relations = new ArrayList<>();
        relations.add(new Relation( "friend", "a", "b"));
        relations.add(new Relation( "friend", "a", "c"));
        relations.add(new Relation( "friend", "a", "d"));
        relations.add(new Relation( "friend", "a", "b"));
        relations.add(new Relation( "friend", "b", "d"));
        relations.add(new Relation( "friend", "d", "e"));
        relations.add(new Relation( "friend", "d", "a"));
        relations.add(new Relation( "follower", "a", "e"));
        relations.add(new Relation( "follower", "e", "d"));
        relations.add(new Relation( "relative", "c", "b"));
        relations.add(new Relation( "relative", "b", "d"));

        return relations;
    }
}
