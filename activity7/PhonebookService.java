package com.phonebook.services;

import com.phonebook.models.Contact;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class PhonebookService {

    private HashMap<String, Contact> contacts = new HashMap<>();

    // Add Contact
    public void addContact(Contact c) {
        contacts.put(c.getName(), c);
    }

    // Search Contact
    public Contact searchContact(String name) {
        return contacts.get(name);
    }

    // Remove Contact
    public boolean removeContact(String name) {
        return contacts.remove(name) != null;
    }

    // Display All Contacts
    public void displayAll() {
        if (contacts.isEmpty()) {
            System.out.println("Phonebook is empty.");
            return;
        }

        for (Map.Entry<String, Contact> entry : contacts.entrySet()) {
            System.out.println(entry.getValue());
        }
    }

    // Save to CSV
    public void saveToCSV(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {

            for (Contact c : contacts.values()) {
                writer.write(c.toCsvString());
                writer.newLine();
            }

            System.out.println("Contacts saved successfully to " + filename);

        } catch (IOException e) {
            System.out.println("Error saving file: " + e.getMessage());
        }
    }
}