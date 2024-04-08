package pl.mkochaniak.ecommerce.catalog;



import org.junit.Test;
import static org.assertj.core.api.Assertions.*;
import java.util.List;

public class HashMapProductStorageTest {
    @Test
    public void itAllowsToStoreProduct(){
    Product product = thereIsExampleProduct();
    ProductStorage hashMapStorage = thereIshashMapStorage();

    hashMapStorage.add(product);

    List<Product> products = hashMapStorage.allProducts();
    assertThat(products)
                .hasSize(1)
                .extracting(Product::getName)
                .contains("test-it");



    }

    private ProductStorage thereIshashMapStorage() {
    }

    private Product thereIsExampleProduct() {
        return null;
    }



}
