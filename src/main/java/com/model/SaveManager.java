package com.model;

import java.util.List;
import java.util.Scanner;

public class SaveManager {

	List<Product> productList;
	List<Supplier> supplyList;
	List<Transaction> transactionList;

	public SaveManager(List<Product> productList, List<Supplier> supplyList, List<Transaction> transactionList) {
		super();
		this.productList = productList;
		this.supplyList = supplyList;
		this.transactionList = transactionList;
	}

	public void saveFiles() {
		Scanner sc = new Scanner(System.in);
		System.out.println("press 1 to save the product list in the file");
		System.out.println("press 2 to save the supply list in the file ");
		System.out.println("press 3 to save the transaction list in the file");
		System.out.println("press 4 to save all the lists in the files ");
		int saveChoice = sc.nextInt();
		switch (saveChoice) {
		case 1:
			SerialisationProduct.serialiseProduct(productList);
			System.out.println("the product list has been saved succesully in the file");
			break;
		case 2:
			SerialisationSupplier.serialiseSuppliers(supplyList);
			System.out.println("the supplier list has been saved succesfully in the file");
			break;

		case 3:
			SerialisationTransaction.serialiseTransactions(transactionList);
			System.out.println("the transaction list has been saved succesfully in the file");
			break;
		case 4:
			SerialisationProduct.serialiseProduct(productList);
			SerialisationSupplier.serialiseSuppliers(supplyList);
			SerialisationTransaction.serialiseTransactions(transactionList);
			break;

		}

	}
}
