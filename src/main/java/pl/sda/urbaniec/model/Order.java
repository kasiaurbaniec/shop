package pl.sda.urbaniec.model;

import java.util.Map;

public class Order {
    private final Cart products;
    Long orderValue;
    private Address address;
    private String name;
    private String surname;

    public Order(final String name, final String surname, final Address address, final Cart products) {
        this.products = products;
        this.orderValue = this.orderValue;
        this.address = address;
        this.name = name;
        this.surname = surname;
    }

    public Cart getProducts() {
        return this.products;
    }

    public Long getOrderValue() {
        Long orderValue = 0L;
        if (!this.products.get().isEmpty()) {
            for (final Map.Entry<Product, Integer> entry : this.products.get().entrySet()) {
                orderValue += entry.getValue() * entry.getKey().getPrice();
            }
        }
        return orderValue;
    }


    public Address getAddress() {
        return this.address;
    }

    public void setAddress(final Address address) {
        this.address = address;
    }

    public String getName() {
        return this.name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getSurname() {
        return this.surname;
    }

    public void setSurname(final String surname) {
        this.surname = surname;
    }
}
