package com.hcl.userstock.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class UserStockdetails implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private int userId;
	private int productId;
	private String productName;
	private int quantity;
	private double price;

	@Temporal(TemporalType.DATE)
	private Date dateTime;

	public UserStockdetails(int id, int userId, int productId, String productName, int quantity, double price,
			Date dateTime) {
		super();
		this.id = id;
		this.userId = userId;
		this.productId = productId;
		this.productName = productName;
		this.quantity = quantity;
		this.price = price;
		this.dateTime = dateTime;
	}

	public UserStockdetails() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

	@Override
	public String toString() {
		return "UserStockdetails [id=" + id + ", userId=" + userId + ", productId=" + productId + ", productName="
				+ productName + ", quantity=" + quantity + ", price=" + price + ", dateTime=" + dateTime + "]";
	}

}
