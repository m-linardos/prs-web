package com.prs.business;

import java.util.Optional;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class PurchaseRequestLineItem {
		
	@Id		// Declares id as primary key
	@GeneratedValue(strategy=GenerationType.IDENTITY)	// ID should be generated automatically
	private int id;
	@ManyToOne(fetch=FetchType.EAGER)	
	@JoinColumn(name = "purchaseRequestID")	
	private PurchaseRequest purchaseRequest;
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "productID")
	private Product product;
	private int quantity;
	
	// Constructors
	public PurchaseRequestLineItem(int id, PurchaseRequest purchaseRequest, Product product, int quantity) {
		super();
		this.id = id;
		this.purchaseRequest = purchaseRequest;
		this.product = product;
		this.quantity = quantity;
	}

	public PurchaseRequestLineItem() {
		super();
	}

	
	// Getters & Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public PurchaseRequest getPurchaseRequest() {
		return purchaseRequest;
	}

	public void setPurchaseRequest(PurchaseRequest purchaseRequest) {
		this.purchaseRequest = purchaseRequest;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "PurchaseRequestLineItem [id=" + id + ", purchaseRequest=" + purchaseRequest + ", product=" + product
				+ ", quantity=" + quantity + "]";
	}

	public boolean existsById(int id2) {
		// TODO Auto-generated method stub
		return false;
	}

	public Object save(PurchaseRequestLineItem prli) {
		// TODO Auto-generated method stub
		return null;
	}

	public Optional<PurchaseRequestLineItem> findById(int id2) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
