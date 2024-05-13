package pl.mkochaniak.ecommerce.sales;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SalesController {
    SalesFacade sales;

    public SalesController(SalesFacade sales) {

        this.sales = sales;
    }

    @GetMapping("/api/current-offer")
    Offer getCurrentOffer(){
        String customerId = getCurrentCustomerId();
        return sales.getCurrentOffer(customerId);
    }
    @PostMapping("/api/accept-offer")
    ReservationDetail(AcceptOfferRequestacceptOfferRequest){
        String customerId = getCurrentCustomerId();
        ReservationDetail reservationDetails=
                salesFocade.acceptOffer(CustomerId)
    }

    private String getCurrentCustomerId(){

        return "Mikolaj";
    }

    public static class AcceptOfferRequest {
        String firstName;
        String lastName;
        String email;


        public String getFirstName() {
            return firstName;
        }

        public AcceptOfferRequest setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public String getLastName() {
            return lastName;
        }

        public AcceptOfferRequest setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public String getEmail() {
            return email;
        }

        public AcceptOfferRequest setEmail(String email) {
            this.email = email;
            return this;
        }
    }
}
