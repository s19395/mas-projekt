package mas.myitil.service;

import lombok.extern.slf4j.Slf4j;
import mas.myitil.assembler.TicketAssembler;
import mas.myitil.assembler.UserAssembler;
import mas.myitil.model.ticket.Ticket;
import mas.myitil.model.ticket.TicketAddDTO;
import mas.myitil.model.ticket.TicketDTO;
import mas.myitil.model.ticket.repository.TicketRepository;
import mas.myitil.model.user.User;
import mas.myitil.model.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.isNull;

@Service
@Slf4j
public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TicketAssembler ticketAssembler;
    @Autowired
    private UserAssembler userAssembler;

    @Transactional
    public void addTicket(TicketAddDTO ticketAddDto) throws Exception {
        Ticket ticket = new Ticket();

        User client = userRepository.findById(ticketAddDto.getClient().getId()).orElseThrow(Exception::new);
        User employee = userRepository.findById(ticketAddDto.getEmployee().getId()).orElseThrow(Exception::new);

        ticket = ticketAssembler.fromDto(ticketAddDto, client, employee);

        ticketRepository.save(ticket);
        log.info("{} saved to repository", ticket);
    }

    public List<TicketDTO> findAll() {
        List<TicketDTO> ticketListDto = new ArrayList<>();

        List<Ticket> ticketList = ticketRepository.findAll();

        ticketList.forEach(ticket -> {
            TicketDTO ticketDTO = new TicketDTO();

            ticketDTO.setTicketId(ticket.getTicketId());
            ticketDTO.setTitle(ticket.getTitle());
            ticketDTO.setDescription(ticket.getDescription());
            ticketDTO.setCreatedAt(ticket.getCreatedAt());
            ticketDTO.setTicketStatus(ticket.getTicketStatus().getTicketStatusName());
            ticketDTO.setNotes(ticket.getNotes());
            if (!isNull(ticket.getClient()))
                ticketDTO.setClient(userAssembler.toDto(ticket.getClient()));
            if (!isNull(ticket.getEmployee()))
                ticketDTO.setEmployee(userAssembler.toDto(ticket.getEmployee()));

            ticketListDto.add(ticketDTO);
        });

        return ticketListDto;
    }

    public TicketDTO findTicketById(Long id) throws Exception {
        Ticket ticket = ticketRepository.findById(id).orElseThrow(Exception::new);

        TicketDTO ticketDTO = new TicketDTO();

        ticketDTO.setTicketId(ticket.getTicketId());
        ticketDTO.setTitle(ticket.getTitle());
        ticketDTO.setDescription(ticket.getDescription());
        ticketDTO.setCreatedAt(ticket.getCreatedAt());
        ticketDTO.setTicketStatus(ticket.getTicketStatus().getTicketStatusName());
        ticketDTO.setNotes(ticket.getNotes());
        if (!isNull(ticket.getClient()))
            ticketDTO.setClient(userAssembler.toDto(ticket.getClient()));
        if (!isNull(ticket.getEmployee()))
            ticketDTO.setEmployee(userAssembler.toDto(ticket.getEmployee()));

        return ticketDTO;
    }

    public void deleteTicket(Long id) {
        ticketRepository.deleteById(id);
        log.info("Ticket with id: {} deleted from repository", id);
    }
}
