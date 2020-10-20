package tomagochi;

import java.util.Scanner;

class Tomagochi {
    private int energiaMax, fomeMax, limpezaMax, energia, fome, limpeza, estrelas, idade;
    private boolean vivo;

    public Tomagochi(int energia, int fome, int limpeza) {
        this.energia = energia;
        this.fome = fome;
        this.limpeza = limpeza;
        this.energiaMax = energia;
        this.fomeMax = fome;
        this.limpezaMax = limpeza;
        estrelas = 0;
        idade = 0;
        vivo = true;
    }

    int getEnergia() {
        return energia;
    }

    int getFome() {
        return fome;
    }

    int getLimpeza() {
        return limpeza;
    }

    int getEnergiaMax() {
        return energiaMax;
    }

    int getFomeMax() {
        return fomeMax;
    }

    int getLimpezaMax() {
        return limpezaMax;
    }

    int getEstrelas() {
        return estrelas;
    }

    int getIdade() {
        return idade;
    }

    boolean getVivo() {
        return vivo;
    }

    void setEnergia(int valor) {
        if (valor <= 0) {
            energia = 0;
            vivo = false;
        } else if (valor > energiaMax) {
            energia = energiaMax;
        } else {
            energia = valor;
        }
    }

    void setFome(int valor) {
        if (valor <= 0) {
            fome = 0;
            vivo = false;
        } else if (valor > fomeMax) {
            fome = fomeMax;
        } else {
            fome = valor;
        }
    }

    void setLimpeza(int valor) {
        if (valor <= 0) {
            limpeza = 0;
            vivo = false;
        } else if (valor > limpezaMax) {
            limpeza = limpezaMax;
        } else {
            limpeza = valor;
        }
    }

    void brincar() {
        setEnergia(getEnergia() - 2);
        setFome(getFome() - 1);
        setLimpeza(getLimpeza() - 3);
        this.estrelas += 1;
        this.idade += 1;
    }

    void banhar() {
        setEnergia(getEnergia() - 3);
        setFome(getFome() - 1);
        setLimpeza(getLimpezaMax());
        this.idade += 2;
    }

    void comer() {
        setEnergia(getEnergia() - 1);
        setFome(getFome() + 4);
        setLimpeza(getLimpeza() - 2);
        this.idade += 1;
    }

    void dormir() {
        if (vivo) {
            if (this.energiaMax - getEnergia() < 5) {
                System.out.println("buchim chei mah, da pra dormir não");
            }

            this.idade += this.energiaMax - getEnergia();
            setEnergia(energiaMax);
            setFome(getFome() - 1);
        }
    }

    public String toString() {
        return " Energia: " + this.energia + "/" + this.energiaMax + "  Fome: " + this.fome + "/" + this.fomeMax + "  Limpeza: " + this.limpeza +
                "/" + this.limpezaMax
                + "  Idade: " + this.idade + "  Estrelas: " + this.estrelas;
    }

    public static void main(String[] args) {
        Tomagochi tomagochi = null;
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String msg = scanner.nextLine();
            String[] comando = msg.split(" ");

            if (comando[0].equals("fim")) {
                break;
            } else if (comando[0].equals("iniciar")) {
                int energia = Integer.parseInt(comando[1]);
                int fome = Integer.parseInt(comando[2]);
                int limpeza = Integer.parseInt(comando[3]);
                tomagochi = new Tomagochi(energia, fome, limpeza);
            } else if (comando[0].equals("show")) {
                System.out.println(tomagochi.toString());
            } else if (comando[0].equals("brincar")) {
                tomagochi.brincar();
            } else if (comando[0].equals("comer")) {
                tomagochi.comer();
            } else if (comando[0].equals("dormir")) {
                tomagochi.dormir();
            } else if (comando[0].equals("banhar")) {
                tomagochi.banhar();
            } else {
                System.out.println("Comando inválido!");
            }
        }
    }
}