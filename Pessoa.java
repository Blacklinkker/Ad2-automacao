public class Pessoa {
    String nome;
    String renda;
    String etnia;
    String sexo;
    String escolaridade;
    String idade;
    String orientacao;
    String emprego;
    String deficiencia = "Não possui";
    int cpf = 0;

    public Pessoa(String nome, String etnia, String sexo, String escolaridade, String idade, String orientacao, String renda, int cpf, String deficiencia, String emprego) {
        this.nome = nome;
        this.renda = renda;
        this.etnia = etnia;
        this.sexo = sexo;
        this.escolaridade = escolaridade;
        this.idade = idade;
        this.orientacao = orientacao;
        this.cpf = cpf;
        this.deficiencia = deficiencia;
    }

    public Pessoa(String nome, String etnia, String sexo, String escolaridade, String idade, String orientacao, String renda, String deficiencia, String emprego) {
        this.nome = nome;
        this.renda = renda;
        this.etnia = etnia;
        this.sexo = sexo;
        this.escolaridade = escolaridade;
        this.idade = idade;
        this.orientacao = orientacao;
        this.deficiencia = deficiencia;
    }

    public Pessoa(String nome, String etnia, String sexo, String escolaridade, String idade, String orientacao, String renda, int cpf, String emprego) {
        this.nome = nome;
        this.renda = renda;
        this.etnia = etnia;
        this.sexo = sexo;
        this.escolaridade = escolaridade;
        this.idade = idade;
        this.orientacao = orientacao;
        this.cpf = cpf;
    }

    public Pessoa(String nome, String etnia, String sexo, String escolaridade, String idade, String orientacao, String renda, String emprego) {
        this.nome = nome;
        this.renda = renda;
        this.etnia = etnia;
        this.sexo = sexo;
        this.escolaridade = escolaridade;
        this.idade = idade;
        this.orientacao = orientacao;
    }

    public String getNome() {
        return nome;
    }

    public int getCpf() {
        return cpf;
    }

    public String getDeficiencia() {
        return deficiencia;
    }

    public String getEscolaridade() {
        return escolaridade;
    }

    public String getEtnia() {
        return etnia;
    }

    public String getIdade() {
        return idade;
    }

    public String getOrientacao() {
        return orientacao;
    }

    public String getRenda() {
        return renda;
    }

    public String getSexo() {
        return sexo;
    }
    
    @Override
    public String toString() {
        return " Nome: " + getNome()
        + "\n CPF: "+ getCpf()
        + "\n Faixa de idade: " + getIdade()
        + "\n Etnia: " + getEtnia() 
        + "\n Escolaridade: " + getEscolaridade()
        + "\n Sexo: " + getSexo()
        + "\n Orientação sexual: " + getOrientacao()
        + "\n Renda: " + getRenda()
        + "\n Deficiência: " + getDeficiencia();
    }
}
