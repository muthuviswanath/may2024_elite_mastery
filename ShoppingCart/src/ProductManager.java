import java.util.ArrayList;
import java.util.List;

public class ProductManager {
    private List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
    }

    public void updateProduct(String productName, double newPrice, int newQuantity) throws ProductNotFoundException {
        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(productName)) {
                product.setPrice(newPrice);
                product.setQuantity(newQuantity);
                return;
            }
        }
        throw new ProductNotFoundException("Product not found: " + productName);
    }

    public void deleteProduct(String productName) throws ProductNotFoundException {
        boolean removed = products.removeIf(product -> product.getName().equalsIgnoreCase(productName));
        if (!removed) {
            throw new ProductNotFoundException("Product not found: " + productName);
        }
    }

    public List<Product> getProducts() {
        return products;
    }

    public Product findProductByName(String productName) throws ProductNotFoundException {
        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(productName)) {
                return product;
            }
        }
        throw new ProductNotFoundException("Product not found: " + productName);
    }
}
