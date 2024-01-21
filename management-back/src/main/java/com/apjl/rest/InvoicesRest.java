package com.apjl.rest;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apjl.dao.InvoicesDAO;
import com.apjl.model.Invoices;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("facturas")
public class InvoicesRest {

	@Autowired
	private InvoicesDAO invoicesDAO;
	
	@PostMapping("/nuevo")
	public UUID saveInvoice(@RequestBody Invoices invoice) {
		UUID invoiceID = UUID.randomUUID();
		invoice.setInvoiceID(invoiceID);
		invoicesDAO.save(invoice);
		return invoiceID;
	}
	
	@GetMapping("/listar")
	public List<Invoices> listInvoices(){
		return invoicesDAO.findAll();
	}
	
	@DeleteMapping("/eliminar/{id}")
	public void deleteInvoice(@PathVariable("id") Integer id) {
		invoicesDAO.deleteById(id);
		
	}
	
	@PutMapping("/actualizar/{id}")
	public void updateInvoice(@PathVariable("id") Integer id, @RequestBody Invoices invoice) {
		
		Invoices foundInvoice = invoicesDAO.findById(id).get();
		
		foundInvoice.setConcept(invoice.getConcept());
		foundInvoice.setInvoiceID(invoice.getInvoiceID());
		foundInvoice.setDate(invoice.getDate());
		foundInvoice.setInvoiceState(invoice.getInvoiceState());
		foundInvoice.setPrices(invoice.getPrices());
		foundInvoice.setTotalPrice(invoice.getTotalPrice());
		foundInvoice.setWork(invoice.getWork());
		
		invoicesDAO.save(foundInvoice);
		
	}
	
	
}

