import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class App {

    private static String[] subjects = new String[50];     
    private static double[][] grades = new double[50][3];  
    private static int subjectCount = 0;                   
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Personal Grade Portfolio ===");
            System.out.println("[1] Add Subject & Grades");
            System.out.println("[2] Display Grades");
            System.out.println("[3] Save & Exit");
            System.out.print("Enter choice: ");

            int choice = input.nextInt();
            input.nextLine(); 

            switch (choice) {
                case 1:
                    addSubject(input);
                    break;

                case 2:
                    displayGrades();
                    break;

                case 3:
                    saveToCSV();
                    System.out.println("Grades saved successfully. Goodbye!");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addSubject(Scanner input) {

        if (subjectCount >= 50) {
            System.out.println("Maximum number of subjects reached.");
            return;
        }

        System.out.print("Enter subject name: ");
        subjects[subjectCount] = input.nextLine();

        System.out.print("Enter Prelim grade: ");
        grades[subjectCount][0] = input.nextDouble();

        System.out.print("Enter Midterm grade: ");
        grades[subjectCount][1] = input.nextDouble();

        System.out.print("Enter Final grade: ");
        grades[subjectCount][2] = input.nextDouble();

        subjectCount++;
        System.out.println("Subject and grades added successfully.");
    }

    private static void displayGrades() {

        if (subjectCount == 0) {
            System.out.println("No grades recorded yet.");
            return;
        }

        System.out.println("\n--- Grade Portfolio ---");
        System.out.println("Subject | Prelim | Midterm | Final");

        for (int i = 0; i < subjectCount; i++) {
            System.out.println(
                subjects[i] + " | " +
                grades[i][0] + " | " +
                grades[i][1] + " | " +
                grades[i][2]
            );
        }
    }

   private static void saveToCSV() {

    try (BufferedWriter writer = new BufferedWriter(
            new FileWriter("C:\\Users\\tausc\\OneDrive\\Documents\\grade_portfolio.csv"))) {

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

        System.out.println("CSV file saved at: C:\\Users\\tausc\\OneDrive\\Documents\\grade_portfolio.csv");

    } catch (IOException e) {
        System.out.println("Error saving file: " + e.getMessage());
    }
}

        }
