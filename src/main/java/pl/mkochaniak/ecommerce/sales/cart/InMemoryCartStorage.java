package pl.mkochaniak.ecommerce.sales.cart;
import java.util.HashMap;
import pl.mkochaniak.ecommerce.sales.cart.Cart;

import java.util.Map;
import java.util.Optional;

public class InMemoryCartStorage {

    Map<String, Cart> carts;
    public InMemoryCartStorage(){
        this.carts = new HashMap<>();
    }
    public Optional<Cart> findByCustomer(String customerId) {
        return Optional.of(carts.get(customerId));
    }
    public void save(String customerId, Cart cart){
        carts.put(customerId,cart);
    }
}
