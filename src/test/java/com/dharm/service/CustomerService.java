package com.dharm.service;

import com.dharm.model.Customer;
import com.dharm.model.Issue;

import java.util.HashMap;
import java.util.Map;

public class CustomerService {

    Map<String, Customer> customers;


    public CustomerService() {
        this.customers = new HashMap<>();
    }

    public Customer getCustomer(String email) {
        if (customers.containsKey(email)) {
            return customers.get(email);
        }
        Customer customer = new Customer(email);
        customers.put(customer.getEmail(), customer);
        return customer;
    }

    public Customer addCustomer(String email, Issue issue) {
        Customer customer = getCustomer(email);
        customer.AddIssue(issue);
        return customer;
    }
}
