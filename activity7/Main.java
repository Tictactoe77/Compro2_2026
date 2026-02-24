package com.phonebook;

import com.phonebook.models.Contact;
import com.phonebook.services.PhonebookService;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        PhonebookService service = new PhonebookService();

        int choice;

        do {
            System.out.println("\n=== PHONEBOOK MENU ===");
            System.out.println("1. Add");
            System.out.println("2. Search");
            System.out.println("3. Remove");
            System.out.println("4. Display All");
            System.out.println("5. Save to CSV");
            System.out.println("0. Exit");
            System.out.print("Choose: ");

            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {

                case 1:
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter phone: ");
                    String phone = scanner.nextLine();

                    System.out.print("Enter email: ");
                    String email = scanner.nextLine();

                    Contact contact = new Contact(name, phone, email);
                    service.addContact(contact);
                    System.out.println("Contact added!");
                    break;

                case 2:
                    System.out.print("Enter name to search: ");
                    String searchName = scanner.nextLine();

                    Contact found = service.searchContact(searchName);

                    if (found != null) {
                        System.out.println("Found: " + found);
                    } else {
                        System.out.println("Contact not found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter name to remove: ");
                    String removeName = scanner.nextLine();

                    if (service.removeContact(removeName)) {
                        System.out.println("Contact removed.");
                    } else {
                        System.out.println("Contact not found.");
                    }
                    break;

                case 4:
                    service.displayAll();
                    break;

                case 5:
                    service.saveToCSV("contacts.csv");
                    break;

                case 0:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 0);

        scanner.close();
    }
}