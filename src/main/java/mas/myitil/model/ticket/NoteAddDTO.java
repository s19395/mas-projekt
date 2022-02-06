package mas.myitil.model.ticket;

import lombok.Data;

@Data
public class NoteAddDTO {
    private String title;
    private String content;
    private Long ticketId;
}
