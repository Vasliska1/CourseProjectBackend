package ifmo.ru.CourceWorkBackEnd.DTO;

import lombok.Data;

@Data
public class InfoDeliveryDTO {


    private String name;
    private String lastName;
    private String car;

    public InfoDeliveryDTO(String name, String lastName, String car) {
        this.name = name;
        this.lastName = lastName;
        this.car = car;
    }
}
