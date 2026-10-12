public class Concert {
    private String name;
    private int totalSeats;
    private int bookedSeats;

    public Concert(String name, int totalSeats) {
        this.name = name;
        this.totalSeats = totalSeats;
        this.bookedSeats = 0;
    }

    public String getName() {
        return name;
    }

    public int getAvailableSeats() {
        return totalSeats - bookedSeats;
    }

    public void bookTickets(int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than zero");
        }
        if (quantity > getAvailableSeats()) {
            throw new IllegalArgumentException(
                "Not enough available seats. Only " + getAvailableSeats() + " seats are available"
            );
        }
        bookedSeats += quantity;
    }
}