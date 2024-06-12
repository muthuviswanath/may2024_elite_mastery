import java.util.ArrayList;
import java.util.List;

public class Wishlist {
    private List<Product> wishlistItems = new ArrayList<>();

    public void addToWishlist(Product product) {
        wishlistItems.add(new Product(product.getName(), product.getPrice(), product.getQuantity()));
    }

    public void viewWishlist() {
    	System.out.println("Your Wishlist Items:");
    	System.out.println("---------------------------------");
        System.out.printf("%-15s\n", "Product Name");
        System.out.println("---------------------------------");
        for (Product product : wishlistItems) {
            System.out.println(product.getName());
        }
        System.out.println("---------------------------------");
    }
}
