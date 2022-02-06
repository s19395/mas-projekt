package mas.myitil.model.user;

import lombok.Data;

@Data
public class ClientDTO {
    private Long id;
    private String name;
    private String surname;
    private String email;
}
