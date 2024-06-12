import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Menu {
    private Scanner scanner;
    private ProductManager productManager = new ProductManager();
    private List<User> users = new ArrayList<>();
    private Map<String, Cart> userCarts = new HashMap<>();
    private Map<String, Wishlist> userWishlists = new HashMap<>();
    private User admin = new User("admin", "admin123", true);

    public Menu(Scanner scanner) {
        this.scanner = scanner;
        users.add(admin);
    }

    public void showMainMenu() {
        while (true) {
            System.out.println("Main Menu:");
            System.out.println("1. Registration");
            System.out.println("2. Login");
            System.out.println("3. Exit Application");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1 -> registerUser();
                case 2 -> loginUser();
                case 3 -> {
                    System.out.println("Exiting Application...");
                    return;
                }
                default -> System.out.println("Invalid choice, please try again.");
            }
        }
    }

    private void registerUser() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        System.out.print("Enter account type (admin/user): ");
        String accountType = scanner.nextLine();
        boolean isAdmin = accountType.equalsIgnoreCase("admin");
        users.add(new User(username, password, isAdmin));
        userCarts.put(username, new Cart());
        userWishlists.put(username, new Wishlist());
        System.out.println("User registered successfully.");
    }

    private void loginUser() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        for (User user : users) {
            if (user.getUsername().equals(username) && user.authenticate(password)) {
                if (user.isAdmin()) {
                    showAdminMenu(user);
                } else {
                    showUserMenu(user);
                }
                return;
            }
        }
        System.out.println("Invalid user credentials.");
    }

    private void showAdminMenu(User admin) {
        while (true) {
            System.out.println("Admin Menu:");
            System.out.println("1. Add Product");
            System.out.println("2. Edit Product");
            System.out.println("3. Delete Product");
            System.out.println("4. Logout");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1 -> addProduct();
                case 2 -> editProduct();
                case 3 -> deleteProduct();
                case 4 -> {
                    System.out.println("Logging out...");
                    return;
                }
                default -> System.out.println("Invalid choice, please try again.");
            }
        }
    }

    private void showUserMenu(User user) {
        Cart cart = userCarts.get(user.getUsername());
        Wishlist wishlist = userWishlists.get(user.getUsername());

        while (true) {
            System.out.println("User Menu:");
            System.out.println("1. View Products");
            System.out.println("2. Add Product to Cart");
            System.out.println("3. Add Product to Wishlist");
            System.out.println("4. View Cart Items");
            System.out.println("5. View Wishlist Items");
            System.out.println("6. Logout");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1 -> viewProducts();
                case 2 -> addProductToCart(cart);
                case 3 -> addProductToWishlist(wishlist);
                case 4 -> cart.viewCart();
                case 5 -> wishlist.viewWishlist();
                case 6 -> {
                    System.out.println("Logging out...");
                    return;
                }
                default -> System.out.println("Invalid choice, please try again.");
            }
        }
    }

    private void addProduct() {
        System.out.print("Enter product name: ");
        String name = scanner.nextLine();
        System.out.print("Enter product price: ");
        double price = scanner.nextDouble();
        System.out.print("Enter product quantity: ");
        int quantity = scanner.nextInt();
        scanner.nextLine(); // consume newline

        Product product = new Product(name, price, quantity);
        productManager.addProduct(product);
        System.out.println("Product added successfully.");
    }

    private void editProduct() {
        System.out.print("Enter product name to edit: ");
        String name = scanner.nextLine();
        System.out.print("Enter new product price: ");
        double price = scanner.nextDouble();
        System.out.print("Enter new product quantity: ");
        int quantity = scanner.nextInt();
        scanner.nextLine(); // consume newline

        try {
            productManager.updateProduct(name, price, quantity);
            System.out.println("Product updated successfully.");
        } catch (ProductNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    private void deleteProduct() {
        System.out.print("Enter product name to delete: ");
        String name = scanner.nextLine();

        try {
            productManager.deleteProduct(name);
            System.out.println("Product deleted successfully.");
        } catch (ProductNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    private void viewProducts() {
        List<Product> products = productManager.getProducts();
        if (products.isEmpty()) {
            System.out.println("No products available.");
        } else {
        	System.out.println("------------------------------------------------------------------------");
            System.out.printf("%-15s%-10s%-10s\n", "Product Name", "Price", "Quantity");
            System.out.println("------------------------------------------------------------------------");
            for (Product product : products) {
                System.out.println(product);
            }
            System.out.println("------------------------------------------------------------------------");
        }
    }

    private void addProductToCart(Cart cart) {
        System.out.print("Enter product name: ");
        String name = scanner.nextLine();
        System.out.print("Enter quantity: ");
        int quantity = scanner.nextInt();
        scanner.nextLine(); // consume newline

        try {
            Product product = productManager.findProductByName(name);
            cart.addToCart(product, quantity);
            System.out.println("Product added to cart successfully.");
        } catch (ProductNotFoundException | InsufficientQuantityException e) {
            System.out.println(e.getMessage());
        }
    }

    private void addProductToWishlist(Wishlist wishlist) {
        System.out.print("Enter product name: ");
        String name = scanner.nextLine();

        try {
            Product product = productManager.findProductByName(name);
            wishlist.addToWishlist(product);
            System.out.println("Product added to wishlist successfully.");
        } catch (ProductNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
