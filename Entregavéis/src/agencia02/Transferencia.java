package agencia02;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

class Transferencia {
    int id;
    double value;

    public Transferencia(int id, double value) {
        this.id = id;
        this.value = value;
    }
}

class Conta {
    int id;
    float saldo;
    String idCliente;
    ArrayList<Transferencia> transações;

    public Conta(int id, String idClient) {
        this.id = id;
        this.idCliente = idClient;
    }

    void novaTransação(int id, double value) {
        saldo += value;
        Transferencia transferencia = new Transferencia(id, value);
        transações.add(transferencia);
    }

    void sacar(int id, float value) {
        if (saldo < value) {
            System.out.println("Você não tem saldo suficiente, seu saldo é: " + saldo);
        }
        saldo -= value;
        System.out.println("Você sacou :" + value + "\nSeu saldo é de: " + saldo);
    }

    void depositar(int id, float value) {
        if (value <= 0) {
            System.out.println("Valor inválido");
        }
        saldo += value;
        System.out.println("Você depositou :" + value + "\nSeu saldo é de: " + saldo);
    }

    void transferir(Conta other, float value) {

    }

    public double atualizacaoMensal() {
        return saldo;
    }
}

class Cliente {
    String id;
    ArrayList<Conta> contas;

    public Cliente(String id) {
        this.id = id;
        contas = new ArrayList<Conta>();
    }

    public String getId() {
        return id;
    }

    void adicionarConta(Conta conta) {
        contas.add(conta);
    }
}

class ContaPoupança extends Conta {
    double rendimento = 0.01;

    public ContaPoupança(int id, String idCliente) {
        super(id, idCliente);
    }

    public double atualizacaoMensal() {
        return saldo *= rendimento;
    }

    public String toString() {
        return super.toString() + ":CC";
    }
}

class ContaCorrente extends Conta {
    float tarifaMensal = 20;

    public ContaCorrente(int id, String idCliente) {
        super(id, idCliente);
    }

    public double atualizacaoMensal() {
        return saldo -= tarifaMensal;
    }

    public String toString() {
        return super.toString() + ":CP";
    }
}

class Agencia {
    Map<String, Cliente> clientes = new TreeMap<String, Cliente>();
    Map<Integer, Conta> contas = new TreeMap<Integer, Conta>();
    int totalIds = 0;

    void Cliente(String id) {
        Conta contaPoupança = new ContaPoupança(totalIds++, id);
        Conta contaCorrente = new ContaCorrente(totalIds++, id);
        Cliente cliente = new Cliente(id);
        cliente.adicionarConta(contaCorrente);
        cliente.adicionarConta(contaPoupança);
        clientes.put(id, cliente);
        contas.put(contaPoupança.id, contaPoupança);
        contas.put(contaCorrente.id, contaCorrente);
    }

    void adicionarCliente(String id) {
        if (clientes.get(id) == null) {
            Cliente(id);
        }
    }

    public String toString() {
        String response = "";
        for(int i = 0 ; i < contas.size(); i++){
            response += contas.get(i) + "\n";
        }
        return response;
    }
}

class Agencia02 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Agencia agencia = new Agencia();
        Conta conta = new Conta(0, null);
        ContaPoupança poupança = new ContaPoupança(0, null);
        ContaCorrente corrente = new ContaCorrente(0, null);

        while (true) {
            String comando = scan.nextLine();
            String input[] = comando.split(" ");

            if (input[0].equals("end")) {
                break;
            } else if (input[0].equals("show")) {
                System.out.println(agencia.toString());
            } else if (input[0].equals("adicionarCliente")) {
                agencia.adicionarCliente(input[1]);
            }
            else if(input[0].equals("depositar")){
                conta.depositar(Integer.parseInt(input[1]), (float) Double.parseDouble(input[2]));
            }
            else if(input[0].equals("sacar")){
                conta.sacar(Integer.parseInt(input[1]), (float) Double.parseDouble(input[2]));
            }
            else if(input[0].equals("verConta")){
                poupança.atualizacaoMensal();
                corrente.atualizacaoMensal();
                System.out.println(agencia);
            }
            else {
                System.out.println("comando invalido");
            }
        }
    }
}