import java.util.Arrays;
import java.util.logging.Logger;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        InventoryManager inventoryManager = new InventoryManager();

        // Initialize inventory with some products
        inventoryManager.addProduct(new Product("P001", "Widget", 100, new Location(1, 1, 1)));
        inventoryManager.addProduct(new Product("P002", "Gadget", 50, new Location(1, 1, 2)));
        inventoryManager.addProduct(new Product("P003", "Doodad", 75, new Location(1, 2, 1)));

        // Create and add orders
        Order order1 = new Order("O001", Arrays.asList("P001", "P002"), Order.Priority.EXPEDITED);
        Order order2 = new Order("O002", Arrays.asList("P002", "P003"), Order.Priority.STANDARD);

        inventoryManager.addOrder(order1);
        inventoryManager.addOrder(order2);

        // Process orders
        inventoryManager.processOrders();
    }
}
