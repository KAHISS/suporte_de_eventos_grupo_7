import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;
import java.util.Date;

public class Controle {
    private List<Evento> eventos = new ArrayList<>();
    private List<Pessoa> pessoas = new ArrayList<>();

    public void criarEvento() {
        Scanner scn = new Scanner(System.in);
        System.out.println("Digite o título da evento: ");
        String titulo = scn.nextLine();

        System.out.println("Digite o tipo de evento: ");
        String tipo = scn.nextLine();
        TipoEvento tipoEvento;
        if (tipo.equalsIgnoreCase("palestra")) {
            tipoEvento = TipoEvento.PALESTRA;
        } else {
            tipoEvento = TipoEvento.MINICURSO;
        }

        System.out.println("Digite o nome do palestrante: ");
        String palestrante = scn.nextLine();

        Date dataInicio;
        Date dataFim = null;
        if (tipoEvento == TipoEvento.PALESTRA) {
            System.out.println("Digite a data da palestra (Ano, mês, dia): ");
            int ano = scn.nextInt() - 1900;
            int mes = scn.nextInt() - 1;
            int dia = scn.nextInt();
            scn.nextLine();
            dataInicio = criarData(ano, mes, dia);
            dataFim = dataInicio;
        } else {
            System.out.println("Digite a data de início do minicurso (Ano, mês, dia): ");
            int anoInicio = scn.nextInt() - 1900;
            int mesInicio = scn.nextInt() - 1;
            int diaInicio = scn.nextInt();
            scn.nextLine();
            dataInicio = criarData(anoInicio, mesInicio, diaInicio);

            System.out.println("Digite a data final do minicurso (Ano, mês, dia): ");
            int anoFim = scn.nextInt() - 1900;
            int mesFim = scn.nextInt() - 1;
            int diaFim = scn.nextInt();
            scn.nextLine();
            dataFim = criarData(anoFim, mesFim, diaFim);
        }

        System.out.println("Digite o horario de início da evento(hora, minuto): ");
        int horaInicio = scn.nextInt();
        int minInicio = scn.nextInt();
        String horarioInicio = horaInicio + ":" + minInicio;

        System.out.println("Digite o horario que a evento vai acabar(hora, minuto): ");
        int horaFim = scn.nextInt();
        int minFim = scn.nextInt();
        String horarioFim = horaFim + ":" + minFim;

        System.out.println("Digite a carga horária do evento: ");
        int cargaHoraria = scn.nextInt();

        System.out.println("Digite as vagas do evento: ");
        int vagas = scn.nextInt();

        Evento evento;
        if (tipoEvento == TipoEvento.PALESTRA) {
            evento = new Evento(titulo, palestrante, dataInicio, dataInicio, horarioInicio, horarioFim, cargaHoraria,
                    tipoEvento, vagas);
        } else {
            evento = new Evento(titulo, palestrante, dataInicio, dataFim, horarioInicio, horarioFim, cargaHoraria,
                    tipoEvento, vagas);
        }
        eventos.add(evento);
        System.out.println("Evento criado com sucesso.");
    }

    private Date criarData(int ano, int mes, int dia) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, ano);
        calendar.set(Calendar.MONTH, mes - 1);
        calendar.set(Calendar.DAY_OF_MONTH, dia);
        return calendar.getTime();
    }

    public void cadastrarPessoa() {
        Scanner scn = new Scanner(System.in);
        Date dataNascimento;

        System.out.println("Digite seu nome: ");
        String nome = scn.nextLine();

        System.out.println("Digite a sua data de nascimento (Ano, mês, dia): ");
        int ano = scn.nextInt() - 1900;
        int mes = scn.nextInt() - 1;
        int dia = scn.nextInt();
        scn.nextLine();
        dataNascimento = criarData(ano, mes, dia);

        Pessoa pessoa = new Pessoa(nome, dataNascimento);
        pessoas.add(pessoa);
    }

    public void fazerInscricaoEvento(int idEvento, String nomeInscrito) {
        Pessoa inscrito = null;
        for (Pessoa pessoa : pessoas) {
            if (pessoa.getNome().equalsIgnoreCase(nomeInscrito)) {
                inscrito = pessoa;
                break;
            }
        }
    
        if (inscrito == null) {
            System.out.println("Erro: Pessoa não cadastrada.");
            return;
        }

        Evento eventoEncontrado = null;
        for (Evento evento : eventos) {
            if (evento.getId() == idEvento) {
                eventoEncontrado = evento;
                break;
            }
        }
    
        if (eventoEncontrado == null) {
            System.out.println("Erro: Evento não encontrado.");
            return;
        }

        if (eventoEncontrado.getVagas() <= 0) {
            System.out.println("Erro: Não há vagas disponíveis para este evento.");
            return;
        }

        eventoEncontrado.getIncritos().add(inscrito);
        eventoEncontrado.setVagas(eventoEncontrado.getVagas() - 1);
        System.out.println("Inscrição realizada com sucesso.");
    }
    
}