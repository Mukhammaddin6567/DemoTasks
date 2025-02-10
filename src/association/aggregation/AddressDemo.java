package association.aggregation;

class Address {
    private String city;
    private String state;
    private String country;

    Address(String city, String state, String country) {
        this.city = city;
        this.state = state;
        this.country = country;
    }

    String getCity() {
        return city;
    }

    void setCity(String city) {
        this.city = city;
    }

    String getState() {
        return state;
    }

    void setState(String state) {
        this.state = state;
    }

    String getCountry() {
        return country;
    }

    void setCountry(String country) {
        this.country = country;
    }
}

class Employer {
    private int id;
    private String name;
    private Address address;

    Employer(int id, String name, Address address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    int getId() {
        return id;
    }

    void setId(int id) {
        this.id = id;
    }

    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    Address getAddress() {
        return address;
    }

    void setAddress(Address address) {
        this.address = address;
    }

    void display() {
        System.out.println(id + " " + name);
        if (address != null)
            System.out.println(address.getCity() + " " + address.getState() + " " + address.getCountry());
        else System.out.println("Without address");
    }
}


class AddressDemo {
    public static void main(String[] args) {
        Address address1 = new Address("gzb", "UP", "india");
        Address address2 = new Address("gno", "UP", "india");

        Employer e = new Employer(111, "varun", address1);
        Employer e2 = new Employer(112, "arun", address2);

        e.display();
        e2.display();
    }
}
