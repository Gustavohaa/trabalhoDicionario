import java.util.Scanner;

public class Tradutor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcao = 1;
        String palavra[] = new String[100];
        String traducao[] = new String[100];

        do {
            printMenu();
            opcao = sc.nextInt();
            if(opcao == 1) {
                registroDaPalavra(palavra);
                registroTraducao(traducao,palavra);
            } else if(opcao == 2) {
                editarPalavra(palavra,traducao);
            } else if(opcao == 3) {
                excluirPalavra(palavra,traducao);
            } else if(opcao == 4) {
                encontrarPalavra(palavra,traducao);
            } else if(opcao == 0) {
                System.out.println("Adeus!! ");
            } else {
                System.out.println("Opção Inválida!");
                System.out.println();
            }
        } while (opcao != 0);

    }
    public static void printMenu() {
        System.out.println("1- Cadastrar palavra ");
        System.out.println("2- Editar palavra ");
        System.out.println("3- Excluir palavra ");
        System.out.println("4- Consultar palavra ");
        System.out.println("0 - Sair");
        System.out.print("Escolha uma opção: ");
    }

    public static String[] registroDaPalavra(String[] palavra) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite uma palavra em inglês: ");
        for (int i = 0; i < 100; i++) {
            if (palavra[i] == null) {
                palavra[i] = sc.next();
                return verificaRegistro(palavra);
            }
        }
        return palavra;
    }

    public static String[] verificaRegistro(String palavra[]) {
        for (int i = 0; i < 100; i++) {
            int y = 1;
            for (y = y + i; y < 100; y++) {
                if (palavra[i] == null) {

                } else if (palavra[i].equals(palavra[y])) {
                    palavra[y] = null;
                    System.out.println("Éssa palavra já existe! ");
                    return palavra;
                }
            }
        }
        return palavra;
    }

    public static String[] registroTraducao(String traducao[], String palavra[]) {
        Scanner Scanner = new Scanner(System.in);
        for (int i = 0; i < 100; i++) {
            if (palavra[i] == null) {
                return traducao;
            } else if (traducao[i] == null) {
                System.out.println("Digite sua traducao: ");
                traducao[i] = Scanner.next();
                return traducao;
            }

        }
        return traducao;
    }

    public static void editarPalavra(String palavra[], String traducao[]) {
        Scanner Scanner = new Scanner(System.in);
        System.out.println("Digite um numero de 0 a 99 para ver uma palavra: ");
        int numero = Scanner.nextInt();
        System.out.println(palavra[numero]);
        System.out.println("Deseja editar a palavra selecionada? ");
        System.out.println("1 - Sim ");
        System.out.println("2 - Não ");
        int opcao = Scanner.nextInt();
        if (opcao == 1) {
            System.out.println("Digite a nova palavra: ");
            String Palavra = Scanner.next();
            palavra[numero] = Palavra;
            verificaRegistro(palavra);
            if (palavra[numero] == null) {
                traducao[numero] = null;
            } else {
                System.out.println("Digite sua traduçao: ");
                String Traducao = Scanner.next();
                traducao[numero] = Traducao;
            }
        }
    }

    public static String[] excluirPalavra(String palavra[], String traducao[]) {
        Scanner Scanner = new Scanner(System.in);
        System.out.println("Digite um numero de 0 a 99 para ver uma palavra: ");
        int numero = Scanner.nextInt();
        System.out.println(palavra[numero]);
        System.out.println("Deseja excluir a palavra selecionada? ");
        System.out.println("1 - Sim ");
        System.out.println("2 - Não ");
        int opcao = Scanner.nextInt();
        if (opcao == 1) {
            System.out.println("A palavra foi excluida ");
            palavra[numero] = null;
            traducao[numero] = null;
            return palavra;
        } else {
            return palavra;
        }
    }

    public static void encontrarPalavra(String palavra[], String traducao[]) {
        Scanner Scanner = new Scanner(System.in);
        System.out.println("Escolha uma opcao: ");
        System.out.println("1 - Para encontrar uma palavra no dicionario ");
        System.out.println("2 - Para digitar uma palavra do dicionario ");
        int opcao = Scanner.nextInt();
        if (opcao == 1) {
            System.out.println("Digite um numero de 0 a 99 para ver uma palavra: ");
            int numero = Scanner.nextInt();
            System.out.println(palavra[numero]);
            System.out.println(traducao[numero]);
        } else if (opcao == 2) {
            System.out.println("Digite a palavra: ");
            String p = Scanner.next();
            for (int i = 0; i < 100; i++) {
                if (palavra[i] == null) {
                    System.out.println("Essa palavra não esta no dicionario");
                    break;
                } else if (palavra[i].equals(p)) {
                    System.out.println(traducao[i]);
                    break;
                } else if (i == 99) {
                    System.out.println("Essa palavra não esta no dicionario");
                }
            }
        }
    }
}