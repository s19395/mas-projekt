package mas.myitil.model.ticket;

import lombok.Data;
import mas.myitil.model.user.UserDTO;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class TicketDTO {
    private Long ticketId;
    private String title;
    private String description;
    private LocalDateTime createdAt;
    private String ticketStatus;
    private List<Note> notes;
    private UserDTO client;
    private UserDTO employee;
}
