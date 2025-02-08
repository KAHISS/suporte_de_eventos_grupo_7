import java.util.Date;
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
                            5 - Imprimir inscritos de un evento""");

            opcao = sc.nextInt();
            
            switch (opcao){
                case 0:
                    System.out.println("Encerrando...");
                    break;
                case 1:
                    System.out.println("Digite o título da evento: ");
                    String titulo = sc.next();

                    System.out.println("Digite o tipo de evento (palestra/minicurso): ");
                    String tipo = sc.next();

                    TipoEvento tipoEvento;
                    if (tipo.equalsIgnoreCase("palestra")) {
                        tipoEvento = TipoEvento.PALESTRA;
                    } else {
                        tipoEvento = TipoEvento.MINICURSO;
                    }

                    System.out.println("Digite o nome do palestrante: ");
                    String palestrante = sc.next();

                    Date dataInicio;
                    Date dataFim = null;

                    if (tipoEvento == TipoEvento.PALESTRA) {
                        System.out.println("Digite a data de início (dia): ");
                        int dia = sc.nextInt();
                        System.out.println("Digite a sua data de início (mês): ");
                        int mes = sc.nextInt() - 1;
                        System.out.println("Digite a sua data de início (ano): ");
                        int ano = sc.nextInt() - 1900;
                        dataInicio = controle.criarData(ano, mes, dia);
                        dataFim = dataInicio;
                    } else {
                        System.out.println("Digite a data de início (dia): ");
                        int diaInicio = sc.nextInt();
                        System.out.println("Digite a data de início (mês): ");
                        int mesInicio = sc.nextInt() - 1;
                        System.out.println("Digite a data de início (ano): ");
                        int anoInicio = sc.nextInt() - 1900;
                        dataInicio = controle.criarData(anoInicio, mesInicio, diaInicio);

                        System.out.println("Digite a data de termino (dia): ");
                        int diaFim = sc.nextInt();
                        System.out.println("Digite a data de termino (mês): ");
                        int mesFim = sc.nextInt() - 1;
                        System.out.println("Digite a data de termino (ano): ");
                        int anoFim = sc.nextInt() - 1900;
                        dataFim = controle.criarData(anoFim, mesFim, diaFim);
                    }

                    System.out.println("Digite o horario de início da evento(hora): ");
                    int horaInicio = sc.nextInt();
                    System.out.println("Digite o horario de início da evento(minuto): ");
                    int minInicio = sc.nextInt();
                    String horarioInicio = horaInicio + ":" + minInicio;

                    System.out.println("Digite o horario que a evento vai acabar(hora): ");
                    int horaFim = sc.nextInt();
                    System.out.println("Digite o horario que a evento vai acabar(minuto): ");
                    int minFim = sc.nextInt();
                    String horarioFim = horaFim + ":" + minFim;

                    System.out.println("Digite a carga horária do evento: ");
                    int cargaHoraria = sc.nextInt();

                    System.out.println("Digite as vagas do evento: ");
                    int vagas = sc.nextInt();

                    controle.criarEvento(titulo, tipoEvento, palestrante, dataInicio, dataFim, horarioInicio, horarioFim, cargaHoraria, vagas);
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
