package pl.edu.agh.internetshop;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.LinkedList;
import java.util.UUID;


public class Order {
    private static final BigDecimal TAX_VALUE = BigDecimal.valueOf(1.23);
	private final UUID id;
    private final LinkedList<Product> products;
    private boolean paid;
    private Shipment shipment;
    private ShipmentMethod shipmentMethod;
    private PaymentMethod paymentMethod;
    private Discount orderDiscount;

    public Order(LinkedList<Product> products) {
        this.products = products;
        id = UUID.randomUUID();
        paid = false;
        this.orderDiscount = new Discount(BigDecimal.valueOf(0));
    }

    public UUID getId() {
        return id;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public boolean isSent() {
        return shipment != null && shipment.isShipped();
    }

    public boolean isPaid() { return paid; }

    public Shipment getShipment() {
        return shipment;
    }

    public BigDecimal getPrice() {
        BigDecimal price = BigDecimal.valueOf(0);
        for(Product product : products)
            price = price.add(product.getPrice());
        return price;
    }

    public BigDecimal getPriceWithDiscounts() {
        BigDecimal price = BigDecimal.valueOf(0);
        for(Product product : products)
            price = price.add(product.getPriceWithDiscount());
        return price.multiply(BigDecimal.ONE.subtract(orderDiscount.getValue())).setScale(2, RoundingMode.HALF_UP);
    }

    public BigDecimal getPriceWithTaxes() {
        return getPrice().multiply(TAX_VALUE).setScale(Product.PRICE_PRECISION, Product.ROUND_STRATEGY);
    }

    public LinkedList<Product> getProducts() {
        return products;
    }

    public ShipmentMethod getShipmentMethod() {
        return shipmentMethod;
    }

    public void setShipmentMethod(ShipmentMethod shipmentMethod) {
        this.shipmentMethod = shipmentMethod;
    }

    public void send() {
        boolean sentSuccessful = getShipmentMethod().send(shipment, shipment.getSenderAddress(), shipment.getRecipientAddress());
        shipment.setShipped(sentSuccessful);
    }

    public void pay(MoneyTransfer moneyTransfer) {
        moneyTransfer.setCommitted(getPaymentMethod().commit(moneyTransfer));
        paid = moneyTransfer.isCommitted();
    }

    public void setShipment(Shipment shipment) {
        this.shipment = shipment;
    }

    public Discount getOrderDiscount() {
        return orderDiscount;
    }

    public void setOrderDiscount(Discount orderDiscount) {
        this.orderDiscount = orderDiscount;
    }
}
