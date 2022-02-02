package mas.myitil.service;

import mas.myitil.model.User;
import mas.myitil.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.EnumSet;
import java.util.List;

import static mas.myitil.model.UserType.EMPLOYEE;
import static mas.myitil.model.UserType.TEAMLEADER;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void addUser() {
        User k = new User();

        k.setName("Test");
        k.setSurname("Nazwisko");
        k.setEmail("email");
        k.setPhoneNumber("tel");
        k.setUserType(EnumSet.of(EMPLOYEE, TEAMLEADER));

        userRepository.save(k);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findUser(Long id) throws Exception {
        return userRepository.findById(id).orElseThrow(Exception::new);
    }

    public User findUserByName(String name) throws Exception {
        return userRepository.findByName(name).orElseThrow(Exception::new);
    }
}
