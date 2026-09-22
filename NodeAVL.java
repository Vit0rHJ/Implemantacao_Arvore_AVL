public class NodeAVL {
    private int valor;
    private NodeAVL esquerda;
    private NodeAVL direita;

    public NodeAVL(int valor) {
        this.valor = valor;
        this.esquerda = null;
        this.direita = null;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public NodeAVL getEsquerda() {
        return esquerda;
    }

    public void setEsquerda(NodeAVL esquerda) {
        this.esquerda = esquerda;
    }

    public NodeAVL getDireita() {
        return direita;
    }

    public void setDireita(NodeAVL direita) {
        this.direita = direita;
    }
}
