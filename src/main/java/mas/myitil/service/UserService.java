package mas.myitil.service;

import lombok.extern.slf4j.Slf4j;
import mas.myitil.assembler.UserAssembler;
import mas.myitil.model.user.Client;
import mas.myitil.model.user.ClientDTO;
import mas.myitil.model.user.User;
import mas.myitil.model.user.UserDTO;
import mas.myitil.model.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserAssembler userAssembler;

    @Transactional
    public void addUser(ClientDTO clientDto) throws Exception {
        Client client = userAssembler.fromDto(clientDto);

        userRepository.save(client);

        log.info("{} saved to repository", client);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public List<UserDTO> findAllClientsAndEmployees() {
        List<User> userList = userRepository.findAllClientsAndEmployees();

        return userAssembler.toDto(userList);
    }

    public User findUser(Long id) throws Exception {
        return userRepository.findById(id).orElseThrow(Exception::new);
    }

    public User findUserById(Long id) throws Exception {
        return userRepository.findById(id).orElseThrow(Exception::new);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
        log.info("User with id: {} deleted from repository", id);
    }
}
