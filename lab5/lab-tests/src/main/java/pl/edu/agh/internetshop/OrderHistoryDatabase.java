package pl.edu.agh.internetshop;

import org.graalvm.compiler.core.common.type.ArithmeticOpTable;

import java.util.ArrayList;
import java.util.Iterator;

public class OrderHistoryDatabase {
    private ArrayList<Order> orders;

    public OrderHistoryDatabase(ArrayList<Order> orders) {
        this.orders = orders;
    }

    public OrderHistoryDatabase() {
        this.orders = new ArrayList<>();
    }

    public Iterator<Order> iterator() {
        return orders.iterator();
    }

    public Iterator<Order> iterator(SearchStrategy searchStrategy) {
        ArrayList<Order> ordersToBeReturned = new ArrayList<>();
        for(Order order: orders) {
            if(searchStrategy.filter(order)) {
                ordersToBeReturned.add(order);
            }
        }
        return ordersToBeReturned.iterator();
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

}
