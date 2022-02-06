package mas.myitil.model.ticket;

public enum TicketStatus {
    OPEN("Open"),
    IN_PROGRESS("In Progress"),
    CLIENT_INPUT_REQUIRED("Client Input Required"),
    RESOLVED("Resolved");

    private final String name;

    TicketStatus(String name ) {
        this.name = name;
    }

    public String getTicketStatusName() {
        return name;
    }
}
