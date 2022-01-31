package mas.myitil.controller;

import mas.myitil.model.Osoba;
import mas.myitil.service.OsobaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/users")
public class OsobaController {

    @Autowired
    private OsobaService osobaService;

    @GetMapping("/add")
    public void addOsoba() {
        osobaService.addOsoba();
    }

    @GetMapping("")
    public List<Osoba> findAllOsoba() {
        return osobaService.findAll();
    }
}
