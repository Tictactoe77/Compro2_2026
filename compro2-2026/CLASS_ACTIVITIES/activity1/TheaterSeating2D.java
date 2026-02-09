public class TheaterSeating2D {
    public static void main(String[] args) {

        int[][] theater = new int[5][8]; 

        theater[2][5] = 1;

        theater[0][0] = 1;

        System.out.println("Theater Seating Chart (0=Available, 1=Booked):");

        int bookedSeats = 0;

        for (int row = 0; row < theater.length; row++) {
            for (int col = 0; col < theater[row].length; col++) {
                System.out.print(theater[row][col] + " ");

                if (theater[row][col] == 1) {
                    bookedSeats++;
                }
            }
            System.out.println();
        }

        System.out.println("Total booked seats: " + bookedSeats);
    }
}
