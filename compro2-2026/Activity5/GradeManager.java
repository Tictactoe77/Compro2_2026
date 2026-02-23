import java.io.*;
import java.util.*;

public class GradeManager {

    private static ArrayList<Grade> grades = new ArrayList<>();
    private static final String FILE_NAME = "grades.csv";

    public static void main(String[] args) {
        loadGrades();
        menu();
    }

    // ===========================
    // Menu System
    // ===========================

    private static void menu() {

        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== GRADE MANAGEMENT MENU =====");
            System.out.println("1. Add Grades");
            System.out.println("2. Display Grades");
            System.out.println("3. Search Grades");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");

            choice = scanner.nextInt();
            scanner.nextLine(); // buffer clear

            switch (choice) {

                case 1 -> addGrade(scanner);

                case 2 -> displayGrades();

                case 3 -> searchGrade(scanner);

                case 0 -> {
                    saveGrades();
                    System.out.println("Data saved. Program exiting...");
                }

                default -> System.out.println("Invalid choice!");
            }

        } while (choice != 0);

        scanner.close();
    }

    // ===========================
    // Option 1: Add Grades
    // ===========================

    private static void addGrade(Scanner scanner) {

        System.out.print("Enter Subject Name: ");
        String subject = scanner.nextLine();

        System.out.print("Enter Prelim Grade: ");
        double prelim = scanner.nextDouble();

        System.out.print("Enter Midterm Grade: ");
        double midterm = scanner.nextDouble();

        System.out.print("Enter Final Grade: ");
        double finals = scanner.nextDouble();

        grades.add(new Grade(subject, prelim, midterm, finals));

        System.out.println("Subject saved successfully!");
    }

    // ===========================
    // Option 2: Display Grades
    // ===========================

    private static void displayGrades() {

        if (grades.isEmpty()) {
            System.out.println("No subjects stored.");
            return;
        }

        System.out.println("\n===== GRADE LIST =====");

        for (Grade g : grades) {
            System.out.println(
                    "Subject: " + g.getSubjectName() +
                    ", Prelim: " + g.getPrelim() +
                    ", Midterm: " + g.getMidterm() +
                    ", Final: " + g.getFinals()
            );
        }
    }

    // ===========================
    // Option 3: Search Grades
    // ===========================

    private static void searchGrade(Scanner scanner) {

        System.out.print("Enter subject name to search: ");
        String search = scanner.nextLine();

        for (Grade g : grades) {
            if (g.getSubjectName().equalsIgnoreCase(search)) {

                System.out.println("\nSubject Found!");
                System.out.println("Subject: " + g.getSubjectName());
                System.out.println("Prelim: " + g.getPrelim());
                System.out.println("Midterm: " + g.getMidterm());
                System.out.println("Final: " + g.getFinals());
                return;
            }
        }

        System.out.println("Subject not found.");
    }

    // ===========================
    // File Persistence
    // ===========================

    private static void saveGrades() {

        try (BufferedWriter bw =
                     new BufferedWriter(new FileWriter(FILE_NAME))) {

            for (Grade g : grades) {
                bw.write(g.toCSV());
                bw.newLine();
            }

        } catch (Exception e) {
            System.out.println("Error saving grades.");
        }
    }

    // Optional: Load existing grades
    private static void loadGrades() {

        File file = new File(FILE_NAME);

        if (!file.exists()) return;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {

            String line;

            while ((line = br.readLine()) != null) {

                String[] parts = line.split(",");

                if (parts.length == 4) {
                    grades.add(new Grade(
                            parts[0],
                            Double.parseDouble(parts[1]),
                            Double.parseDouble(parts[2]),
                            Double.parseDouble(parts[3])
                    ));
                }
            }

        } catch (Exception e) {
            System.out.println("Error loading grades.");
        }
    }
}