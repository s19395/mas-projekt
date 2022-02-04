package mas.myitil.model.ticket;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@Entity
@Table(name = "TICKET")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "TICKET_ID", updatable = false, nullable = false)
    private Long ticketId;

    @Column(name = "TITLE", nullable = false)
    private String title;

    @Column(name = "DESC", nullable = false)
    private String description;

    @Column(name = "CREATED_AT", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "STATUS", nullable = false)
    @Enumerated(EnumType.STRING)
    private TicketStatus ticketStatus;

    @OneToMany(mappedBy="ticket")
    @JsonManagedReference
    private Set<Note> notes;


}
