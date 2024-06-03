package pl.mkochaniak.ecommerce.payu;

public class OrderCreateRequest {
    String notifyUrl;
    String CustomerIp;
    String merchantPosId;
    String description;
    String currencyCode;
    Integer TotalAmount;
    String extOrderId;
    Buyer buyer;
    List<Product>products;



}
