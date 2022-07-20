package BTVNStreamAPI.Bai1;

public class Customer implements Comparable<Customer>{
    private String name;
    private String address;

    public Customer(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public Customer() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return this.address.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return ((Customer) obj).getAddress().equals(this.getAddress());
    }

    @Override
    public int compareTo(Customer o) {
        return this.name.compareTo(o.name);
    }
}
