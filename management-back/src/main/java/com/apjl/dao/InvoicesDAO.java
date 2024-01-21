package com.apjl.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apjl.model.Invoices;

public interface InvoicesDAO extends JpaRepository<Invoices, Integer>{

}
