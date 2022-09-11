package ifmo.ru.CourceWorkBackEnd.DTO;

import java.util.List;

public class DeliveryListDTO {

    private List<DeliveryDTO> deliveries;

    public List<DeliveryDTO> getDeliveries() {
        return deliveries;
    }

    public void setDeliveries(List<DeliveryDTO> deliveries) {
        this.deliveries = deliveries;
    }
}
