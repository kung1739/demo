package com.springboot.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.demo.model.Customer;
import com.springboot.demo.model.CustomerRepository;

@RestController
public class CustomerAPI {
	
	@Autowired
	private CustomerRepository cusDao;
	
	@PostMapping(value = "customer/insert")
	public Customer insertCustomer() {
		Customer cus = new Customer();
		cus.setLevel(5);
		cus.setName("館長");
		Customer res = cusDao.save(cus);
		return res;
	}
	
	@PostMapping(value = "customer/insert2")
	public Customer insertCustomer(@RequestBody Customer cus) {
		Customer res = cusDao.save(cus);
		return res;
	}
	
	@PostMapping(value = "customer/insertAll")
	public List<Customer> insertAll(@RequestBody List<Customer> Customer) {
		List<Customer> res = cusDao.saveAll(Customer);
		return res;
		
	}
	
	@GetMapping(value = "customer")
	public Customer findById(@RequestParam  Integer id) {
		Optional<Customer> option = cusDao.findById(id);
		if(option.isPresent()) {
			return option.get();
		}			
		return null;
	}
	
	@GetMapping(value = "customer/{id}")
	public Customer getById2(@PathVariable Integer id) {
		Optional<Customer> option = cusDao.findById(id);
		if (option.isPresent()) {
			return option.get();
		}
		return null;
	}
	
	@GetMapping(value = "customer/page/{pageNumber}")
	public List<Customer> findByPage(@PathVariable Integer pageNumber) {
		Pageable pgb = PageRequest.of(pageNumber-1, 3, Sort.Direction.ASC, "id");
		Page<Customer> page = cusDao.findAll(pgb);
		List<Customer> res = page.getContent();
		return res;
	}
	
	@GetMapping(value = "customer/name")
	public List<Customer> findByName(@RequestParam String name){		
		return cusDao.findByName(name);		
	}
	
	@GetMapping(value = "customer/name2")
	public List<Customer> findByName2(@RequestParam String name){		
		return cusDao.findByName2(name);		
	}
	
	@PostMapping(value = "customer/update")
	public boolean findByName2(Integer id, Integer level){		
		cusDao.updateLevel(id, level);		
		return true;		
	}
	
	@GetMapping(value = "customer/level")
	public List<Customer> findByLevel(@RequestParam  Integer level) {
		return cusDao.findByLevel(level);
	}
	
	// test
	@GetMapping(value = "customer/level")
	public List<Customer> findByLevel2(@RequestParam  Integer level) {
		return cusDao.findByLevel(level);
	}
}
