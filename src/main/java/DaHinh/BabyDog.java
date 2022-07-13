package DaHinh;

public class BabyDog extends Dog{
    @Override
    public void eat() {
        System.out.println("Drink milk!");
    }

    public static void main(String[] args) {
        Animal animal = new Animal();
        Animal dog = new Dog();
        Animal babyDog = new BabyDog();

        animal.eat();
        dog.eat();
        babyDog.eat();
    }
}
