import java.util.Scanner;

public class SumMajorDiagonalDemo {

    public static double sumMajorDiagonal(double[][] m) {
        double sum = 0;

        for (int i = 0; i < m.length; i++) {
            sum += m[i][i];
        }

        return sum;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double[][] matrix = new double[4][4];

        System.out.println("Enter a 4-by-4 matrix row by row:");

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = input.nextDouble();
            }
        }

        double diagonalSum = sumMajorDiagonal(matrix);
        System.out.println("Sum of the elements in the major diagonal is " + diagonalSum);

        input.close();
    }
}
