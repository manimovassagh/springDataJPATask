package com.github.manimovassagh.springdata.customer.repos;

import org.springframework.data.repository.CrudRepository;

import com.github.manimovassagh.springdata.customer.entities.Customer;

import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {
    public List<Customer> findByName(String name); 
}
