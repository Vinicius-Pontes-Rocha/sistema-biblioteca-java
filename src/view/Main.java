package view;

import model.Livro;
import model.Usuario;

import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        System.out.println("Selecione a opção desejada");

        Scanner sc = new Scanner(System.in);
        ArrayList<Livro> livros = new ArrayList<>();
        ArrayList<Usuario> usuarios = new ArrayList<>();

        int op = 0;

        while (op !=7) {

            System.out.println("""
                Opções de Usuario
                1-Cadastrar Livro
                2-Cadastrar Usuario
                3-Emprestar Livro
                4-Devolver Livro
                5-Listar Livros
                6-Listar Usuarios
                7-Sair
            """);

            op = sc.nextInt();
            sc.nextLine();

            switch (op) {

                case 1:
                    Livro livro = new Livro();

                    System.out.println("Ano de lançamento");
                    livro.setAno(sc.nextInt());
                    sc.nextLine();

                    System.out.println("Autor");
                    livro.setAutor(sc.nextLine());

                    System.out.println("Nome do livro");
                    livro.setNome(sc.nextLine());

                    System.out.println("Numero de paginas");
                    livro.setPaginas(sc.nextInt());

                    System.out.println("Preço");
                    livro.setPreço(sc.nextDouble());

                    System.out.println("ID");
                    livro.setId(sc.nextInt());

                    livros.add(livro);

                    break;

                case 2 :
                    Usuario user = new Usuario();

                    System.out.println("Nome do Usuario:");
                    user.setNome(sc.nextLine());

                    System.out.println("CPF do usuario");
                    user.setCpf(sc.nextLine());

                    System.out.println("Email do usuario");
                    user.setEmail(sc.nextLine());

                    System.out.println("ID do Usuario");
                    user.setIdUsuario(sc.nextInt());

                    usuarios.add(user);

                    break;

                case 3 :

                    System.out.println("Selecione o usuario pelo ID:");

                    for (int i = 0; i < usuarios.size(); i++) {
                        System.out.println(usuarios.get(i).getIdUsuario() + " - " + usuarios.get(i));
                    }

                    System.out.println("Digite o ID :");
                    int idUsuario = sc.nextInt();
                    sc.nextLine();

                    Usuario usuarioEscolhido = null;

                    for (int i = 0; i < usuarios.size(); i++) {
                        if(usuarios.get(i).getIdUsuario() == idUsuario) {
                            usuarioEscolhido=usuarios.get(i);
                        }
                    }

                    if (usuarioEscolhido == null) {
                        System.out.println("Usuário não encontrado");
                        break;
                    }

                    System.out.println("Selecione o Livro");

                    for (int i = 0; i < livros.size(); i++) {
                        System.out.println(livros.get(i).getId() + " - " + livros.get(i));
                    }

                    System.out.println("selecione o id ");

                    int idEscolhido = sc.nextInt();
                    sc.nextLine();

                    for (int i = 0; i < livros.size(); i++) {
                        if (livros.get(i).getId() == idEscolhido) {
                           if(!livros.get(i).isEmprestado()) {
                               livros.get(i).setEmprestado(true);
                               livros.get(i).setUsuarioEmprestado(usuarioEscolhido);
                               System.out.println("Livro emprestado!");
                           }
                        }
                    }

                    break;

                case 4 :
                    for (int i = 0; i < livros.size(); i++) {
                       if( livros.get(i).isEmprestado()) {
                           System.out.println(livros.get(i).getNome() + " está emprestado para " + livros.get(i).getUsuarioEmprestado().getNome() +  ", deseja devolver?S/N");
                           String decisao = sc.nextLine();

                           if (decisao.equalsIgnoreCase("S")) {

                               livros.get(i).setEmprestado(false);
                               livros.get(i).setUsuarioEmprestado(null);

                               System.out.println("Livro Devolvido");

                           } else if (decisao.equalsIgnoreCase("N")) {
                               continue;
                           }
                       }

                    }
                    break;

                case 5:
                    if (livros.isEmpty()) {
                        System.out.println("Nenhum livro cadastrado");
                    } else {
                        for (int i = 0; i < livros.size(); i++) {
                            System.out.println(livros.get(i));
                        }
                    }
                    break;

                case 6:

                    if(usuarios.isEmpty()){
                        System.out.println("Nenhum usuario cadastrado");
                    } else {
                        for(int i = 0; i < usuarios.size(); i++){
                            System.out.println(usuarios.get(i));
                        }
                    }

                    break;

                case 7:
                    System.out.println("Saindo");
                    return;


                default:
                    System.out.println("Opção inválida");
            }

        }
        System.out.println("\nPressione ENTER para voltar ao menu...");
        sc.nextLine();

    }

}
