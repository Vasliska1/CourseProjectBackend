package ifmo.ru.CourceWorkBackEnd.DTO;

import java.util.List;

public class ListProduct {
    public List<ProductDTO> getProducts() {
        return products;
    }

    public void setProducts(List<ProductDTO> products) {
        this.products = products;
    }

    private List<ProductDTO> products;
}
