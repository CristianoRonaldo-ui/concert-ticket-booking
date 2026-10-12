import java.util.Scanner;

public class TicketBooking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Concert concert = new Concert("Summer Jazz Night", 5);
        boolean running = true;

        System.out.println("Welcome to " + concert.getName() + " ticket booking!");

        while (running) {
            System.out.println();
            System.out.println("Available seats: " + concert.getAvailableSeats());
            System.out.println("1. Book tickets");
            System.out.println("2. Run tests");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");
            String choice = scanner.nextLine().trim();

            if (choice.equals("1")) {
                System.out.print("How many tickets? ");
                String input = scanner.nextLine().trim();
                try {
                    int quantity = Integer.parseInt(input);
                    concert.bookTickets(quantity);
                    System.out.println("Booked " + quantity + " ticket(s) successfully!");
                } catch (NumberFormatException e) {
                    System.out.println("Please enter a whole number.");
                } catch (IllegalArgumentException e) {
                    System.out.println("Booking failed: " + e.getMessage());
                }
            } else if (choice.equals("2")) {
                runTests();
            } else if (choice.equals("0")) {
                running = false;
                System.out.println("Goodbye!");
            } else {
                System.out.println("Invalid option. Please choose 1, 2 or 0.");
            }
        }

        scanner.close();
    }

    public static void runTests() {
        System.out.println("\n--- Running tests ---");

        // Test 1: a valid booking should reduce available seats
        Concert concert1 = new Concert("Test Concert", 10);
        concert1.bookTickets(4);
        if (concert1.getAvailableSeats() == 6) {
            System.out.println("Test 1 PASS: valid booking reduces seats");
        } else {
            System.out.println("Test 1 FAIL: expected 6, got " + concert1.getAvailableSeats());
        }

        // Test 2: overbooking should throw an exception
        Concert concert2 = new Concert("Test Concert", 2);
        boolean thrown = false;
        try {
            concert2.bookTickets(5);
        } catch (IllegalArgumentException e) {
            thrown = true;
        }
        if (thrown) {
            System.out.println("Test 2 PASS: overbooking throws exception");
        } else {
            System.out.println("Test 2 FAIL: expected an exception but none was thrown");
        }

        // Test 3: booking zero tickets should throw an exception
        Concert concert3 = new Concert("Test Concert", 5);
        boolean thrownForZero = false;
        try {
            concert3.bookTickets(0);
        } catch (IllegalArgumentException e) {
            thrownForZero = true;
        }
        if (thrownForZero) {
            System.out.println("Test 3 PASS: booking zero tickets throws exception");
        } else {
            System.out.println("Test 3 FAIL: expected an exception but none was thrown");
        }

        // Test 4: creating a concert with negative seats should throw an exception
        boolean thrownForNegativeSeats = false;
        try {
            new Concert("Test Concert", -5);
        } catch (IllegalArgumentException e) {
            thrownForNegativeSeats = true;
        }
        if (thrownForNegativeSeats) {
            System.out.println("Test 4 PASS: negative total seats throws exception");
        } else {
            System.out.println("Test 4 FAIL: expected an exception but none was thrown");
        }
    }
}