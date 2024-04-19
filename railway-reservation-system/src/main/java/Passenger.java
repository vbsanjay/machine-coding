public class Passenger {
    private static int idProvider = 0;
    private int id;
    private String name;
    private int seatNumber;
    private char preferredBerth;
    private String status;

    public Passenger(String name, char preferredBerth){
        this.id = idProvider++;
        this.name = name;
        this.preferredBerth = preferredBerth;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public char getPreferredBerth() {
        return preferredBerth;
    }

    public void setPreferredBerth(char preferredBerth) {
        this.preferredBerth = preferredBerth;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", seatNumber=" + seatNumber +
                ", preferredBerth=" + preferredBerth +
                ", status='" + status + '\'' +
                '}';
    }
}
