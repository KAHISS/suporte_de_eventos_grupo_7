import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Controle controle = new Controle();

        //menu
        int opcao = 0;
        do {
            System.out.println(
                "0 - Sair\n1 - Criar evento\n2 - Cadastrar pessoa\n3 - Inscrever uma pessoa em um evento"
            );
            opcao = sc.nextInt();
            switch (opcao){
                case 0:
                    System.err.println("Encerrando...");
                    break;
                case 1:
                    controle.criarEvento();
                    break;
                case 2:
                    controle.cadastrarPessoa();
                    break;
                case 3:
                    System.err.println("Digite o ID do evento:");
                    int id = sc.nextInt();
                    System.err.println("Digite o nome da pessoa:");
                    String nome = sc.next();
                    controle.fazerInscricaoEvento(id, nome);
                    break;
                default:
                    System.err.println("Opção");
                    break;
            }
        } while(opcao != 0);
    }
    
}
