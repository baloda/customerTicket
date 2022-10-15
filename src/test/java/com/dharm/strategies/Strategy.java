package com.dharm.strategies;

import com.dharm.model.Agent;

public interface Strategy {
    void addAgent(Agent agent);
    void removeAgent(Agent agent);
    Agent getNextFreeAgent();

}
