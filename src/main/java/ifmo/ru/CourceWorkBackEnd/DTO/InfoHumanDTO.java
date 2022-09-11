package ifmo.ru.CourceWorkBackEnd.DTO;

import lombok.Data;

@Data
public class InfoHumanDTO {

    private String name;
    private String lastName;
    private String address;
    private String phone;
    private String city;
    private String district;

    public InfoHumanDTO(String name, String lastName, String address, String phone, String city, String district) {
        this.name = name;
        this.lastName = lastName;
        this.address = address;
        this.phone = phone;
        this.city = city;
        this.district = district;
    }
}
