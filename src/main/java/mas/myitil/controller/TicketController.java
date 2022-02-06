package mas.myitil.controller;

import mas.myitil.model.ticket.TicketAddDTO;
import mas.myitil.model.ticket.TicketDTO;
import mas.myitil.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/ticket")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @PostMapping("/add")
    public void addTicket(@RequestBody TicketAddDTO ticket) throws Exception {
        ticketService.addTicket(ticket);
    }

    @GetMapping("/details/{id}")
    public TicketDTO findTicket(@PathVariable Long id) throws Exception {
        return ticketService.findTicketById(id);
    }

    @GetMapping("/list")
    public List<TicketDTO> findAllTickets() {
        return ticketService.findAll();
    }


    @GetMapping("/delete/{id}")
    public void deleteTicket(@PathVariable Long id) {
        ticketService.deleteTicket(id);
    }

}
