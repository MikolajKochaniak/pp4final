package pl.mkochaniak.ecommerce.sales;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import pl.mkochaniak.ecommerce.catalog.ProductCatalog;

import java.math.BigDecimal;

@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
public class SalesHTTPTest {
    @Autowired
    TestRestTemplate http;
    @LocalServerPort
    private int port;

    @Test
    void itAllowToAcceptOffer() {
        String productId = thereIsExampleProduct("Example Product", BigDecimal.valueOf(10.10));
        String addProductURL = String.format(
                "http://localhost:%s/%s%s",
                port,
                "api/add-to-cart/",
                productId
        );
        ResponseEntity<Object> objectResponseEntity = http.postForEntity(addProductURL, null, Object.class);
        String acceptOfferUrl = String.format(
                "http://localhost:%s/%s",
                port,
                "api/accept-offer");
        SalesController.AcceptOfferRequest acceptOfferRequest = new SalesController.AcceptOfferRequest();
        acceptOfferRequest
                .setFirstName("Mikolaj")
                .setLastName("Kochaniak")
                .setEmail("kochaniak@gmail.com");

        ResponseEntity<ReservationDetail> reservationDetailResponseEntity=
                http.postForEntity(acceptOfferUrl,acceptOfferRequest,ReservationDetail.class);

        assertEquals(reservationDetailResponseEntity.getStatusCode(),HttpStatus.OK);
        assertNotNull(reservationDetailResponseEntity.getBody().getReservationId());
        assertNotNull(reservationDetailResponseEntity.getBody().getPaymentUrl());

    }
    @Autowired
    ProductCatalog catalog;
    private String thereIsExampleProduct(String name, BigDecimal bigDecimal) {
        var id = catalog.addProduct(name, name);
        catalog.changePrice(id,price);
        return id;

    }

    private String thereIsExampleProduct() {
        return "productX";
    }


}
