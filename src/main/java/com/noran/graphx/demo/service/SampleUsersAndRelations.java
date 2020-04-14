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
        users.add(new User("1", "a"));
        users.add(new User("2", "b"));
        users.add(new User("3", "c"));
        users.add(new User("4", "d"));
        users.add(new User("5", "e"));

        return users;
    }

    List<Relation> insertRelations(){
        List<Relation> relations = new ArrayList<>();
        relations.add(new Relation( "friend", "1", "2"));
        relations.add(new Relation( "friend", "1", "3"));
        relations.add(new Relation( "friend", "1", "4"));
        relations.add(new Relation( "friend", "1", "5"));
        relations.add(new Relation( "friend", "2", "4"));
        relations.add(new Relation( "friend", "4", "5"));
        relations.add(new Relation( "friend", "4", "1"));
        relations.add(new Relation( "follower", "1", "5"));
        relations.add(new Relation( "follower", "5", "4"));
        relations.add(new Relation( "relative", "3", "2"));
        relations.add(new Relation( "relative", "2", "4"));

        return relations;
    }
}
