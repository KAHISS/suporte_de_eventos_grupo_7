import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Controle controle = new Controle();

        //menu
        int opcao = 0;
        do {
            System.out.println("""
                            0 - Sair
                            1 - Criar evento
                            2 - Cadastrar pessoa
                            3 - Inscrever uma pessoa em um evento
                            4 - Imprimir todos os eventos
                            5 - Imprimir inscritos de um evento""");

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
                case 4: 
                    System.err.println(controle.imprimirEventos());
                    break;
                case 5:
                    System.out.println("Digite o ID do evento"); 
                    id = sc.nextInt();
                    System.err.println(controle.imprimirInscritosEvento(id));
                    break;
                default:
                    System.err.println("Opção");
                    break;
            }
        } while(opcao != 0);
    }
    
}
