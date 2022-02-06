package mas.myitil.assembler;

import mas.myitil.model.ticket.Ticket;
import mas.myitil.model.ticket.TicketAddDTO;
import mas.myitil.model.ticket.TicketStatus;
import mas.myitil.model.user.User;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class TicketAssembler {
    public Ticket fromDto(TicketAddDTO ticketAddDTO, User client, User employee) {
        Ticket ticket = new Ticket();

        ticket.setTitle(ticketAddDTO.getTitle());
        ticket.setDescription(ticketAddDTO.getDescription());
        ticket.setCreatedAt(LocalDateTime.now());
        ticket.setTicketStatus(TicketStatus.valueOf(ticketAddDTO.getTicketStatus()));
        ticket.setClient(client);
        ticket.setEmployee(employee);

        return ticket;
    }
}
