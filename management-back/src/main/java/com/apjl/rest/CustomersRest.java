package com.apjl.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apjl.dao.CustomersDAO;
import com.apjl.model.Customers;
import com.apjl.payload.CustomerResponse;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("clientes")
public class CustomersRest {

	@Autowired
	private CustomersDAO customerDAO;
	
	@Value("Entidad eliminada correctamente")	
	private String successMessage;
	
	@Value("El cliente tiene trabajos asignados, elimine los trabajos asignados e inténtelo de nuevo")	
	private String failMessage;
	
	@PostMapping("/nuevo")
	public void saveCustomer(@RequestBody Customers customer) {
		customerDAO.save(customer);
	}
	
	@GetMapping("/listar")
	public List<Customers> listCustomers(){
		return customerDAO.findAll();
	}
	
	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<CustomerResponse> deleteCustomer(@PathVariable("id") Integer id) {
		Customers customer = customerDAO.findById(id).get();
		try {
		customerDAO.deleteById(id);
		}catch(DataIntegrityViolationException e) {
			return new ResponseEntity<>(new CustomerResponse(customer.getFirstName()+ " " + customer.getLastName(), failMessage),HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(new CustomerResponse(customer.getFirstName()+ " " + customer.getLastName(), successMessage),HttpStatus.OK);
	}
	
	@PutMapping("/actualizar/{id}")
	public void updateCustomer(@PathVariable("id") Integer id, @RequestBody Customers customer) {
		
		Customers cust = customerDAO.findById(id).get();
		
		cust.setDni(customer.getDni());
		cust.setFirstName(customer.getFirstName());
		cust.setLastName(customer.getLastName());
		cust.setBankAccount(customer.getBankAccount());
		cust.setAddress(customer.getAddress());
		cust.setCity(customer.getCity());
		cust.setPostalCode(customer.getPostalCode());
		cust.setImage(customer.getImage());
		
		customerDAO.save(cust);
		
	}
	
	
}
