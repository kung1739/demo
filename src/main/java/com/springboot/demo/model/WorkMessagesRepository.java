package com.springboot.demo.model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkMessagesRepository extends JpaRepository<WorkMessages, Integer> {
	
	public WorkMessages findFirstByOrderByAddedDesc();
	
}
