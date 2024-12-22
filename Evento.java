import java.time.LocalDate;
import java.time.LocalTime;

public class Evento {
    private int id;
    private String titulo;
    private String palestrante;
    private LocalDate dataInicio;
    private LocalTime horaInicio;
    private LocalTime horaFim;
    private LocalDate dataFim;
    private int cargaHoraria;
    private int vagas;
    private Inscritos[] inscritos;

    public Evento(
        String titulo, 
        String palestrante, 
        int diai, int mesi, int anoi,
        int horai, int mini,
        int horaf, int minf,
        int diaf, int mesf, int anof,
        int cargaHoraria,
        int vagas
    ) {
        this.titulo = titulo;
        this.palestrante = palestrante;
        this.dataInicio = LocalDate.of(diai, mesi, anoi);
        this.horaInicio = LocalTime.of(horai, mini);
        this.horaFim = LocalTime.of(horaf, minf);
        this.dataInicio = LocalDate.of(diai, mesi, anoi);
        this.cargaHoraria = cargaHoraria;
        this.vagas = vagas;
    }
}
