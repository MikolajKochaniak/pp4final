package pl.mkochaniak.ecommerce.infrastructure;

import pl.mkochaniak.ecommerce.sales.payment.PaymentDetails;
import pl.mkochaniak.ecommerce.sales.payment.PaymentGateway;
import pl.mkochaniak.ecommerce.sales.payment.RegisterPaymentRequest;

public class PayUPaymentGateway implements PaymentGateway {
    @Override
    public PaymentDetails registerPayment(RegisterPaymentRequest registerPaymentRequest) {
        return null;
    }
}
