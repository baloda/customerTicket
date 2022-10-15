package com.dharm.service;

import com.dharm.model.Agent;
import com.dharm.model.Issue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AgentService {
    private Map<String, Agent> agents;

    public AgentService() {
        this.agents = new HashMap<>();
    }

    public Agent getAgent(String email, String name) {
        if (agents.containsKey(email)) {
            return agents.get(email);
        }
        Agent agent = new Agent(email, name, new ArrayList<>());
        return agent;

    }

    public Agent addAgent(String email, String name, List<Issue> issueList) {
        Agent agent = getAgent(email, name);
        for (Issue issue : issueList) {
            agent.addIssue(issue);
        }
        return agent;
    }
}
