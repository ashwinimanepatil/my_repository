package net.viralpatel.spring.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import net.viralpatel.spring.dao.CustomerDAO;
import net.viralpatel.spring.model.Customer;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class CustomerRestController {
	HashMap<String, String> map = new HashMap<>();
	
	@Autowired
	private CustomerDAO customerDAO;

	
	@GetMapping("/customers")
	public List getCustomers() {
		return customerDAO.list();
	}


	public Map getCustomers1(List<Customer> customers){
		HashMap<String, String> map = new HashMap<>();
		customers.forEach(Customer -> {
			this.map.put(Customer.getUserName(), Customer.getPassword());
		});
		return map;
	}
	
	
	@PostMapping(value = "/writeCustomers")
	public ResponseEntity createCustomer(@RequestBody Customer customer) {
		getCustomers();
		getCustomers1(getCustomers());
		
		if (this.map.containsKey(customer.getUserName())){
			String password=this.map.get(customer.getUserName());
			if(customer.getPassword().equals(password)) {
				System.out.println("Login successful");
				return new ResponseEntity(customer, HttpStatus.OK);
				
			}
			else {
				System.out.println("Incorrect password");
				return  new ResponseEntity(customer, HttpStatus.NOT_FOUND);
			}
			}
			else {
				System.out.println("Login failed");
				return  new ResponseEntity(customer, HttpStatus.NOT_FOUND);
     		}		
		}
}