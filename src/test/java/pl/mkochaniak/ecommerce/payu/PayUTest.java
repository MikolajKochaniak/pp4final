package pl.mkochaniak.ecommerce.payu;
;


public class PayUTest {
    @Test
    void creatingNewPayment() {
        PayU payu = thereIsPayU();
        OrderCreateRequest orderCreateRequest = createExampleOrderCreateRequest();
        OrderCreateResponse response = payu.handle(orderCreateRequest);
        assertNotNull(response.getRedirectUri());
        assertNotNull(response.getOrderId());
    }
    private OrderCreateRequest createExampleOrderCreateRequest() {
        var createRequest = new OrderCreateRequest();
    }

        private PayU thereIsPayU(){
            retrn new PayU();
        }










    }

}
