package com.apjl.model;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Invoices {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column
	private UUID invoiceID;
	
	private String date;
	
	@Column
	private String invoiceState;
	
	@Column(length = 100000)
	private String concept;
	
	@Column
	private String prices;
	
	@Column 
	private Double totalPrice;

	@ManyToOne
	@JoinColumn
	private Works work;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public UUID getInvoiceID() {
		return invoiceID;
	}

	public void setInvoiceID(UUID invoiceID) {
		this.invoiceID = invoiceID;
	}

	public String getInvoiceState() {
		return invoiceState;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public void setInvoiceState(String invoiceState) {
		this.invoiceState = invoiceState;
	}
	
	public String getConcept() {
		return concept;
	}

	public void setConcept(String concept) {
		this.concept = concept;
	}
	
	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	public String getPrices() {
		return prices;
	}

	public void setPrices(String prices) {
		this.prices = prices;
	}


	public Works getWork() {
		return work;
	}

	public void setWork(Works work) {
		this.work = work;
	}

	
}
