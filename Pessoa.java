import java.util.Date;

public class Pessoa {
    static  int geradorId;
    private int id;
    private String nome;
    private Date dataNascimento;

    public Pessoa (String nome,  Date dataNascimento) {
        geradorId ++;
        this.id = geradorId;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDataNascimento(Date dataDenascimento) {
        this.dataNascimento = dataDenascimento;
    }

    public String toString() {
        StringBuilder pessoasCadastradas = new StringBuilder();       
        pessoasCadastradas.append("O nome dessa pessoa é: ").append(this.getNome()).append("\n");
        pessoasCadastradas.append("O id dessa pessoa é: ").append(this.getId()).append("\n");
        pessoasCadastradas.append("-----------------------------------------\n");
        
        return pessoasCadastradas.toString();
    }
}