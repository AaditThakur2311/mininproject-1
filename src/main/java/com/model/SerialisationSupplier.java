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

public class SerialisationSupplier {
	
	private static final String FILE_NAME = "supplier.ser";

	public static void serialiseSuppliers(List<Supplier>supplyList) {

		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
			out.writeObject(supplyList);
			System.out.println("\n the supply list has been saved succesfully");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("error while saving the supply list "  +e.getMessage());
		}
	}
	
	public static List<Supplier> deserialiseSuppliers(){
		File file= new File(FILE_NAME);
			if(!file.exists()) {
				System.out.println("no file data found returning an empty list");
				return new ArrayList<>();
			}
			try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
			return( List<Supplier>)in.readObject();
			}
			catch (EOFException e) {
	            System.out.println("Warning: File is empty. Returning an empty suppliers list.");
	            return new ArrayList<>();
	        } catch (IOException | ClassNotFoundException e) {
	            System.out.println("Error while loading the suppliers list: " + e.getMessage());
	            return new ArrayList<>();
	        }
			
			}
			
		}
	



