package com.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.model.InventoryReport;
import com.model.Product;
import com.model.ProductMenu;
import com.model.ProuductManager;
import com.model.SaveManager;
import com.model.SerialisationProduct;
import com.model.SerialisationSupplier;
import com.model.Supplier;
import com.model.SupplierMenu;
import com.model.SupplyManager;
import com.model.Transaction;
import com.model.TransactionMenu;

public class InventoryManagerMain {

	static List<Product> productList;
	static List<Supplier> supplyList;
	static List<Transaction>transactionList;
	private static ProuductManager productManager;
	private static SupplyManager supplyManager;
	
	
	

	public static void main(String[] args) {
		
		
		productList=SerialisationProduct.deserialiseProducts();
		if(productList==null) {
			productList=new ArrayList<>();
		}
		
		supplyList = SerialisationSupplier.deserialiseSuppliers();
        if (supplyList == null) {
            supplyList = new ArrayList<>();
        }
        
        transactionList=new ArrayList<>();

        
		productManager = new ProuductManager(productList);
		supplyManager=new SupplyManager(supplyList);
		
		Scanner scanner = new Scanner(System.in);
		ProductMenu productMenu = new ProductMenu(productManager);
		SupplierMenu supplierMenu = new SupplierMenu(supplyManager);	
		TransactionMenu transactionMenu = new TransactionMenu(productManager);
		SerialisationProduct serialiseP = new SerialisationProduct();
		SerialisationSupplier serialiseS = new SerialisationSupplier();
		
		SaveManager saveManager = new SaveManager(productList, supplyList, transactionList);
		InventoryReport inventoryReport = new InventoryReport(productList, transactionList, supplyList);

	
			while (true) {
				
				System.out.println("\n ------- welcome to the inventory managment system-------1");
				System.out.println(" 1. Manage products ");
				System.out.println(" 2 - Manage Suppliers ");
				System.out.println(" 3 - Manage transactions ");
				System.out.println(" 4 - Save files ");
				System.out.println(" 5 - Display report ");
				System.out.println(" 6 - Exit the program");
				System.out.print("Enter your choice: ");
				int MenuChoice = scanner.nextInt();

				switch (MenuChoice) {
				
				case 1:
					productMenu.startProductMenu();
					break;

				case 2:
					supplierMenu.startSupplierMenu();
					break;

				case 3:
					transactionMenu.startTransactionMenu();
					break;

				case 4:
					saveManager.saveFiles();
					break;

				case 5:
					inventoryReport.displayReport();
					break;

				case 6:
					System.out.println("exiting the system ");
					System.exit(0);
				default:
					System.out.println("enter a valid choice");

				}
				
				
			}
		}
	}

