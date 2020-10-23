package agenda;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

class Fone {
    String label;
    String number;

    public Fone(String label, String number) {
        this.label = label;
        this.number = number;
    }

    public String toString() {
        return "[" + this.label + ":" + this.number + "]";
    }
}

class Contato {
    String name;
    ArrayList<Fone> fones;
    boolean favorited;
    int idContato;

    public Contato(String name) {
        this.name = name;
        fones = new ArrayList<>();
    }

    public String toString() {
        String response = "- " + this.name;
        int i = 0;
        for (Fone fone : fones) {
            if (this.favorited == true) {
                response += "@" + this.name + "[" + i + ":" + fone + "]";
                i++;
            } else {
                response += "-" + this.name + "[" + i + ":" + fone + "]";
                i++;
            }
        }
        return response;
    }
}

class Agenda {
    Map<String, Contato> contatos;
    Map<String, Contato> favorited;
    Contato contato;

    public Agenda() {
        contatos = new TreeMap<String, Contato>();
        favorited = new TreeMap<String, Contato>();
    }

    public void getContato(String name) {
        if (this.contatos.equals(name)) {
            System.out.println("Não existe contato com esse name");
        }
        System.out.println(this.contatos.get(name));
    }

    public void addContato(Contato contato) {
        if (this.contatos.equals(contato.name)) {
            System.out.println("Nome já existe");
        } else {
            this.contatos.put(contato.name, contato);
        }
    }

    public void rmContato(String name) {
        if (this.contatos.equals(name)) {
            System.out.println("Não há contato com esse nome");
        } else {
            this.contatos.remove(name);
        }
    }

    public void favoritar(String name) {
        if (contato.favorited == true) {
            System.out.println("Este contato já foi favoritado antes.");
        } else {
            this.favorited.put(name, contato);
            contato.favorited = true;
        }
    }

    public void desfavoritar(String name) {
        if (contato.favorited == true) {
            System.out.println("Esse contato já está favoritado");
        } else {
            this.favorited.remove(name, contato);
            contato.favorited = false;
        }
    }

    public Map<String, Contato> getContatos() {
        return this.contatos;
    }

    public Map<String, Contato> getFavoritos() {
        return favorited;
    }
}

class Controller {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Agenda agenda = new Agenda();

        while (true) {
            String comando = scanner.nextLine();
            String input[] = comando.split(" ");

            if (input[0].equals("end")) {
                break;
            } else if (input[0].equals("show")) {
                agenda.getContato(input[1]);
            } else if (input[0].equals("add")) {
                agenda.addContato(new Contato(input[1]));
            } else if (input[0].equals("rmv")) {
                agenda.rmContato(input[1]);
            } else if (input[0].equals("favoritar")) {
                agenda.favoritar(input[1]);
            } else if (input[0].equals("desfavoritar")) {
                agenda.desfavoritar(input[1]);
            } else if (input[0].equals("showF")) {
                System.out.println(agenda.favorited);
            } else if (input[0].equals("showT")) {
                System.out.println(agenda);
            } else {
                System.out.println("Comando inválido");
            }
        }
    }
}