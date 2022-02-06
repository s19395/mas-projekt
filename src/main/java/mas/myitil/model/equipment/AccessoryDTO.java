package mas.myitil.model.equipment;

import lombok.Data;
import mas.myitil.model.user.UserDTO;

@Data
public class AccessoryDTO {
    private Long equipmentId;
    private String brand;
    private String model;
    private String productNumber;
    private UserDTO user;
}
