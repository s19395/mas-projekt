package mas.myitil.assembler;

import mas.myitil.model.user.Client;
import mas.myitil.model.user.ClientDTO;
import mas.myitil.model.user.User;
import mas.myitil.model.user.UserDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserAssembler {
    public List<UserDTO> toDto(List<User> userList) {
        List<UserDTO> userDtoList = new ArrayList<>();

        userList.forEach(user -> {
            UserDTO userDTO = new UserDTO();

            userDTO.setId(user.getUserId());
            userDTO.setName(user.getName());
            userDTO.setSurname(user.getSurname());
            userDTO.setEmail(user.getEmail());

            userDtoList.add(userDTO);
        });

        return userDtoList;
    }

    public UserDTO toDto(User user) {
        UserDTO userDto = new UserDTO();

        userDto.setId(user.getUserId());
        userDto.setName(user.getName());
        userDto.setSurname(user.getSurname());
        userDto.setEmail(user.getEmail());

        return userDto;
    }

    public Client fromDto(ClientDTO userDto) {
        Client user = new Client();

        user.setName(userDto.getName());
        user.setSurname(userDto.getSurname());
        user.setEmail(userDto.getEmail());

        return user;
    }
}
