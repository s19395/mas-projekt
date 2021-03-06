package mas.myitil.controller;

import mas.myitil.model.user.ClientDTO;
import mas.myitil.model.user.User;
import mas.myitil.model.user.UserDTO;
import mas.myitil.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public void addUser(@RequestBody ClientDTO client) throws Exception {
        userService.addUser(client);
    }

    @GetMapping("/details/{id}")
    public User findUser(@PathVariable Long id) throws Exception {
        return userService.findUserById(id);
    }

    @GetMapping("/list")
    public List<User> findAllUsers() {
        return userService.findAll();
    }

    @GetMapping("/autocomplete")
    public List<UserDTO> findAllClients() {
        return userService.findAllClientsAndEmployees();
    }

    @GetMapping("/delete/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}
