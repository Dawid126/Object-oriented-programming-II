package pl.edu.agh.internetshop;

public class RecipientNameSearchStrategy implements SearchStrategy{
    private String receiverName;
    public RecipientNameSearchStrategy(String receiverName) {
        this.receiverName = receiverName;
    }

    public boolean filter(Order order) {
        return order.getShipment().getRecipientAddress().getName().equals(receiverName);
    }
}
