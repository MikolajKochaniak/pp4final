package pl.mkochaniak.ecommerce.catalog;

import org.junit.jupiter.api.Test;

import static com.sun.beans.introspect.PropertyInfo.Name.description;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SpringBootTest(
    webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
public class HttpProductCatalogTest {
    @LocalServerPort
    private int localPort;
@Autowired
ProductCatalog productCatalog;

    @Autowired
    TestRestTemplate http;
    @Test
    void homepageLoads(){
        var url = String.format("https://localhost:%s/%s",
        localPort,
        "/");
        ResponseEntity<String> response = http.getForEntity(url, String.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).contains("My Ecommerce");
    }
    @Test
    void loadsProducts() {
        var id = productCatalog.addProduct("Example Product", "exp dec");
        var url = String.format("https://localhost:%s/%s",localPort,"/");

        ResponseEntity<Product[]> response = http.getForEntity(url,Product[].class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody())
                .extracting("name")
                .contains("Example product");
    }
}
