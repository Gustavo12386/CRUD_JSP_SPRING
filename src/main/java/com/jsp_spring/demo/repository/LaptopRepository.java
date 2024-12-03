package com.jsp_spring.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jsp_spring.demo.entity.Laptop;

@Repository
public interface LaptopRepository extends JpaRepository<Laptop, Integer> {

}
