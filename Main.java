// Integrantes:
//  - Kaique Silva Sousa
//  - Vinicius Nunes de Andrade
//  - Danyel Gonçalves Ferreira
//  - Pedro Santos Damasceno

import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        Controle controle = new Controle();

        //menu
        int opcao = 0;
        do {
            System.out.println("""
                            ====================================        
                            0 - Sair
                            1 - Criar evento
                            2 - Cadastrar pessoa
                            3 - Inscrever uma pessoa em um evento
                            4 - Imprimir todos os eventos
                            5 - Imprimir inscritos de um evento
                            6 - Imprimir pessoas cadastradas
                            7 - Imprimir eventos de um tipo
                            8 - Imprimir eventos com vagas
                            9 - Imprimir eventos com pessoa inscrita
                            10 - Imprimir eventos por periodo
                            =====================================""");

            opcao = sc.nextInt();

            System.out.println("===================================");
            
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
                        System.out.println("Digite a data da palestra (dia): ");
                        int dia = sc.nextInt();
                        System.out.println("Digite a data da palestra (mes): ");
                        int mes = sc.nextInt() - 1;
                        System.out.println("Digite a data da palestra (ano): ");
                        int ano = sc.nextInt() - 1900;
                        if(dia <= 0 || dia > 31 || mes < 0 || mes >= 12 || ano < 125){
                            System.out.println("Erro: data do evento inválida.");
                            break;
                        }
                        dataInicio = controle.criarData(ano, mes, dia);
                        dataFim = dataInicio;
                    } else {
                        System.out.println("Digite a data de ínicio do minicurso (dia): ");
                        int diaInicio = sc.nextInt();
                        System.out.println("Digite a data de ínicio do minicurso (mes): ");
                        int mesInicio = sc.nextInt() - 1;
                        System.out.println("Digite a data de ínicio do minicurso (ano): ");
                        int anoInicio = sc.nextInt() - 1900;

                        if(diaInicio <= 0 || diaInicio > 31 || mesInicio < 0 || mesInicio >= 12 || anoInicio < 125){
                            System.out.println("Erro: data do evento inválida.");
                            break;
                        }
                        dataInicio = controle.criarData(anoInicio, mesInicio, diaInicio);

                        System.out.println("Digite a data de término do minicurso (dia): ");
                        int diaFim = sc.nextInt();
                        System.out.println("Digite a data de término do minicurso (mes): ");
                        int mesFim = sc.nextInt() - 1;
                        System.out.println("Digite a data de término do minicurso (ano): ");
                        int anoFim = sc.nextInt() - 1900;

                        if(diaFim <= 0 || diaFim > 31 || mesFim < 0 || mesFim >= 12 || anoFim < 125){
                            System.out.println("Erro: data do evento inválida.");
                            break;
                        }

                        dataFim = controle.criarData(anoFim, mesFim, diaFim);
                    }

                    System.out.println("Digite o horario de início da evento(hora): ");
                    int horaInicio = sc.nextInt();
                    System.out.println("Digite o horario de início da evento(minuto): ");
                    int minInicio = sc.nextInt();

                    if(horaInicio < 0 || horaInicio > 24 || minInicio < 0 || minInicio >= 60){
                        System.out.println("Erro: horário do evento inválido.");
                        break;
                    }

                    String horarioInicio = horaInicio + ":" + minInicio;

                    System.out.println("Digite o horario que a evento vai acabar(hora): ");
                    int horaFim = sc.nextInt();
                    System.out.println("Digite o horario de início da evento(minuto): ");
                    int minFim = sc.nextInt();

                    if(horaInicio < 0 || horaInicio > 24 || minInicio < 0 || minInicio >= 60){
                        System.out.println("Erro: horário do evento inválido.");
                        break;
                    }

                    String horarioFim = horaFim + ":" + minFim;

                    System.out.println("Digite a carga horária do evento: ");
                    int cargaHoraria = sc.nextInt();

                    if(cargaHoraria <= 0){
                        System.out.println("Erro: carga horária inválida.");
                        break;
                    }

                    System.out.println("Digite as vagas do evento: ");
                    int vagas = sc.nextInt();

                    if(vagas < 0){
                        System.out.println("Erro: quantidade de vagas inválida.");
                        break;
                    }
                    controle.criarEvento(titulo, tipoEvento, palestrante, dataInicio, dataFim, horarioInicio, horarioFim, cargaHoraria, vagas);
                    break;
                case 2:
                    Date dataNascimento;

                    System.out.println("Digite seu nome: ");
                    String nome = sc.next();

                    System.out.println("Digite a sua data de nascimento (dia): ");
                    int dia = sc.nextInt();
                    System.out.println("Digite a sua data de nascimento (mês): ");
                    int mes = sc.nextInt() - 1;
                    System.out.println("Digite a sua data de nascimento (ano): ");
                    int ano = sc.nextInt() - 1900;
                    if(dia <= 0 || dia > 31 || mes < 0 || mes >= 12 || ano < 0){
                        System.out.println("Erro: data de nascimento inválida.");
                        return;
                    }
                    dataNascimento = controle.criarData(ano, mes, dia);

                    controle.cadastrarPessoa(nome, dataNascimento);
                    break;
                case 3:
                    System.err.println("Digite o ID do evento:");
                    int id = sc.nextInt();
                    System.err.println("Digite o nome da pessoa:");
                    nome = sc.next();
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
                case 6:
                    System.err.println(controle.imprimirPessoas());
                    break;
                case 7:
                    System.err.println("Digite o tipo do evento(palestra/minicurso): ");
                    tipo = sc.next();
                    System.err.println(controle.imprimirEventosTipo(tipo));
                    break;
                case 8:
                    System.err.println(controle.imprimirEventosComVaga());
                    break;
                case 9:
                    System.err.println("Digite o nome da pessoa inscrita:");
                    nome = sc.next();
                    System.err.println(controle.imprimirEventosInscrito(nome));
                    break;
                case 10:
                    System.out.println("Digite a sua data de inicio do periodo (dia): ");
                    int diaInicio = sc.nextInt();
                    System.out.println("Digite a sua data de inicio do periodo (mês): ");
                    int mesInicio = sc.nextInt() - 1;
                    System.out.println("Digite a sua data de inicio do periodo (ano): ");
                    int anoInicio = sc.nextInt() - 1900;
                    if(diaInicio <= 0 || diaInicio > 31 || mesInicio < 0 || mesInicio > 12 || anoInicio < 0){
                        System.out.println("Erro: data de nascimento inválida.");
                        return;
                    }
                    Date dataInicioPeriodo = controle.criarData(anoInicio, mesInicio, diaInicio);

                    System.out.println("Digite a sua data de fim do periodo (dia): ");
                    int diaFim = sc.nextInt();
                    System.out.println("Digite a sua data de fim do periodo (mês): ");
                    int mesFim = sc.nextInt() - 1;
                    System.out.println("Digite a sua data de fim do periodo (ano): ");
                    int anoFim = sc.nextInt() - 1900;
                    if(diaFim <= 0 || diaFim > 31 || mesFim < 0 || mesFim > 12 || anoFim < 0){
                        System.out.println("Erro: data de nascimento inválida.");
                        return;
                    }
                    Date dataFimPeriodo = controle.criarData(anoFim, mesFim, diaFim);

                    controle.imprimirEventosPeriodo(dataInicioPeriodo, dataFimPeriodo);
                    break;
                default:
                    System.err.println("Opção inválida.");
                    break;
            }
        } while(opcao != 0);
    }
    
}
