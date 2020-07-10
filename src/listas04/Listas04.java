package listas04;

// importações
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Listas04 {

    // metodo principal
    public static void main(String[] args) {

        menu();  // chamada do metodo estatico menu

    }// fim do metodo principal

    // menu
    public static void menu() {

        int opcao;

        Scanner numeros = new Scanner(System.in);
        Scanner scan = new Scanner(System.in);
        Aluno escola;
        Endereco endereco;

        do {

            System.out.println("1 - cadastrar :");
            System.out.println("2 - pesquisar aluno :");
            System.out.println("3 - listar :");
            System.out.println("4 - remover :");
            System.out.println("5 - ordenar por nome :");
            System.out.println("6 - ordenar por matricula :");
            System.out.println("0 - sair\n");

            System.out.println("Escolha uma opcao :");
            opcao = numeros.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("------------CADASTRAR------------\n");

                    System.out.println("Digite o nome do aluno :");
                    String nome = scan.nextLine();
                    System.out.println("Digite o numero da matricula :");
                    int matricula = numeros.nextInt();
                    System.out.println("Digite a disciplina :");
                    String disciplina = scan.nextLine();
                    
                    // usando listas 
                    System.out.println("Digite o primeiro telefone :");
                    Integer celular1 = numeros.nextInt();
                    System.out.println("Digite o segundo telefone :");
                    Integer celular2 = numeros.nextInt();
                    // variaveis adicionadas na lista logo abaixo

                    //pega as notas e adiciona no vetor
                    float[] aluninho = new float[2];
                    int i = 0;
                    
                    for ( i = 0; i < aluninho.length; i++) {
                        
                        System.out.println("Digite a nota "+ (i + 1) +" :");
                        aluninho[i] = numeros.nextFloat();
                        
                    }
                    
                    System.out.println("Digite o bairro :");
                    String bairro = scan.nextLine();
                    System.out.println("Digite o nome da rua :");
                    String rua = scan.nextLine();
                    System.out.println("Digite o numero da casa :");
                    int numeroCasa = numeros.nextInt();

                    // instancia da classe escola e endereco
                    escola = new Aluno(nome, matricula, disciplina, aluninho);
                    endereco = new Endereco(bairro, rua, numeroCasa);
                    escola.setEndereco(endereco);// associacao entre classes
                    escola.setNotas(aluninho);// associacao entre classes
                    
                    // adicionando na lista os alunos e os contatos de celular
                    ListaColegio.cadastrarAluno(escola);
                    Aluno.adicionarTelefone(celular1, celular2);
                    System.out.println("\n------------------------------------\n");
                    break;

                case 2:
                    System.out.println("------------PESQUISAR---------\n");

                    System.out.println("Digite o nome para pesquisar :");
                    String pesquisar = scan.nextLine();

                    if (!ListaColegio.getLista().isEmpty()) {
                        System.out.println(ListaColegio.pesquisarAluno(pesquisar));
                    } else {
                        System.out.println("Aluno nao cadastrado\n");
                        System.out.println("-----------------------------\n");
                    }
                   
                    break;

                case 3:
                    System.out.println("-------------LISTAR-------------\n");
                    if(!ListaColegio.getLista().isEmpty())
                    System.out.println(ListaColegio.listarAlunos());
                    else
                    {
                        System.out.println("Sua lista esta vazia\n");
                        System.out.println("------------------------------\n");
                    }
                    break;

                case 4:
                    System.out.println("--------------REMOVER-----------\n");
                    System.out.println("Digite a matricula para excluir :");
                    int excluir = numeros.nextInt();
                    
                    if (!ListaColegio.getLista().isEmpty())
                    {
                    ListaColegio.removerAluno(excluir);
                    }
                    else
                    {
                        System.out.println("Sua lista esta vazia\n");
                        System.out.println("-----------------------------\n");
                    }

                    break;

                case 5:
                    System.out.println("-----------ORDENAR POR NOME--------\n");
                   // Collections.sort(ListaColegio.getLista(),(n1 , n2) -> n1.getNome().compareTo(n2.getNome()));
                    //usando lambdas para comparar nomes
                    Collections.sort(ListaColegio.getLista(), new OrdenarNome());
                    for (Aluno e : ListaColegio.getLista()) {
                        System.out.println(e.imprimirAluno());
                    }
                    System.out.println("----------------------------------\n");
                    break;

                case 6:
                    System.out.println("---------ORDENAR POR MATRICULA-----\n");
                    
                    Collections.sort(ListaColegio.getLista(), new OrdenarMatricula());
                    for (Aluno e : ListaColegio.getLista()) {
                        System.out.println(e.imprimirAluno());
                    }
                    System.out.println("----------------------------------\n");
                    break;

                case 0:
                    System.out.println("Obrigado pela visita ");
                    break;

                default:
                    System.out.println("Opcao invalida\n");
            }

        } while (opcao != 0);

    }

    // classe para ordenar alunos
    public static class OrdenarNome implements Comparator<Aluno> {

        @Override
        public int compare(Aluno x, Aluno y) {
            return x.getNome().compareTo(y.getNome());
        }

    }

    public static class OrdenarMatricula implements Comparator<Aluno> {

        @Override
        public int compare(Aluno x, Aluno y) {
            return (x.getMatricula() - y.getMatricula());
        }
    }

    
    
}
