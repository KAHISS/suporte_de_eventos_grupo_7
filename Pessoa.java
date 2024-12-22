import java.time.LocalDate;
import java.util.Random;

public class Pessoa {
    private int id;
    private String nome;
    private LocalDate dataNascimento;

    public Pessoa (String nome,  int day, int month, int year) {
        this.id = new Random().nextInt(0, 1000);
        this.nome = nome;
        this.dataNascimento = LocalDate.of(day, month, year);
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDataNascimento(int day, int month, int year) {
        this.dataNascimento = LocalDate.of(day, month, year);
    }

}