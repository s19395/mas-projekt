package mas.myitil.service;

import lombok.extern.slf4j.Slf4j;
import mas.myitil.model.ticket.Note;
import mas.myitil.model.ticket.NoteAddDTO;
import mas.myitil.model.ticket.repository.NoteRepository;
import mas.myitil.model.ticket.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Service
@Slf4j
public class NoteService {
    @Autowired
    private NoteRepository noteRepository;
    @Autowired
    private TicketRepository ticketRepository;


    @Transactional
    public void addNote(NoteAddDTO noteDto) throws Exception {
        Note note = new Note();

        note.setTitle(noteDto.getTitle());
        note.setContent(noteDto.getContent());
        note.setCreatedAt(LocalDateTime.now());
        note.setTicket(ticketRepository.findById(noteDto.getTicketId()).orElseThrow(Exception::new));

        noteRepository.save(note);

        log.info("{} saved to repository", note);
    }

    public List<Note> findAll() {

        return noteRepository.findAll();
    }

    public void deleteNote(Long id) {
        noteRepository.deleteById(id);
        log.info("Note with id: {} deleted from repository", id);
    }
}
