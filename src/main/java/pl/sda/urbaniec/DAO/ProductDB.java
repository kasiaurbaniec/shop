package pl.sda.urbaniec.DAO;

import pl.sda.urbaniec.model.Product;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class ProductDB {

    private static ProductDB productDBInstance;
    private final List<Product> productList;

    private ProductDB() {
        this.productList = new LinkedList<>();
        this.productList.add(new Product(0L, LocalDateTime.now(), "Cauch",
                "After work you lie on it", 2300, "Furniture", "https://pl.sofacompany.com/media/catalog/product/cache/d13c0f82f8ebfb04d96519ed59bc94be/0/7/078803177122_vera_3seater_1760x880grey_v1.jpg"));
        this.productList.add(new Product(1L, LocalDateTime.now(), "Lapm",
                "Give light on bad day", 120, "Light", "https://i5.walmartimages.com/asr/4726666a-2813-42be-835b-3db0b220bce6_1.97aa7a0d8e836f96138c6095621e44e3.jpeg"));
        this.productList.add(new Product(2L, LocalDateTime.now(), "Umbrella",
                "Proctect from rain", 80, "Other items", "https://hirmercdn.de/1/19700400/hirmer-du-y-parasol-niebieski_0_1600.jpg"));
    }

    public static synchronized ProductDB getInstance() {
        if (ProductDB.productDBInstance == null) {
            ProductDB.productDBInstance = new ProductDB();
        }
        return ProductDB.productDBInstance;
    }


    public List<Product> getProductList() {
        return this.productList;
    }

    public Optional getProductById(final long id) {
        return this.productList.stream().filter(x -> x.getId() == id)
                .findFirst();
    }

    public long createProduct(final String name, final String description, final long price, final String categories, final String href) {
        synchronized (this) {
            final long id = this.productList.size();
            final Product product = new Product(id, LocalDateTime.now(), name, description, price, categories, href);
            this.productList.add(product);
            return id;
        }
    }

}
