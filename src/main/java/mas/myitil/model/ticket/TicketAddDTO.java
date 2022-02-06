package mas.myitil.model.ticket;

import lombok.Data;
import mas.myitil.model.user.UserDTO;

@Data
public class TicketAddDTO {
    private Long ticketId;
    private String title;
    private String description;
    private String ticketStatus;
    private UserDTO client;
    private UserDTO employee;
}
