package Model;

public class Ticket {
    private int ticketId;
    private String name;
    private int seatNumber;
    private boolean status;
    private String coach;

    public Ticket(int ticketId, String name, int seatNumber, boolean status, String coach) {
        this.ticketId = ticketId;
        this.name = name;
        this.seatNumber = seatNumber;
        this.status = status;
        this.coach = coach;
    }

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
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

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getCoach() {
        return coach;
    }

    public void setCoach(String coach) {
        this.coach = coach;
    }
}
