package com.model;

import java.util.List;

public class InventoryReport {

	private List<Product> productList;
	private List<Transaction> transactionList;
	private List<Supplier> supplyList;
	ProuductManager productManager;
	TransactionManager transactionManager;
	SupplyManager supplyManager;

	

	public InventoryReport(List<Product> productList, List<Transaction> transactionList, List<Supplier> supplyList) {

		if (productList == null || transactionList == null || supplyList == null) {
			throw new NullPointerException("Error: One or more lists are null Cannot generate report ");
		}

		this.productList = productList;
		this.transactionList = transactionList;
		this.supplyList = supplyList;

	}

	public int getTotalProducts() {
		return productList.size();
	}

	public int getTotalSupplier() {
		return supplyList.size();

	}

	public int getTotalStockQuantity() {
		int total = 0;
		for (Product product : productList) {
			total += product.getQuantity();
		}
		return total;
	}

	public double getTotalStockValue() {
		double totalValue = 0;
		for (Product product : productList) {
			totalValue += product.getQuantity() * product.getPrice();
		}
		return totalValue;
	}

	public void displayReport() {
		System.out.println("\n--- Inventory Report ---");
		System.out.println("Total Products: " + getTotalProducts());
		System.out.println("Total suppliers: " + getTotalSupplier());
		System.out.println("Total Stock Quantity: " + getTotalStockQuantity());
		System.out.println("Total Stock Value: $" + getTotalStockValue());
		return;

	}
}
