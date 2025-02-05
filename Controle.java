import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Controle {
    private List<Evento> eventos = new ArrayList<>();
    private List<Pessoa> pessoas = new ArrayList<>();

    public void criarEvento() {
        Scanner scn = new Scanner(System.in);
        System.out.println("Digite o título da evento: ");
        String titulo = scn.nextLine();

        System.out.println("Digite o tipo de evento (palestra/minicurso): ");
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
            System.out.println("Digite a sua data de nascimento (dia): ");
            int dia = scn.nextInt();
            System.out.println("Digite a sua data de nascimento (mês): ");
            int mes = scn.nextInt() - 1;
            System.out.println("Digite a sua data de nascimento (ano): ");
            int ano = scn.nextInt() - 1900;
            scn.nextLine();
            dataInicio = criarData(ano, mes, dia);
            dataFim = dataInicio;
        } else {
            System.out.println("Digite a sua data de nascimento (dia): ");
            int diaInicio = scn.nextInt();
            System.out.println("Digite a sua data de nascimento (mês): ");
            int mesInicio = scn.nextInt() - 1;
            System.out.println("Digite a sua data de nascimento (ano): ");
            int anoInicio = scn.nextInt() - 1900;
            scn.nextLine();
            dataInicio = criarData(anoInicio, mesInicio, diaInicio);

            System.out.println("Digite a sua data de nascimento (dia): ");
            int diaFim = scn.nextInt();
            System.out.println("Digite a sua data de nascimento (mês): ");
            int mesFim = scn.nextInt() - 1;
            System.out.println("Digite a sua data de nascimento (ano): ");
            int anoFim = scn.nextInt() - 1900;
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

        System.out.println("Digite a sua data de nascimento (dia): ");
        int dia = scn.nextInt();
        System.out.println("Digite a sua data de nascimento (mês): ");
        int mes = scn.nextInt() - 1;
        System.out.println("Digite a sua data de nascimento (ano): ");
        int ano = scn.nextInt() - 1900;
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

    public String imprimirEventos() {
        StringBuilder detalhesEventos = new StringBuilder();
        
        for (int i = 0; i < eventos.size(); i++) {          
            detalhesEventos.append(eventos.get(i).toString());
        }
        return detalhesEventos.toString();
    }

    public String imprimirPessoas() {
        StringBuilder pessoasCadastradas = new StringBuilder();
        for (int i = 0; i < pessoas.size(); i++) {          
            pessoasCadastradas.append(pessoas.get(i).toString()).append("\n");
        }
        return pessoasCadastradas.toString();
    }

    public String imprimirInscritosEvento(int idEvento) {
        Evento eventoEncontrado = null;
        StringBuilder pessoasCadastradas = new StringBuilder();

        for(Evento evento : eventos) {
            if(evento.getId() == idEvento) {
                eventoEncontrado = evento;
            }
        }

        for(int i = 0; i < eventoEncontrado.getIncritos().size(); i++){
            pessoasCadastradas.append(eventoEncontrado.getIncritos().get(i).toString()).append("\n");
        }

        return pessoasCadastradas.toString();
    }

    public String imprimirEventosTipo(String tipoEvento) {
        StringBuilder tipoEventos = new StringBuilder();

        for(Evento evento : eventos) {
            if(evento.getTipoEvento().toString().equalsIgnoreCase(tipoEvento)) {
                tipoEventos.append(evento.toString()).append("\n");
            }
        }

        return tipoEventos.toString();
    }

    public String imprimirEventosComVaga() {
        StringBuilder eventosComVaga = new StringBuilder();

        for(Evento evento : eventos) {
            if(evento.getVagas() > 0) {
                eventosComVaga.append(evento.toString()).append("\n");
            }
        }

        return eventosComVaga.toString();
    }

    public String imprimirEventosInscrito(String nomeInscrito) {
        StringBuilder inscricoes = new StringBuilder();
    
        for(Evento evento : eventos) {
            for (int i = 0; i < evento.getIncritos().size(); i++) {
                if (evento.getIncritos().get(i).getNome().equalsIgnoreCase(nomeInscrito)) {
                    inscricoes.append(nomeInscrito + " está inscrito em: ").append(evento.getTitulo()).append("\n");
                }
            }
        }

        return inscricoes.toString();
    
    }

    public String imprimirEventosPeriodo(String dataInicial, String dataFinal) throws ParseException {
        SimpleDateFormat data = new SimpleDateFormat("yyyy-MM-dd");
        Date inicio = data.parse(dataInicial);
        Date fim = data.parse(dataFinal);

        StringBuilder eventosPeriodo = new StringBuilder();

        for (Evento evento : eventos) {
            Date dataEvento = evento.getDataFim();
            if (!dataEvento.before(inicio) && !dataEvento.after(fim)) {
                eventosPeriodo.append(evento.toString()).append("\n");
            }
        }

        return eventosPeriodo.toString();
    }

    
}