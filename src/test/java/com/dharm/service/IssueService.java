package com.dharm.service;

import com.dharm.exceptions.AgentNotFoundException;
import com.dharm.exceptions.IssueNotFoundException;
import com.dharm.model.Agent;
import com.dharm.model.Customer;
import com.dharm.model.Issue;
import com.dharm.model.IssueType;
import com.dharm.strategies.DefaultStrategy;
import com.dharm.strategies.Strategy;

import java.awt.dnd.DragGestureEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class IssueService {
    List<Issue> issueList;
    Map<String, Issue> allIssues;
    CustomerService customerService;
    AgentService agentService;
    Strategy strategy;

    public IssueService(DefaultStrategy strategy, CustomerService customerService, AgentService agentService) {
        this.issueList = new ArrayList<>();
        this.customerService = customerService;
        this.agentService = agentService;
        this.strategy = strategy;

    }

    public void createIssue(String transactionId, IssueType issueType, String subject, String description, String email) {
        Issue issue = new Issue(transactionId, issueType, subject, description);
        Customer customer = customerService.addCustomer(email, issue);
        allIssues.put(issue.getId(), issue);
    }

    public  void addAgent(String agentEmail, String agentName ,List<Issue> issues) {
        Agent agent = agentService.addAgent(agentEmail, agentName, issues);
        strategy.addAgent(agent);
    }

    void assignIssue(String issueId) {
        if (!allIssues.containsKey(issueId)) {
            throw new IssueNotFoundException();
        }

        Agent agent = strategy.getNextFreeAgent();
        if (agent== null) {
            throw new AgentNotFoundException();
        }
        Issue issue = allIssues.get(issueId);
        agent.addIssue(issue);
    }


}
