package questao1;

public class ArvoreBin {
	public NodoAVL raiz;

	public ArvoreBin() {
		this.raiz = null;
	}

	public NodoAVL getRaiz() {
		return raiz;
	}

	public void setRaiz(NodoAVL raiz) {
		this.raiz = raiz;
	}

	
	public void insere(NodoAVL aux, int valor) {
		// verifica se a raiz da árvore não é nula
		if (aux != null) {
			NodoAVL novo = new NodoAVL(valor);
			// Verifica se o valor a ser inserido é menor que o NodoAVL corrente da árvore, se
			// sim, vai para subárvore esquerda
			if (valor < aux.getValor()) {
				// Se tiver elemento no NodoAVL esquerdo, continua a busca
				if (aux.getEsquerdo() != null)
					insere(aux.getEsquerdo(), valor);
				else {
					// Se NodoAVL esquerdo vazio, insere o novo NodoAVL aqui
					System.out.println("Inserindo " + valor + " a esquerda de " + aux.getValor());
					aux.setEsquerdo(novo);
				}
				// Verifica se o valor a ser inserido é maior que o NodoAVL corrente da árvore, se
				// sim, vai para subárvore direita
			} else if (valor > aux.getValor()) {
				// Se tiver elemento no NodoAVL direito, continua a busca
				if (aux.getDireito() != null) {
					insere(aux.getDireito(), valor);
				} else {
					// Se NodoAVL direito vazio, insere o novo NodoAVL aqui
					System.out.println("Inserindo " + valor + " a direita de " + aux.getValor());
					aux.setDireito(novo);
				}
			}
			novo.setPai(aux);
			calculaAltura(aux);
		} else {
			System.out.println("Inserindo " + valor + " na raiz");
			setRaiz(new NodoAVL(valor));
		}
	}
	
	// Função Principal de Remoção
	public void remove(int valor) {
		raiz = removeRecursivo(raiz, valor);
	}

	// Função Recursiva de Remoção
	private NodoAVL removeRecursivo(NodoAVL aux, int valor) {
		if (aux == null) {
			System.out.println("Valor não encontrado! Cancelando operação...");
			return null;
		}

		if (valor < aux.getValor()) {
			aux.setEsquerdo(removeRecursivo(aux.getEsquerdo(), valor));
		} else if (valor > aux.getValor()) {
			aux.setDireito(removeRecursivo(aux.getDireito(), valor));
		} else {
			aux = lidaRemocao(aux);
		}
		return aux;
	}

	// Função de Tratamento de Remoção
	private NodoAVL lidaRemocao(NodoAVL aux) {
		if (aux.getEsquerdo() == null && aux.getDireito() == null) {
			return null; // Nó folha
		} else if (aux.getEsquerdo() == null) {
			return aux.getDireito(); // Nó com subárvore direita
		} else if (aux.getDireito() == null) {
			return aux.getEsquerdo(); // Nó com subárvore esquerda
		} else { //Nó com duas subárvores
			NodoAVL substituto = encontraMaximo(aux.getEsquerdo());
			aux.setValor(substituto.getValor());
			aux.setEsquerdo(removeRecursivo(aux.getEsquerdo(), substituto.getValor()));
			return aux;
		}
	}

	// Função para Encontrar o Mínimo
	public NodoAVL encontraMinimo(NodoAVL aux) {
		while (aux.getEsquerdo() != null) {
			aux = aux.getEsquerdo();
		}
		return aux;
	}

	public NodoAVL encontraMaximo(NodoAVL aux) {
		while (aux.getDireito() != null) {
			aux = aux.getDireito();
		}
		return aux;
	}
	
	private int calculaAltura(NodoAVL aux) {
		if(aux == null)
			return 0;
		else {
			int esq = calculaAltura(aux.getEsquerdo());
			int dir = calculaAltura(aux.getDireito());
			aux.setFatorBalanceamento(dir-esq);		
			if(esq > dir) {
				aux.setAltura(esq);
				return esq+1;
			}
			else  {
				aux.setAltura(dir);
				return dir+1;
			}
		}
	}

	public void imprime(NodoAVL aux) {
		if(aux != null) {
			System.out.println("----- ");
			System.out.println(aux.getValor());
			if(aux.getPai() != null)
				System.out.println("pai: "+aux.getPai().getValor());
			System.out.println("altura: "+aux.getAltura());
			System.out.println("balanceamento: "+aux.getFatorBalanceamento());
			imprime(aux.getEsquerdo());
			imprime(aux.getDireito());
		}
	}
	
	// Função Principal de Procura
	public boolean procura(int valor) {
		return procuraRecursivo(raiz, valor);
	}

	// Função Recursiva de Procura
	private boolean procuraRecursivo(NodoAVL aux, int valor) {
		if (aux == null) {
			return false;
		}
		if (valor == aux.getValor()) {
			return true;
		} else if (valor < aux.getValor()) {
			return procuraRecursivo(aux.getEsquerdo(), valor);
		} else {
			return procuraRecursivo(aux.getDireito(), valor);
		}
	}
}
