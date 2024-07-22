package questao1;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		ArvoreBin ab = new ArvoreBin();
		Fila fila = new Fila();
		Scanner scanner = new Scanner(System.in);

		
		int escolha, valor;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Inserir valor na árvore binária");
            System.out.println("2. Remover valor da árvore e inseri-lo na fila");
            System.out.println("3. Imprimir árvore");
            System.out.println("4. Imprimir fila");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            escolha = scanner.nextInt();

            switch (escolha) {
                case 1:
                	System.out.print("Digite o valor a ser inserido: ");
                    valor = scanner.nextInt();
                    ab.insere(ab.raiz, valor);
                    break;
                case 2:
                	System.out.print("Digite o valor a ser removido da árvore para ser inserido na fila: ");
                    valor = scanner.nextInt();
                    if(ab.procura(valor) == true) {
                		fila.insereNodoFilaFinal(valor);
                    	System.out.println("Valor removido da árvore e inserido na fila com sucesso!");
                    }
                    ab.remove(valor);
                    break;
                case 3:
                	System.out.println("\nImprimindo Árvore...\n\n");
                	ab.imprime(ab.getRaiz());
                    break;
                case 4:
                	System.out.println("\nImprimindo fila...\n\n");
                	fila.imprime();
                    break;
                case 0:
                	System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (escolha != 0);

        scanner.close();
    }
	
}
