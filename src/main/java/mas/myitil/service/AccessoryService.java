package mas.myitil.service;

import lombok.extern.slf4j.Slf4j;
import mas.myitil.model.equipment.Accessory;
import mas.myitil.model.equipment.AccessoryDTO;
import mas.myitil.model.equipment.repository.AccessoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class AccessoryService {

    @Autowired
    private AccessoryRepository accessoryRepository;

    public void addAccessory(AccessoryDTO accessory) {
        //accessoryRepository.save(accessory);
    }

    public List<Accessory> findAll() {
        List<Accessory> accessoryList =  accessoryRepository.findAll();
        return accessoryList;
    }

    public void deleteAccessory(Long id) {
        accessoryRepository.deleteById(id);
        log.info("Accessory with id: {} deleted from repository", id);
    }
}
