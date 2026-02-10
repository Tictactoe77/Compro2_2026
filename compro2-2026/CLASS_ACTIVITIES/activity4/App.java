import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    // Storage
    static double[][] grades = new double[50][3]; // [subject][Prelim, Midterm, Final]
    static String[] subjects = new String[50];
    static int subjectCount = 0;

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int choice;

        while (true) {
            System.out.println("\n===== STUDENT PORTFOLIO =====");
            System.out.println("[1] Enter Grade");
            System.out.println("[2] Exit");
            System.out.print("Choose option: ");

            choice = getIntInput();

            switch (choice) {
                case 1:
                    enterGrade();
                    break;

                case 2:
                    saveToCSV();
                    System.out.println("Grades saved to grades.csv");
                    System.out.println("Exiting program...");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }

    // Enter subject and grades
    private static void enterGrade() {
        if (subjectCount >= 50) {
            System.out.println("Maximum number of subjects reached.");
            return;
        }

        sc.nextLine(); // clear buffer

        System.out.print("Enter subject name: ");
        subjects[subjectCount] = sc.nextLine();

        System.out.print("Enter Prelim grade: ");
        grades[subjectCount][0] = getDoubleInput();

        System.out.print("Enter Midterm grade: ");
        grades[subjectCount][1] = getDoubleInput();

        System.out.print("Enter Final grade: ");
        grades[subjectCount][2] = getDoubleInput();

        subjectCount++;
        System.out.println("Subject added successfully.");
    }

    // Save data to CSV file
    private static void saveToCSV() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("grades.csv"))) {

            // Header
            writer.write("Subject,Prelim,Midterm,Final");
            writer.newLine();

            for (int i = 0; i < subjectCount; i++) {
                writer.write(
                        subjects[i] + "," +
                        grades[i][0] + "," +
                        grades[i][1] + "," +
                        grades[i][2]
                );
                writer.newLine();
            }

        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }

    // Safe integer input
    private static int getIntInput() {
        while (!sc.hasNextInt()) {
            System.out.print("Invalid input. Enter a number: ");
            sc.next();
        }
        return sc.nextInt();
    }

    // Safe double input
    private static double getDoubleInput() {
        while (!sc.hasNextDouble()) {
            System.out.print("Invalid input. Enter a number: ");
            sc.next();
        }
        return sc.nextDouble();
    }
}
