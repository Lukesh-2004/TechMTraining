import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.PriorityQueue;
import java.util.List;
import java.util.logging.Logger;

public class InventoryManager {
    private Map<String, Product> products;
    private PriorityQueue<Order> orderQueue;
    private static final Logger logger = Logger.getLogger(InventoryManager.class.getName());

    public InventoryManager() {
        products = new ConcurrentHashMap<>();
        orderQueue = new PriorityQueue<>((o1, o2) -> o1.getPriority().compareTo(o2.getPriority()));
    }

    public synchronized void addProduct(Product product) {
        products.put(product.getProductID(), product);
        logger.info("Product added: " + product);
    }

    public void processOrders() {
        while (!orderQueue.isEmpty()) {
            Order order = orderQueue.poll();
            new Thread(() -> fulfillOrder(order)).start();
        }
    }

    private void fulfillOrder(Order order) {
        for (String productID : order.getProductIDs()) {
            Product product = products.get(productID);
            if (product != null && product.getQuantity() > 0) {
                product.setQuantity(product.getQuantity() - 1);
                logger.info("Order " + order.getOrderID() + " fulfilled for product " + productID);
            } else {
                logger.warning("Product " + productID + " is out of stock for order " + order.getOrderID());
            }
        }
    }

    public void addOrder(Order order) {
        orderQueue.add(order);
    }
}
