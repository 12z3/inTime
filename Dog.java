package hackerRank;

import training.Methods;
import java.util.Arrays;
import java.util.Scanner;

/*
https://www.youtube.com/watch?v=ETLHbHenW44
*/

public class Dog extends Methods {
    private int age;
    private String name;
    private String[] owners;
    private String owner;
                                                                   // this() - Трябва да е на 1-я ред.
                                              // В противен случай компилатора се бърка с параметрите на конструкторите.
    public Dog(String[] owners){                                   // this() - Трябва да е на 1-я ред.
        this(26,"Kiko");                                // Взима конструктора с тези параметри
        this.owners = owners;
    }

    public Dog() {
        this(23, "Bob");                     // Взима конструктора с тези параметри
    }

    public Dog(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public Dog(String owner) {
        this(24, "Kiro");
        this.owner = owner;
    }



    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return this.age;
    }

    public void setOwners(){
        System.out.println();
        Scanner scan = new Scanner(System.in);
        for (int i = 0; i < owners.length; i++) {
            owners[i] = scan.nextLine();
        }
    }

    public String getOwners(){
        return Arrays.toString(owners);
    }



    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        timeAndData();

        Dog Dog = new Dog();
        Dog Dog1 = new Dog("Pesho");
        String[] ownersName = {"Kiko", "Di40", "Onia"};
        Dog Dog2 = new Dog(ownersName);

        System.out.println(Dog.name);
        System.out.printf("Name = %s, Age = %d, Owner = %s; %n",
                Dog1.getName(), Dog1.getAge(), Dog1.owner);
       // Dog2.setOwners();
        System.out.println(Dog2.getOwners());



    }
}
