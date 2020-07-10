package listas04;

import java.util.ArrayList;

public class Aluno {

    private String nome;
    private int matricula;
    private String disciplina;
    private static ArrayList<Integer> telefones = new ArrayList<>();// usando listas para armazenar telefones
    private float[] notas;
    private Endereco endereco;// classe aluno tem um Endereco (outra classe)

    
    public Aluno() {
    }

    public Aluno(String nome, int matricula, String disciplina, float notas[]) {
        this.nome = nome;
        this.matricula = matricula;
        this.disciplina = disciplina;
        this.notas = notas;

    }

    // impressao dos dados
    public String imprimirAluno() {

        String dados = "";
        dados += "\nnome : " + this.getNome() + "\nmatricula :" + this.getMatricula()
                + "\ndisciplina :" + this.getDisciplina();

        for (Integer celular : telefones) {
            dados += "\ntelefone :" + celular;
        }
        int i = 0;
        for (float nt : notas) {
            dados += "\nnota "+ (++i) +":" + nt;
        }
        //fazer o controle de verificao de erro
        if (this.endereco != null) {
            dados += "\nbairro :" + this.endereco.getBairro()
                    + "\nrua :" + this.endereco.getRua()
                    + "\nnumero da casa :" + this.endereco.getNumeroCasa();
        }

        return dados;
    }

    // metodo para adicionar os telefones
    public static void adicionarTelefone(Integer numero1 , Integer numero2)
    {
        telefones.add(numero1);
        telefones.add(numero2);
    }
    
    
    // metodos especiais
    public String getNome() {
        return nome;
    }

    public int getMatricula() {
        return matricula;
    }

    public String getDisciplina() {
        return disciplina;
    }

    
    public float[] getNotas() {
        return notas;
    }

    public void setNotas(float[] notas) {
        this.notas = notas;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    
    public static ArrayList<Integer> getTelefones()
    {
        return telefones;
    }
}
