package pulapula;

import java.util.LinkedList;
import java.util.Scanner;

class Kid {
    // variáveis privadas para que as outras classes não tenham acesso a ela
    private String nome;
    private int idade;

    // constructor da classe criança
    public Kid(String nome, Integer idade) {
        this.nome = nome;
        this.idade = idade;
    }

    // metodos get para que mesmo sendo privada, ainda seja acessível
    // os dads dessa classe através deles
    public String getNome() {
        return nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public String getNomeAndIdade() {
        return nome + ", " + idade;
    }
}

class Trampolin {
    // estrutura de dado LinkedList porque ser mais prático pegar a primeira e ultima criança
    // poderia ser com array(array[posição]) mas me falaram que assim é mais prática
    private LinkedList<Kid> criancasEsperando;
    private LinkedList<Kid> criancasNoPulaPula;

    // construtor
    public Trampolin() {
        criancasEsperando = new LinkedList<>();
        criancasNoPulaPula = new LinkedList<>();
    }

    public void chegouUmPivete(Kid kid) {
        criancasEsperando.addFirst(kid);
    }

    public void entrouACrianca() {
        criancasNoPulaPula.addFirst(criancasEsperando.getLast());
        criancasEsperando.removeLast();
    }

    public void saiuACrianca() {
        criancasEsperando.addFirst(criancasNoPulaPula.getLast());
        criancasNoPulaPula.removeLast();
    }

    public void vaoPraCasaPivetada() {
        criancasNoPulaPula.clear();
        criancasEsperando.clear();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Trampolin trampolin = new Trampolin();
        while (true) {
            String mensagem = scanner.nextLine();
            String[] comando = mensagem.split(" ");
            if (comando[0].equals("encerrar")) {
                break;
            } else if (comando[0].equals("chegou")) {
                trampolin.chegouUmPivete(
                        new Kid(comando[1], Integer.parseInt(comando[2])));
            } else if (comando[0].equals("podeSubir")) {
                trampolin.entrouACrianca();
            } else if (comando[0].equals("saiPivete")) {
                trampolin.saiuACrianca();
            } else if (comando[0].equals("verCriancas")) {
                for (Kid crianca : trampolin.criancasNoPulaPula) {
                    System.out.println(crianca.getNomeAndIdade().toString());
                }
            } else if (comando[0].equals("acabou")) {
                trampolin.vaoPraCasaPivetada();
                System.out.println(trampolin.criancasNoPulaPula.toString());
            } else {
                System.out.println("comando inválido");
            }
        }
        scanner.close();
    }
}