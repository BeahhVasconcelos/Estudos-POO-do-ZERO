package vetores;

import java.util.ArrayList;
import java.util.Scanner;

public class mestreDosVetores {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<Integer>();

        while (true) {
            String comando = scanner.nextLine();
            String[] msg = comando.split(" ");
            if (comando.equals("encerrar")) {
                break;
            } else if (msg[0].equals("mostrar")) {
                System.out.println("[ ");
                for (Integer value : arr)
                    System.out.print(value + " ");
                System.out.println(" ]");
            } else if (msg[0].equals("adicionar")) {
                for (int i = 0; i < msg.length - 1; i++)
                    arr.add(Integer.parseInt(msg[1]));
            } else if (msg[0].equals("buscar")) {
                System.out.println(arr.get(Integer.parseInt(msg[1])));
            } else if (msg[0].equals("alterar")) {
                arr.set(Integer.parseInt(msg[1]), Integer.parseInt(msg[2]));
            } else if (msg[0].equals("inserirPosição")) {
                int arrSize = arr.size();
                int value = Integer.parseInt(msg[1]);
                if (value >= arrSize) {
                    System.out.println("Valor inválido, tente um igual ou menor que esse valor: " + arrSize);
                } else {
                    arr.add(Integer.parseInt(msg[1]), Integer.parseInt(msg[2]));
                }
            } else if (msg[0].equals("rmi")) {
                int input = Integer.parseInt(msg[1]);
                if (input < 0 || input >= arr.size()) {
                    System.out.println("fail");
                    break;
                } else {
                    arr.remove(Integer.parseInt(msg[1]));
                }
            } else if (msg[0].equals("rma")) {
                for (int i = 0; i < arr.size(); i++) {
                    if (Integer.parseInt(msg[1]) == arr.get(i)) {
                        arr.remove(i);
                    }
                }
            } else {
                System.out.print("comando inválido");
            }
        }
    }
}