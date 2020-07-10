package listas04;

import java.util.ArrayList;

public class ListaColegio {

    // atributos
    private static  ArrayList<Aluno> lista = new ArrayList<>();
    
    
    
   
    
    // metodo para cadastrar aluno
    public static void cadastrarAluno(Aluno aluno) {
        lista.add(aluno);
    }

    // metodo para remover aluno
    public static boolean removerAluno(int id) {
        for (Aluno e : lista) {
            if (e.getMatricula() == id) {
                lista.remove(e);
                System.out.println("Aluno removido com sucesso\n");
                System.out.println("--------------------------\n");
                return true;
            }
        }
         
         return false;
    }

    // metodo para lista os alunos
    public static String listarAlunos() {
        String saida = "";
        for (Aluno e : lista) {
            saida += e.imprimirAluno() + " ";
            saida += "\n-----------------------------\n";
        }

        return saida;
    }

    // metodo para pesquisar alunos
    public static String pesquisarAluno(String nome) {
        String saida = " ";
        for (Aluno e : lista) {
            if (e.getNome().equalsIgnoreCase(nome)) {
                saida += e.imprimirAluno();
                saida += "\n------------------------\n";
                        

            }
        }

        return saida;
    }

    
    
    // metodo get
    public static ArrayList<Aluno> getLista() {
        return lista;
    }


    
}
