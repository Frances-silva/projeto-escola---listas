package listas04;

public class Endereco {

    //atributos
    private String bairro;
    private String rua;
    private int numeroCasa;

    // construtores
    public Endereco() {
    }

    public Endereco(String bairro, String rua, int numeroCasa) {
        this.bairro = bairro;
        this.rua = rua;
        this.numeroCasa = numeroCasa;

    }

    // metodos especiais
    public String getBairro() {
        return bairro;
    }

    public String getRua() {
        return rua;
    }

    public int getNumeroCasa() {
        return numeroCasa;
    }

}
