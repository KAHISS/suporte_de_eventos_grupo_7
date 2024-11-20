import java.time.LocalDate;
import java.util.ArrayList;

public class Controle {
    private Evento[] eventos;
    
    public static void criarEvento(LocalDate dataInicio, LocalDate dataFim, int hora, int cargaHoraria, String titulo, String palestrante, int vagas) {
        Evento evento = new Evento(
            dataInicio, 
            dataFim,
            cargaHoraria,
            hora,
            titulo,
            palestrante,
            vagas
        );
        
    }

    public static void criarEvento(LocalDate dataInicio, int hora, int cargaHoraria, String titulo, int vagas) {
        Evento evento = new Evento(
            dataInicio, 
            dataInicio,
            cargaHoraria,
            hora,
            titulo,
            "",
            vagas
        );

    }

    public static void criarEvento(LocalDate dataInicio, int hora, int cargaHoraria, String titulo, String palestrante, int vagas) {
        Evento evento = new Evento(
            dataInicio, 
            dataInicio,
            cargaHoraria,
            hora,
            titulo,
            palestrante,
            vagas
        );

    }


    public void imprimirLancamentosPorMes(int mes) {
        for(int i = 0; i < eventos.length; i++) {
            if(eventos[i].getMes() == mes) {
                eventos[i].toString();
            }
        }
    }
}