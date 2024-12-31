// Online Shopping Project for Saucedemo.com
// Developed in IntelliJ IDEA
package UI.day07;
// Annotation: TestInfo
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface TestInfo {
    String description() default "No description provided";
    String createdBy() default "Unknown";
    String[] tags() default {};
}

// Class: Cart
import java.util.ArrayList;
        import java.util.List;

public class Cart {
    private List<Product> products;

    public Cart() {
        products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(Product product) {
        products.remove(product);
    }

    public List<Product> getProducts() {
        return products;
    }

    public double calculateTotal() {
        return products.stream().mapToDouble(Product::getPrice).sum();
    }

    public int getProductCount() {
        return products.size();
    }
}

// Class: User
public class User {
    private String firstName;
    private String lastName;
    private String zipCode;

    public User(String firstName, String lastName, String zipCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.zipCode = zipCode;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getZipCode() {
        return zipCode;
    }
}

// Class: Checkout
public class Checkout {
    public boolean processCheckout(User user, Cart cart) {
        if (user.getFirstName() == null || user.getFirstName().isEmpty()) {
            System.out.println("Error: First name is required.");
            return false;
        }
        if (user.getLastName() == null || user.getLastName().isEmpty()) {
            System.out.println("Error: Last name is required.");
            return false;
        }
        if (user.getZipCode() == null || user.getZipCode().isEmpty()) {
            System.out.println("Error: Zip code is required.");
            return false;
        }
        if (cart.getProducts().isEmpty()) {
            System.out.println("Error: Cart is empty.");
            return false;
        }

        System.out.println("Checkout successful!");
        System.out.println("User: " + user.getFirstName() + " " + user.getLastName());
        System.out.println("Zip Code: " + user.getZipCode());
        System.out.println("Total: $" + cart.calculateTotal());
        return true;
    }
}

// Class: Main
public class Main {

    @TestInfo(description = "Test adding products to cart", createdBy = "Developer", tags = {"Cart", "Add"})
    public static void testAddToCart() {
        Cart cart = new Cart();
        Product product = new Product("Sauce Labs Backpack", 29.99);
        cart.addProduct(product);

        assert cart.getProductCount() == 1 : "Product count should be 1";
        assert cart.calculateTotal() == 29.99 : "Total should be 29.99";
    }

    @TestInfo(description = "Test removing products from cart", createdBy = "Developer", tags = {"Cart", "Remove"})
    public static void testRemoveFromCart() {
        Cart cart = new Cart();
        Product product = new Product("Sauce Labs Backpack", 29.99);
        cart.addProduct(product);
        cart.removeProduct(product);

        assert cart.getProductCount() == 0 : "Product count should be 0 after removal";
    }

    @TestInfo(description = "Test successful checkout", createdBy = "Developer", tags = {"Checkout", "Success"})
    public static void testCheckoutSuccess() {
        Cart cart = new Cart();
        cart.addProduct(new Product("Sauce Labs Backpack", 29.99));

        User user = new User("John", "Doe", "12345");
        Checkout checkout = new Checkout();

        assert checkout.processCheckout(user, cart) : "Checkout should be successful";
    }

    @TestInfo(description = "Test checkout failure due to missing first name", createdBy = "Developer", tags = {"Checkout", "Failure"})
    public static void testCheckoutFailureMissingFirstName() {
        Cart cart = new Cart();
        cart.addProduct(new Product("Sauce Labs Backpack", 29.99));

        User user = new User("", "Doe", "12345");
        Checkout checkout = new Checkout();

        assert !checkout.processCheckout(user, cart) : "Checkout should fail due to missing first name";
    }

    public static void main(String[] args) {
        // Run tests
        testAddToCart();
        testRemoveFromCart();
        testCheckoutSuccess();
        testCheckoutFailureMissingFirstName();

        System.out.println("All tests passed.");
    }
}
