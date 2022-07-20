package BTVNStreamAPI.Bai3;

public class Trader {
    private int id;
    private String name;

    public Trader(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Trader() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Trader{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
