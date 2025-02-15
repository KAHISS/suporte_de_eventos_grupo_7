import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Controle {
    private List<Evento> eventos = new ArrayList<>();
    private List<Pessoa> pessoas = new ArrayList<>();

    public void criarEvento(String titulo, TipoEvento tipoEvento, String palestrante, Date dataInicio, Date dataFim, String horarioInicio, String horarioFim,  int cargaHoraria, int vagas) {
        Evento evento = new Evento(titulo, palestrante, dataInicio, dataFim, horarioInicio, horarioFim, cargaHoraria, tipoEvento, vagas);
        eventos.add(evento);
        System.out.println("Evento criado com sucesso.");
    }

    public  Date criarData(int ano, int mes, int dia) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, ano);
        calendar.set(Calendar.MONTH, mes);
        calendar.set(Calendar.DAY_OF_MONTH, dia);
        return calendar.getTime();
    }

    public void cadastrarPessoa(String nome, Date dataNascimento) {
        Pessoa pessoa = new Pessoa(nome, dataNascimento);
        pessoas.add(pessoa);
        System.out.println("Cadastro realizado com sucesso!");
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

    public String imprimirEventosPeriodo(Date dataInicial, Date dataFinal) throws ParseException {
        StringBuilder sb = new StringBuilder();
        for (Evento lancamento : eventos) {
            Date dataEvento = lancamento.getDataInicio();

            if (!dataEvento.before(dataInicial) && !dataEvento.after(dataFinal)) {
                sb.append(lancamento.toString()).append("\n");
            }
        }

        return sb.length() > 0 ? sb.toString() : "Nenhum lançamento encontrado no período.";
    }

}