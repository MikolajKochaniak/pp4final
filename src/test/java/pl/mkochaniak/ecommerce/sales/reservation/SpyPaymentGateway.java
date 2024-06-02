package pl.mkochaniak.ecommerce.sales.reservation;

import pl.mkochaniak.ecommerce.sales.payment.PaymentDetails;
import pl.mkochaniak.ecommerce.sales.payment.PaymentGateway;
import pl.mkochaniak.ecommerce.sales.payment.RegisterPaymentRequest;

public class SpyPaymentGateway implements PaymentGateway {
    Integer requestCount = 0;
    public RegisterPaymentRequest lastRequest;
    public Integer getRequestCount() {
        return requestCount;
    }

    @Override
    public PaymentDetails registerPayment(RegisterPaymentRequest registerPaymentRequest) {
        this.requestCount++;
        lastRequest = registerPaymentRequest;
        return new PaymentDetails("http://spy-gateway");
    }
}
