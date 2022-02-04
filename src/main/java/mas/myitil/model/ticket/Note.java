package mas.myitil.model.ticket;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "NOTE")
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "NOTE_ID", updatable = false, nullable = false)
    private Long noteId;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "CONTENT")
    private String content;

    @Column(name = "CREATED_AT")
    private LocalDateTime createdAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="TICKET_ID")
    @JsonBackReference
    private Ticket ticket;
}
