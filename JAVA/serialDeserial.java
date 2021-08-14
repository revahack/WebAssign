//make a program to show serialization and deserialization

import java.io.*;

class Person implements Serializable {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
};

public class serialDeserial {
    public static void main(String[] args) {
        Person p = new Person("John", 30);
        System.out.println(p);
        //serialize
        try {
            FileOutputStream fos = new FileOutputStream("serial.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(p);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //deserialize
        try {
            FileInputStream fis = new FileInputStream("serial.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Person p2 = (Person) ois.readObject();
            System.out.println(p2.name);
            ois.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}