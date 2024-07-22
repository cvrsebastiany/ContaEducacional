package questao1;

public class Fila {
	private NodoFila fila;

	public Fila() {
		this.fila = null;
	}

	public NodoFila getFila() {
		return fila;
	}

	public void setFila(NodoFila fila) {
		this.fila = fila;
	}

	public void insereNodoFilaFinal(int valor) {
		NodoFila novo = new NodoFila();
		novo.setValor(valor);
		novo.setProx(null);

		if (this.fila == null) {
			this.fila = novo;
		} else {
			NodoFila aux = fila;
			while (aux.getProx() != null) {
				aux = aux.getProx();
			}
			aux.setProx(novo);
		}
	}

	public void removeNodoFilaInicio() {
		if (this.fila == null) {
			System.out.println("Lista vazia!");
		} else {
			this.fila = this.fila.getProx();
		}
	}

	public void imprime() {
		if (this.fila == null) {
			System.out.println("Lista vazia!");
		} else {
			NodoFila aux = this.fila;
			while (aux != null) {
				System.out.println("Valor: " + aux.getValor());
				aux = aux.getProx();
			}
		}
	}

	public void pesquisa(int valor) {
		if (this.fila == null) {
			System.out.println("Lista vazia!");
		} else {
			boolean achou = false;
			NodoFila aux = this.fila;
			while (aux != null && !achou) {
				if (valor == aux.getValor()) {
					achou = true;
				}
				aux = aux.getProx();
			}
			if (achou) {
				System.out.println("Valor encontrado!");
			} else {
				System.out.println("Valor não encontrado!");
			}
		}
	}

}
