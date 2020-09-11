package Carro;

import java.util.Scanner;

public class Carro {

    int nPessoas = 0;
    int maxPessoas = 5;

    void embarcar (int quantidade) {
    //verificar SE é menor que zero
        if (quantidade < 0) {
            System.out.println("Quantidade inválida, somente acima de zero!");
            return;
        }

        if (quantidade > this.maxPessoas) {
            System.out.println("Foi mal, o carro tá cheio!");
            return;
        }

        this.nPessoas = this.nPessoas + quantidade;
        System.out.println("Entra ai meu povo!");

        //verificar SE é maior que a quantidade é maior que o limite

        // embarcar

    }

    void desembarcar (int quantidade){
        //verificar SE é menor que zero
        if (quantidade < 0){
            System.out.println("Quantidade inválida, somente igual ou maior que zero!");
            return;
        }

        //Deus me ajuda a entender programação pfvr!

        if (quantidade > this.nPessoas){
            System.out.println(" Só tem " + this.nPessoas +  "pessoas no carro");
            return;
        }

        this.nPessoas -= quantidade;
        System.out.println("Tchau povo, fica em casa!");

    }

    void mostrarAGalera() {
        System.out.println("Esta é a quantidade de pessoas no carro!: " + this.nPessoas);

    }

    // public
    // void () {
    // }
    //String bibia

    // nomes[3]
    // String [] nomes = [bibia, bibia, bia bi]
    public static void main (String[] args){
        Scanner scanner = new Scanner(System.in);
        Carro carro = new Carro();

        while (true) {
            String line = scanner.nextLine();
            String ui [] = line.split(" ");

            // [
            if (ui[0].equals("end")) {
                break;
            } else if (ui[0].equals("mostrarAGalera")) {
                carro.mostrarAGalera();
            }  else if (ui [0] .equals("embarcar")) {
                int novaPessoa = 1;
                carro.embarcar(novaPessoa);
            } else if (ui[0].equals(" desembarcar ")) {
                int pessoaQueSaiu = 1;
                carro.desembarcar(pessoaQueSaiu);
            } else {
                System.out.println("Comandoo inválido");
            }
        }
    }
}
