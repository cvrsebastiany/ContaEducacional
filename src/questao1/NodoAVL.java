package questao1;

public class NodoAVL {
	private int valor, altura, fatorBalanceamento;
    private NodoAVL esquerdo, direito, pai;

    public NodoAVL() {
    	setValor(0);
    	setAltura(0);
    	setFatorBalanceamento(0);
    	setEsquerdo(null);
    	setDireito(null);
    	setPai(null);
    }
    
    public NodoAVL(int valor) {
        setValor(valor);
        setAltura(0);
        setFatorBalanceamento(0);
        setEsquerdo(null);
        setDireito(null);
        setPai(null);
    }

    // Getters e Setters
    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public int getFatorBalanceamento() {
        return fatorBalanceamento;
    }

    public void setFatorBalanceamento(int fatorBalanceamento) {
        this.fatorBalanceamento = fatorBalanceamento;
    }

    public NodoAVL getEsquerdo() {
        return esquerdo;
    }

    public void setEsquerdo(NodoAVL esquerdo) {
        this.esquerdo = esquerdo;
    }

    public NodoAVL getDireito() {
        return direito;
    }

    public void setDireito(NodoAVL direito) {
        this.direito = direito;
    }

    public NodoAVL getPai() {
        return pai;
    }

    public void setPai(NodoAVL pai) {
        this.pai = pai;
    }
}
