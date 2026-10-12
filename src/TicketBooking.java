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

    }
}   