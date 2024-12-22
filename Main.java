package main;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        //Controle evento = new Controle();
        
        //menu
        int opcao = 0;
        do {
            System.out.println(
                "0 - Sair\n1 - Criar evento\n2 - Imprimir todos os eventos\n3 - Verificar quantidade de vagas"
            );
            opcao = sc.nextInt();
            switch (opcao){
                    case 0 -> System.out.println("Encerrado");
                        
                    case 1 -> System.out.println("Criar evento");
                //evento
                        
                    case 2 -> System.out.println("Exibir todos os eventos");
                //evento
                        
                    case 3 -> System.out.println("verificar vagas");
                //evento
                    
                    default -> System.out.println("Digite um número válido.");
        
            }
        } while(opcao != 0);
        
    }
    
}
