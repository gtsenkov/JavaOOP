package DesignPatternsLab.BuilderPattern.Facade;

public class Address {
    private String name;
    private String emial;
    private String phoneNumber;
    private String country;
    private String state;
    private String city;
    private String addressLine1;
    private String addressLine2;

    public Address() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmial(String emial) {
        this.emial = emial;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }
}
