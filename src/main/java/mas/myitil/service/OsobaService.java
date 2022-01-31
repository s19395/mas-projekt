package mas.myitil.service;

import mas.myitil.model.Klient;
import mas.myitil.model.Osoba;
import mas.myitil.model.repository.OsobaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OsobaService {

    @Autowired
    private OsobaRepository osobaRepository;

    public void addOsoba() {
        Klient k = new Klient();

        k.setImie("Imie");
        k.setNazwisko("Nazwisko");
        k.setEmail("email");
        k.setNumerTelefonu("tel");

        osobaRepository.save(k);
    }

    public List<Osoba> findAll() {
        return osobaRepository.findAll();
    }
}
