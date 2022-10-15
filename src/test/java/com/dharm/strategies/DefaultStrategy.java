package com.dharm.strategies;

import com.dharm.model.Agent;

import java.util.*;

public class DefaultStrategy implements Strategy {
    List<Agent> availableAgents;

    public DefaultStrategy() {
        this.availableAgents = new ArrayList<>();
    }

    public List<Agent> getAvailableAgents() {
        return availableAgents;
    }

    @Override
    public void addAgent(Agent agent) {
        availableAgents.add(agent);
    }

    @Override
    public void removeAgent(Agent agent) {
        availableAgents.remove(agent);
    }

    @Override
    public Agent getNextFreeAgent() {
        return availableAgents.stream().findFirst().get();
    }
}
