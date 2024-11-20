public enum  tipoDeEvento {
    PALESTRA("palestra"),
    MINICURSO("minicurso"),
    RODEIO("rodeio" ),
    BGS2024("BGS"),
    FORMATURA("formatura");

     private final String nome;

   private tipoDeEvento(String nome){
       this.nome = nome;

   }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return (nome + " " );
    }
}
