package net.viralpatel.spring.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import net.viralpatel.spring.model.Customer;

@Component
public class CustomerDAO {
	
	private static List<Customer> customers;
	{
		customers = new ArrayList();
		customers.add(new Customer("Ashwini", "ash@123"));
		customers.add(new Customer("Komal", "komal@123" ));
		customers.add(new Customer("Poonam", "poo@123"));
	}

	public List<Customer> list() {
		return customers;
	}

	
	public Customer create(Customer customer) {
		customers.add(customer);
		return customer;
	}

}