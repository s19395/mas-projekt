package mas.myitil.controller;

import mas.myitil.model.equipment.Accessory;
import mas.myitil.model.equipment.AccessoryDTO;
import mas.myitil.service.AccessoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/accessory")
public class AccessoryController {
    @Autowired
    private AccessoryService accessoryService;

    @PostMapping("/add")
    public void addNote(@RequestBody AccessoryDTO accessory) throws Exception {

        accessoryService.addAccessory(accessory);
    }

    @GetMapping("/list")
    public List<Accessory> findAllAccessories() {
        return accessoryService.findAll();
    }


    @GetMapping("/delete/{id}")
    public void deleteAccessory(@PathVariable Long id) {
        accessoryService.deleteAccessory(id);
    }

}
