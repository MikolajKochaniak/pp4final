package pl.mkochaniak.ecommerce.catalog;

import java.math.BigDecimal;
import java.util.*;

public class ProductCatalog {

    ArrayListProductStorage productStorage;
    private ArrayList<Product> products;

    public ProductCatalog() {
        this.products = new ArrayList<>();
    }

    public List<Product> allProducts() {
        return Collections.unmodifiableList(products);
    }

    public String addProduct(String name, String description) {
        UUID id = UUID.randomUUID();

        Product newProduct = new Product(id, name, description);

        productStorage.add(newProduct);

        return id.toString();
    }

    public Product getProductBy(String id) {
        return productStorage.getProductBy(id);
    }

    public void changePrice(String id, BigDecimal price) {
        Product loadedProduct = getProductBy(id);
        loadedProduct.changePrice(price);
    }

}
