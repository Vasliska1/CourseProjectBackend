package ifmo.ru.CourceWorkBackEnd.DTO;

import lombok.Data;

@Data
public class DeliveryDTO {

    String antistress;
    int count;
    String address;
    int deliveryId;

    public DeliveryDTO(String antistress, int count, String address, int deliveryId) {
        this.deliveryId = deliveryId;
        this.antistress = antistress;
        this.count = count;
        this.address = address;
    }
}
