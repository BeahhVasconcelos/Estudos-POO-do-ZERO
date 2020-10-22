package junkfood;

import java.util.ArrayList;
import java.util.Scanner;

class Espiral {
    String nome;
    int qtd;
    float preço;

    public Espiral(String nome, int qtd, float preço) {
        this.nome = nome;
        this.qtd = qtd;
        this.preço = preço;
    }

    public String toString() {
        return nome + " : " + qtd + "U : " + preço + "RS";
    }
}

class Maquina {
    ArrayList<Espiral> espirais;
    float saldoCliente;
    float lucro;
    int maxProdutos;

    public Maquina(int maxProdutos, int qtdEspirrais) {
        this.espirais = new ArrayList<>();
        this.maxProdutos = maxProdutos;
        for (int i = 0; i < qtdEspirrais; i++) {
            this.espirais.add(new Espiral("", 0, 0f));
        }
    }

    int capacidadeMaquina() {
        return espirais.size();
    }

    boolean inserirDinheiro(float valor) {
        this.saldoCliente += valor;
        return true;
    }

    String pedirTroco() {
        return "Você recebeu" + saldoCliente + " RS";
    }

    boolean alterarEspiral(int indice, String nome, int qtd, float preço) {
        if (indice < 0) {
            System.out.println("Posição inválida da espiral");
            return false;
        }
        if (preço <= 0) {
            System.out.println("Preço inválido, tente um valor acima de 0");
            return false;
        }
        if (qtd > capacidadeMaquina()) {
            System.out.println("Houve um erro, a máquina suporta apenas "
                    + maxProdutos
                    + " como limite de produtos.");
            return false;
        }
        Espiral espiral = new Espiral(nome, qtd, preço);
        espirais.set(indice, espiral);
        return true;
    }

    boolean limparEspiral(int indice) {
        if (espirais.get(indice) == null) {
            System.out.println("Não há nada nessa Espiral");
            return false;
        }

        espirais.remove(indice);
        return true;
    }

    float getSaldo() {
        return saldoCliente;
    }

    boolean vender(int indice) {
        Espiral itemVendido = espirais.get(indice);
        lucro += itemVendido.preço;
        System.out.println("Você comprou o " + itemVendido.nome +
                ", aproveite sua refeição!");
        limparEspiral(indice);
        return true;
    }

    public String toString() {
        String saldoMáquina = "saldo: " + getSaldo() + "\n";
        for (int i = 0; i < espirais.size(); i++) {
            if (espirais.get(i) == null) {
                saldoMáquina += i + "[ empty : 0 U : 0.00 RS]\n";
            } else {
                saldoMáquina += i + "[ " + espirais.get(i).nome + " : "
                        + espirais.get(i).qtd + " U : "
                        + espirais.get(i).preço + " " + "RS]\n";
            }
        }
        return saldoMáquina;
    }
}


class JunkFood {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Maquina maquina = null;

        while (true) {
            String scan = scanner.nextLine();
            String[] input = scan.split(" ");

            if (input[0].equals("end")) {
                break;
            } else if (input[0].equals("iniciar")) {
                maquina = new Maquina(Integer.parseInt(input[1]),
                        Integer.parseInt(input[2]));
            } else if (input[0].equals("opções")) {
                System.out.println(maquina);
            } else if (input[0].equals("comprar")) {
                assert maquina != null;
                maquina.vender(Integer.parseInt(input[1]));
                maquina.inserirDinheiro(Float.parseFloat(input[2]));
                maquina.getSaldo();
                maquina.pedirTroco();

            } else if (input[0].equals("resetar")) {
                maquina = new Maquina(0,0);
            } else if (input[0].equals("inserir")) {
                maquina.alterarEspiral(Integer.parseInt(input[1]), input[2],
                        Integer.parseInt(input[3]), Float.parseFloat(input[4]));
            } else {
                System.out.println("Comando inválido");
            }
        }
    }
}