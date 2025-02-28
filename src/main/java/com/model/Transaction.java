package com.model;

import java.util.Date;

public class Transaction {
    private int transactionId;
    private int productId;
    private String type; // ADD or REMOVE
    private int quantity;
    private Date date;

    
       
	public Transaction(int transactionId, int productId, String type, int quantity,  Date date) {
		super();
		this.transactionId = transactionId;
		this.productId = productId;
		this.type = type;
		this.quantity = quantity;
		this.date = date;
	}

	

	public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Transaction [transactionId=" + transactionId + ", productId=" + productId + ", type=" + type + 
               ", quantity=" + quantity + ",  date=" + date + "]";
    }
}
