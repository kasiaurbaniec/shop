package pl.sda.urbaniec.model;

import java.util.HashMap;
import java.util.Map;

public class Cart {

    private final Map<Product, Integer> products;

    public Cart() {
        this.products = new HashMap<>();
    }

    public Map<Product, Integer> get() {
        return this.products;
    }

    public void updateQuantity(final Product product, final Integer quantity) {
        final Integer oldQuantity = this.products.getOrDefault(product, 0);
        if (oldQuantity + quantity > 0) {
            this.products.put(product, oldQuantity + quantity);
        } else {
            this.products.remove(product);
        }
    }
//    public void updateQuantity(Product product, Integer quantity) {
//        if (products.containsKey(product)) {
//            Integer oldQuantity = products.get(product);
//            if (oldQuantity + quantity > 0) {
//                products.put(product, oldQuantity + quantity);
//            } else {
//                products.remove(product);
//            }
//        } else if (quantity > 0) {
//            products.put(product, quantity);
//        }
//    }


}
