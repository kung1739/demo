package com.springboot.demo.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	
	@Query("from Customer where name = :name")
	public List<Customer> findByName(@Param(value = "name") String name);
	
	@Query(value="select * from customer where name = :name",nativeQuery=true)
	public List<Customer> findByName2(@Param(value = "name") String name);
	
	@Transactional
	@Modifying
	@Query(value = "update Customer c set c.level = :level where c.id = :id")
	public void updateLevel(@Param("id") Integer id, @Param("level") Integer level);
	
	public List<Customer> findByLevel(Integer id);

}
