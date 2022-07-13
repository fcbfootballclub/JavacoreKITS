package OOP;

public interface Demointerface {
    default void display() {
        System.out.println("aiji");
    }

    public static void main(String[] args) {
        Demointerface demointerface = new Demointerface() {
            @Override
            public void display() {
                Demointerface.super.display();
            }
        };

        demointerface.display();
    }
}
