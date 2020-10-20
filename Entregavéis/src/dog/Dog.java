package dog;

import java.util.Scanner;

public class Dog {
    String latir;
    String sentar;
    String comer;
    String dormir;

    void latir() {
        System.out.println("au au");
    }

    void sentar() {
        System.out.println("Sit, junto, sentado calado!");
    }

    void comer() {
        System.out.println("Buchin chei!");
    }

    void  dormir() {
        System.out.println("Doguinho capotou Z z Z z!");
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Dog dog = new Dog();
            while (true) {
                String line = scanner.nextLine();
                String ui[] = line.split(" ");
                if (ui[0].contentEquals("latir")) {
                    dog.latir();
                } else if (ui[0].contentEquals("sentar")) {
                    dog.sentar();
                } else if (ui[0].contentEquals("comer")) {
                    dog.comer();
                } else if (ui[0].contentEquals("dormir")) {
                    dog.dormir();
                } else {
                    System.out.println("O doguinho bugou");
                }
            }
        }
    }
}
	