package lapiseira;

import java.util.Scanner;

class Grafite {
    float espessura;
    float tamanho;

    public Grafite(float espessura, float tamanho) {
        this.espessura = espessura;
        this.tamanho = tamanho;
    }
}

class Lapiseira {
    Grafite grafite;
    float espessura;

    public Lapiseira(float espessura) {
        this.espessura = espessura;
    }

    void inserir(Grafite grafite) {
        if (this.grafite == null) {
            this.grafite = grafite;
            System.out.println("Ei, tem grafite aqui!");

        }
    }

    void retirar() {
        if (this.grafite != null) {
            this.grafite = null;
            System.out.println("Tirou o grafite, coloque outro para poder escrever!");
        } else {
            System.out.println("Não tem grafite, coloque outro para poder escrever!");

        }
    }

    void escrever(int qtdLetras) {
        if (this.grafite == null) {
            System.out.println("Vish, não tem grafite!");
        } else if (this.grafite.espessura != this.espessura) {
            System.out.println("Não dá pra escrever, o grafite não é compatível, coloque outro!");
            retirar();
        } else {
            if (grafite.tamanho > 0.5) {
                System.out.println("escrevendo...");
                this.grafite.tamanho -= qtdLetras/10;
            } else {
                System.out.println("Coloque outro grafite!");
                grafite = null;
            }
        }
    }

    //main é o método principal que vai rodar a minha aplicação
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Lapiseira lapiseira = new Lapiseira(5);
        while (true) {
            String msg = scanner.nextLine();
            String[] comando = msg.split(" ");
            if (comando[0].equals("acabou")) {
                break;
            } else if (comando[0].equals("iniciar")) {
                lapiseira = new Lapiseira((Float.parseFloat(comando[1])));
            } else if (comando[0].equals("inserir")) {
                lapiseira.inserir(new Grafite((Float.parseFloat(comando[1])), Float.parseFloat(comando[2])));
            } else if (comando[0].equals("retirar")) {
                lapiseira.retirar();
            } else if (comando[0].equals("escrever")) {
                int qtdLetras = Integer.parseInt(comando[1]);
                lapiseira.escrever(qtdLetras);
            } else {
                System.out.println("Comando inválido!");
            }
        }
        scanner.close();
    }
}