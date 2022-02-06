package mas.myitil.controller;

import mas.myitil.model.ticket.Note;
import mas.myitil.model.ticket.NoteAddDTO;
import mas.myitil.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/note")
public class NoteController {

    @Autowired
    private NoteService noteService;

    @PostMapping("/add")
    public void addNote(@RequestBody NoteAddDTO noteDto) throws Exception {

        noteService.addNote(noteDto);
    }

    @GetMapping("/list")
    public List<Note> findAllNotes() {
        return noteService.findAll();
    }


    @GetMapping("/delete/{id}")
    public void deleteNote(@PathVariable Long id) {
        noteService.deleteNote(id);
    }

}
