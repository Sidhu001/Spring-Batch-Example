package com.springbatchexample.config;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.springbatchexample.entity.Customer;
import org.springframework.batch.item.ItemProcessor;

public class CustomerProcessor implements ItemProcessor<Customer, Customer> {
    @Override
    public Customer process(Customer customer) throws Exception {
        return customer;
    }
}
