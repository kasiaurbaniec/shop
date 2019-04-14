package pl.sda.urbaniec.model;

public class Address {
    private String street;
    private String city;
    private String code;
    private String streetNumber;

    public Address(final String street, final String city, final String code, final String streetNumber) {
        this.street = street;
        this.city = city;
        this.code = code;
        this.streetNumber = streetNumber;
    }

    public String getStreet() {
        return this.street;
    }

    public void setStreet(final String street) {
        this.street = street;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(final String city) {
        this.city = city;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(final String code) {
        this.code = code;
    }

    public String getStreetNumber() {
        return this.streetNumber;
    }

    public void setStreetNumber(final String streetNumber) {
        this.streetNumber = streetNumber;
    }
}
