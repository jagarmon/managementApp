package com.apjl.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apjl.model.Works;

public interface WorksDAO extends JpaRepository<Works, Integer> {

}
