package IOJava.Demo;

import java.io.*;

public class IOdemo {
    public static void main(String[] args) {
        Person person = new Person(1, "henry");
        ObjectOutputStream objectOutputStream = null;
        ObjectInputStream objectInputStream = null;
        File file = new File("file.txt");

        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(person);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (objectOutputStream != null) {
                try {
                    objectOutputStream.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            DataInputStream dataInputStream = new DataInputStream(fileInputStream);
            objectInputStream = new ObjectInputStream(dataInputStream);
            Person obj = (Person) objectInputStream.readObject();
            System.out.println(obj.toString());

        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (objectInputStream != null) {
                    objectInputStream.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }

    }
}
