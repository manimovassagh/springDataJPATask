package com.github.manimovassagh.springdata.Customer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;

import com.github.manimovassagh.springdata.customer.entities.Customer;
import com.github.manimovassagh.springdata.customer.repos.CustomerRepository;

@SpringBootTest
class CustomerDataApplicationTests {
	@Autowired
	CustomerRepository repository;

	@Test
	public void contextLoads() {
		System.out.println("Check the test");
	}

	@Test
	void saveACustomer() {
		Customer customer = new Customer();
		customer.setId(1);
		customer.setName("Mani Movassagh");
		customer.setEmail("Mani.mgh@gmail.com");
		repository.save(customer);
		Assertions.assertEquals(1, customer.getId());
		Assertions.assertEquals("Mani Movassagh", customer.getName());
		Assertions.assertEquals("Mani.mgh@gmail.com", customer.getEmail());

	}

	@Test
	void getCustomerById() {
		Customer customer = repository.findById(1).get();
		Assertions.assertEquals("Mani Movassagh", customer.getName());
		Assertions.assertEquals("Mani.mgh@gmail.com", customer.getEmail());

	}

	@Test
	void updateCustomer() {
		Customer customer = repository.findById(1).get();
		customer.setName("Sahar Morattab");
		customer.setEmail("Morattab.sahar@gmail.com!");
		repository.save(customer);
	}

	@Test
	@DirtiesContext
	void deleteCustomer() {
		repository.deleteById(1);
		boolean empty = repository.findById(1).isEmpty();
		Assertions.assertTrue(empty);
	}
}
