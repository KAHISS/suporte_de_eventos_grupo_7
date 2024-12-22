import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Evento {
    private static int geradorId;
    private int id;
    private Date dataInicio;
    private Date dataFim;
    private String horarioInicio; //Podem usar classe Time se desejarem
    private String horarioFim; //Podem usar classe Time se desejarem
    private int cargaHoraria;
    private List<Pessoa> incritos = new ArrayList<>();
    private int vagas;
    private TipoEvento tipoEvento;
    private String titulo;
    private String palestrante;

    // Construtor para palestras
    public Evento(String titulo, String palestrante, Date dataInicio, Date dataFim, String horarioInicio, String horarioFim, int cargaHoraria, TipoEvento tipoEvento, int vagas) {
        geradorId ++;
        id = geradorId;
        this.titulo = titulo;
        this.palestrante = palestrante;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.horarioInicio = horarioInicio;
        this.horarioFim = horarioFim;
        this.cargaHoraria = cargaHoraria;
        this.tipoEvento = tipoEvento;
        this.vagas = vagas;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public String getHorarioInicio() {
        return horarioInicio;
    }

    public String getHorarioFim() {
        return horarioFim;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public List<Pessoa> getIncritos() {
        return incritos;
    }

    public TipoEvento getTipoEvento() {
        return tipoEvento;
    }

    public int getId() {
        return id;
    }

    public int getVagas() {
        return vagas;
    }

    public static int getGeradorId() {
        return geradorId;
    }

    public String getPalestrante() {
        return palestrante;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    public void setHorarioInicio(String horarioInicio) {
        this.horarioInicio = horarioInicio;
    }

    public void setHorarioFim(String horarioFim) {
        this.horarioFim = horarioFim;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public void setIncritos(List<Pessoa> incritos) {
        this.incritos = incritos;
    }

    public void setPalestrante(String palestrante) {
        this.palestrante = palestrante;
    }

    public void setTipoEvento(TipoEvento tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setVagas(int vagas) {
        this.vagas = vagas;
    }
}
