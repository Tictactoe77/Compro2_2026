import java.util.Scanner;

public class SumColumnDemo {

    public static double sumColumn(double[][] m, int columnIndex) {
        double sum = 0;

        for (int row = 0; row < m.length; row++) {
            sum += m[row][columnIndex];
        }

        return sum;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double[][] matrix = new double[3][4];

        System.out.println("Enter a 3-by-4 matrix row by row:");

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = input.nextDouble();
            }
        }

        for (int col = 0; col < matrix[0].length; col++) {
            double columnSum = sumColumn(matrix, col);
            System.out.println("Sum of column " + col + " is " + columnSum);
        }

        input.close();
    }
}
