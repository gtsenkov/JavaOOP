package DesignPatternsLab.BuilderPattern.Facade;

public class AddressBuilder {
    private Address address;

    public AddressBuilder() {
        this.address = new Address();
    }

    public AddressBuilder withEmail(String email) {
        this.address.setEmial(email);
        return this;
    }

    public AddressBuilder withName(String name) {
        this.address.setName(name);
        return this;
    }

    public Address build() {
        return this.address;
    }
}
