import java.util.Scanner;

public class GradeSystem {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Grade System Main Menu ===");
            System.out.println("[1] Enter Grades");
            System.out.println("[2] Display Grades");
            System.out.println("[3] Exit");
            System.out.print("Enter your choice: ");

            int choice = input.nextInt();

            switch (choice) {
                case 1:
                    enterGradesMenu(input);
                    break;

                case 2:
                    displayGrades();
                    break;

                case 3:
                    System.out.println("Exiting program...");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please enter 1, 2, or 3.");
            }
        }
    }

    private static void enterGradesMenu(Scanner input) {

        while (true) {
            System.out.println("\n--- Enter Grades Menu ---");
            System.out.println("[1] COMPRO2");
            System.out.println("[2] DSA");
            System.out.println("[3] OOP");
            System.out.println("[0] Go Back");
            System.out.print("Select a subject: ");

            int choice = input.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Grades saved for COMPRO2.");
                    break;

                case 2:
                    System.out.println("Grades saved for DSA.");
                    break;

                case 3:
                    System.out.println("Grades saved for OOP.");
                    break;

                case 0:
                    System.out.println("Returning to Main Menu...");
                    return;

                default:
                    System.out.println("Invalid choice. Please enter 0–3.");
            }
        }
    }

    private static void displayGrades() {
        System.out.println("\nDisplaying grades...");
        System.out.println("Grades will be shown here once implemented.");
    }
}
