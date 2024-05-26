package pl.mkochaniak.ecommerce.sales;

import pl.mkochaniak.ecommerce.sales.offer.AcceptOfferRequest;
import pl.mkochaniak.ecommerce.sales.offer.Offer;
import pl.mkochaniak.ecommerce.sales.reservation.ReservationDetail;

public class SalesFacade {
    public Offer getCurrentOffer(String customerId) {
        return new Offer();
    }

    public ReservationDetail acceptOffer(String customerId, AcceptOfferRequest acceptOfferRequest) {
        return new ReservationDetail();
    }

    public void addToCart(String customerId, String productId) {
    }
}

