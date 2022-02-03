package mas.myitil.controller;

import mas.myitil.model.Client;
import mas.myitil.model.User;
import mas.myitil.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public void addUser(@RequestBody Client client) {
        userService.addUser(client);
    }

    @GetMapping("/list")
    public List<User> findAllUsers() {
        return userService.findAll();
    }

    @GetMapping("")
    public User findUser(@RequestParam(required = false) String name) throws Exception {
        return userService.findUserByName(name);
    }

    @GetMapping("/delete/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }

}
