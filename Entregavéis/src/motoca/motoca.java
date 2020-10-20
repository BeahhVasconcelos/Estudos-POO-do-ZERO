package motoca;

import java.util.Scanner;

class Pessoa {
    String nome;
    int idade;

    public Pessoa(String nome, int idade){
        this.nome = nome;
        this.idade = idade;
    }
}

public class motoca {
    Pessoa pessoa;

    public motoca(){
    }

    void embarcar(Pessoa pessoa) {
        if(this.pessoa == null)
            this.pessoa = pessoa;
        else
            System.out.println("Ja tem gente na motoca");
    }

    void desembarcar() {
        if(this.pessoa != null) {
            this.pessoa = null;
        System.out.println("Saiu da motoca!");
        } else
            System.out.println("Nao tem ninguem na moto");
    }

    void buzinar() {
        if(this.pessoa != null)
            System.out.println("BI BI, sai do meio!");
    }

    void dirigir(){
        if(this.pessoa == null)
            System.out.println("Nao tem ninguem na moto");
        else if(this.pessoa.idade < 2)
            System.out.println("Muito pequeno pra andar de moto");
        else if(this.pessoa.idade > 10)
            System.out.println("Muito grande pra andar de moto");
        else
            System.out.println(this.pessoa.nome + ": Run Run Run...");
    }


//    public static void main(String[] args) {
//        Pessoa beah = new Pessoa("Beah", 10);
//
//        motoca moto = new motoca();
//        moto.embarcar(beah);
//        moto.dirigir();
//        moto.desembarcar();
//
//        motoca moto2 = new motoca();
//        moto2.embarcar(beah);
//        moto2.dirigir();
//        moto2.desembarcar();
//
//        System.out.println(beah.nome);
//    }

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		motoca motoca  = new motoca();
		while(true) {
			String line = scanner.nextLine();
			String ui[] = line.split(" ");
			if(ui[0].equals("end")) {
				break;
			}else if(ui[0].equals("embarcar")) {
				int idade = Integer.parseInt(ui[2]);
				Pessoa pessoa = new Pessoa(ui[1], idade);
				motoca.embarcar(pessoa);
			}else if(ui[0].equals("desembarcar")) {
				motoca.desembarcar();
			}else if(ui[0].equals("dirigir")) {
				motoca.dirigir();
			} else if (ui[0].equals("buzinar")) {
                motoca.buzinar();
            }
			else {
				System.out.println("Comando invalido");
			}
		}
		scanner.close();
	}
}




