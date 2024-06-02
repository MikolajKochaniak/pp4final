package pl.mkochaniak.ecommerce.sales.cart;

import pl.mkochaniak.ecommerce.sales.cart.Cart;

import java.util.Optional;

public class InMemoryCartStorage {
    public Optional<Cart> findByCustomer(String customerId) {
        return Optional.empty();
    }
}
