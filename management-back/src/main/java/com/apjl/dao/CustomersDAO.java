package com.apjl.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apjl.model.Customers;

public interface CustomersDAO extends JpaRepository<Customers, Integer>{

}
