package com.dox.springdemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dox.springdemo.entity.Customer;
import com.dox.springdemo.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerRest {
	
		@Autowired
		private CustomerService customerService;
	
		@GetMapping("/customers")
		public List<Customer> getAllCustomers() {
			List<Customer> theCustomer = customerService.getCustomers();
			return theCustomer;
		}
		@GetMapping("/customers/{customerId}")
		public Customer getCustomers(@PathVariable int customerId) {
			Customer theCustomer = customerService.getCustomer(customerId);
			return theCustomer;
		}
		@PostMapping("/customers")
		public Customer addCustomer(@RequestBody Customer theCustomer) {
			theCustomer.setId(0);
			customerService.saveCustomer(theCustomer);
			return theCustomer;
		}
		@PutMapping("/customers")
		public Customer updateCustomer(@RequestBody Customer theCustomer) {
			customerService.saveCustomer(theCustomer);
			return theCustomer;
		}
		@DeleteMapping("/customers/{customerId}")
		public String deleteCustomer(@PathVariable int customerId) {
			customerService.deleteCustomer(customerId);
			return "Deleted customer id - "+customerId;
		}
		
}
