package questao1;

public class NodoFila {
	private int valor;
	private NodoFila prox;

	public NodoFila() {
		this.valor = 0;
		this.prox = null;
	}

	public NodoFila(int valor, NodoFila prox) {
		super();
		this.valor = valor;
		this.prox = prox;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public NodoFila getProx() {
		return prox;
	}

	public void setProx(NodoFila prox) {
		this.prox = prox;
	}

}
