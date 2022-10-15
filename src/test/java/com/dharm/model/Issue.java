package com.dharm.model;

import java.util.UUID;

public class Issue {
    String id;
    String transactionId;
    IssueType issueType;
    String subject;
    String description;

    public Issue(String transactionId, IssueType issueType, String subject, String description) {
        this.id = UUID.randomUUID().toString();
        this.transactionId = transactionId;
        this.issueType = issueType;
        this.subject = subject;
        this.description = description;
    }

    public String getId() {
        return  id;
    }
}
