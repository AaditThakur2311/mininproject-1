package com.model;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class SerialisationProduct {

	private static final String FILE_NAME = "product.ser";

	public static void serialiseProduct(List<Product> productList) {

		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
			out.writeObject(productList);
			System.out.println("\n the product list has been saved succesfully");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("error while saving the product list "  +e.getMessage());
		}
	}
	
	public static List<Product> deserialiseProducts(){
		File file= new File(FILE_NAME);
			if(!file.exists()) {
				System.out.println("no file data found returning an empty list");
				return new ArrayList<>();
			}
			try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
			return( List<Product>)in.readObject();
			}
			catch (EOFException e) {
	            System.out.println("Warning: File is empty. Returning an empty product list.");
	            return new ArrayList<>();
	        } catch (IOException | ClassNotFoundException e) {
	            System.out.println("Error while loading the products list: " + e.getMessage());
	            return new ArrayList<>();
	        }
			
			}
	
	    
			
		}
	


