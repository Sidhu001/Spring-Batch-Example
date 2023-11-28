package com.springbatchexample.config;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.springbatchexample.entity.Customer;
import org.springframework.batch.item.ItemProcessor;

public class CustomerProcessor implements ItemProcessor<Customer, Customer> {
    @Override
    public Customer process(Customer customer) throws Exception {
        // To process those records whose mobile number length is equal to 10
        String phoneNo = customer.getContactNo().replaceAll("-","");
        String dateOfBirth = customer.getDob();
        if(customer.getDob().contains("#")){
            throw new Exception("Illegal type in dob");
        }
        return customer;
    }
}
