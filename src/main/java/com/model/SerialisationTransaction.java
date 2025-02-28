package com.model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SerialisationTransaction {

    private static final String FILE_NAME = "transaction.ser";

    public static void serialiseTransactions(List<Transaction> transactionList) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            out.writeObject(transactionList);
            System.out.println("\nThe transaction list has been saved successfully.");
        } catch (IOException e) {
            System.out.println("Error while saving the transaction list: " + e.getMessage());
        }
    }


   
    public static List<Transaction> deserialiseTransactions() {
        File file = new File(FILE_NAME);
        if (!file.exists()) {
            System.out.println("No transaction data found. Returning an empty list.");
            return new ArrayList<>();
        }
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            return (List<Transaction>) in.readObject();
        } catch (EOFException e) {
            System.out.println("Warning: File is empty. Returning an empty transaction list.");
            return new ArrayList<>();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error while loading the transaction list: " + e.getMessage());
            return new ArrayList<>();
        }
    }
}
