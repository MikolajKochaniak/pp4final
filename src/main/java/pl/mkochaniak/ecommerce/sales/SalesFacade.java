package pl.mkochaniak.ecommerce.sales;

import pl.mkochaniak.ecommerce.sales.cart.Cart;
import pl.mkochaniak.ecommerce.sales.cart.InMemoryCartStorage;
import pl.mkochaniak.ecommerce.sales.offer.AcceptOfferRequest;
import pl.mkochaniak.ecommerce.sales.offer.Offer;
import pl.mkochaniak.ecommerce.sales.offer.OfferCalculator;
import pl.mkochaniak.ecommerce.sales.payment.PaymentDetails;
import pl.mkochaniak.ecommerce.sales.payment.PaymentGateway;
import pl.mkochaniak.ecommerce.sales.payment.RegisterPaymentRequest;
import pl.mkochaniak.ecommerce.sales.reservation.Reservation;
import pl.mkochaniak.ecommerce.sales.reservation.ReservationDetail;
import pl.mkochaniak.ecommerce.sales.reservation.ReservationRepository;

import java.util.UUID;

public class SalesFacade {
    private InMemoryCartStorage cartStorage;
    private OfferCalculator offerCalculator;
    private PaymentGateway paymentGateway;
    private ReservationRepository reservationRepository;

    public SalesFacade(InMemoryCartStorage cartStorage, OfferCalculator offerCalculator, PaymentGateway paymentGateway, ReservationRepository reservationRepository) {
        this.cartStorage = cartStorage;
        this.offerCalculator = offerCalculator;
        this.paymentGateway = paymentGateway;
        this.reservationRepository = reservationRepository;
    }

    public Offer getCurrentOffer(String customerId) {
        Cart cart = loadCartForCustomer(customerId);

        Offer currentOffer = offerCalculator.calculate(cart.getLines());

        return currentOffer;
    }

    public ReservationDetail acceptOffer(String customerId, AcceptOfferRequest acceptOfferRequest) {
        String reservationId = UUID.randomUUID().toString();
        Offer offer = this.getCurrentOffer(customerId);

        PaymentDetails paymentDetails = paymentGateway.registerPayment(
                RegisterPaymentRequest.of(reservationId, acceptOfferRequest, offer.getTotal())
        );
        Reservation reservation = Reservation.of(
                reservationId,
                customerId,
                acceptOfferRequest,
                offer,
                paymentDetails);

        reservationRepository.add(reservation);

        return new ReservationDetail(reservationId, paymentDetails.getPaymentUrl());
    }

    public void addToCart(String customerId, String productId) {
        Cart cart = loadCartForCustomer(customerId);

        cart.addProduct(productId);
    }

    private Cart loadCartForCustomer(String customerId) {
        return cartStorage.findByCustomer(customerId)
                .orElse(Cart.empty());
    }
}

