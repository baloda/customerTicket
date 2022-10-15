package com.dharm.model;

import java.util.*;

public class Customer {
    private final String id;
    private final String email;
    private final List<Issue> createdIssues;

    public Customer(String email) {
        this.id = UUID.randomUUID().toString();
        this.email = email;
        this.createdIssues = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public List<Issue> getCreatedIssues() {
        return createdIssues;
    }

    public void AddIssue(Issue issue) {
        createdIssues.add(issue);
    }



}
