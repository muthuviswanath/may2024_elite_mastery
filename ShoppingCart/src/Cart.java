import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Product> cartItems = new ArrayList<>();

    public void addToCart(Product product, int quantity) throws InsufficientQuantityException {
        if (product.getQuantity() < quantity) {
            throw new InsufficientQuantityException("Insufficient quantity for product: " + product.getName());
        }
        cartItems.add(new Product(product.getName(), product.getPrice(), quantity));
        product.setQuantity(product.getQuantity() - quantity);
    }

    public void viewCart() {
        double total = 0;
    	System.out.println("Your Cart Items:");
    	System.out.println("------------------------------------------------------------------------");
        System.out.printf("%-15s%-10s%-10s\n", "Product Name", "Price", "Quantity");
        System.out.println("------------------------------------------------------------------------");
        for (Product product : cartItems) {
            System.out.println(product);
            total += product.getPrice() * product.getQuantity();
        }
        System.out.printf("Total Amount: %.2f\n", total);
        System.out.println("------------------------------------------------------------------------");
    }
}
