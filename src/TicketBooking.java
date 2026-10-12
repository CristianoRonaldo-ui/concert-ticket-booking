public class TicketBooking {
    public static void main(String[] args) {
        Concert concert = new Concert("Summer Jazz Night", 5);

        System.out.println("Concert: " + concert.getName());
        System.out.println("Available Seats: " + concert.getAvailableSeats());

        concert.bookTickets(3);
        System.out.println("Booked 3 tickets. Available seats: " + concert.getAvailableSeats());

        try {
            concert.bookTickets(10);
            System.out.println("This line will never be printed because the previous line will throw an exception");
        } catch (IllegalArgumentException e) {
            System.out.println("Booking failed: " + e.getMessage());
        }

        System.out.println("Program continues. Available seats: " + concert.getAvailableSeats());

        runTests();

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
    }
}