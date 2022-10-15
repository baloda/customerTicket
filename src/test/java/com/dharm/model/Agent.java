package com.dharm.model;

import java.util.*;

public class Agent {
    private final String id;
    private final String email;
    private final String name;
    private final List<Issue> assignedIssues;

    public Agent(String email, String name, List<Issue> issues) {
        this.id = UUID.randomUUID().toString();
        this.email = email;
        this.name = name;
        this.assignedIssues = issues;
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public List<Issue> assignedIssues() {
        return assignedIssues;
    }

    public void addIssue(Issue issue) {
        assignedIssues.add(issue);
    }
}
