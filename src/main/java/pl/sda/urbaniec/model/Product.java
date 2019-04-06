package pl.sda.urbaniec.model;

import java.time.LocalDateTime;

public class Product {
    private long id;

    private LocalDateTime date;
    private String name;
    private String description;
    private String categories;
    private long price;
    private String href;

    public Product(final Long id, final LocalDateTime date, final String name, final String description, final long price, final String categories, final String href) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.description = description;
        this.categories = categories;
        this.price = price;
        this.href = href;

    }

    public long getId() {
        return this.id;
    }

    public void setId(final long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public LocalDateTime getDate() {
        return this.date;
    }

    public void setDate(final LocalDateTime date) {
        this.date = date;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public String getCategories() {
        return this.categories;
    }

    public void setCategories(final String categories) {
        this.categories = categories;
    }

    public long getPrice() {
        return this.price;
    }

    public void setPrice(final long price) {
        this.price = price;
    }

    public String getHref() {
        return this.href;
    }

    public void setHref(final String href) {
        this.href = href;
    }
}
