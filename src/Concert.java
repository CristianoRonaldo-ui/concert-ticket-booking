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
}