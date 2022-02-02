package mas.myitil.service;

import lombok.extern.slf4j.Slf4j;
import mas.myitil.model.Client;
import mas.myitil.model.User;
import mas.myitil.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public void addUser(User userDto) {
        Client c = new Client();
        
        c.setEmail(userDto.getEmail());

        userRepository.save(userDto);
        log.info(userDto + "saved to repo");
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
