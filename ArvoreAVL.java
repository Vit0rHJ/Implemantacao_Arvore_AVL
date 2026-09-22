public class ArvoreAVL {
    private NodeAVL raiz;

    public ArvoreAVL() {
        this.raiz = null;
    }

    public NodeAVL getRaiz() {
        return raiz;
    }

    public boolean estaVazia() {
        return raiz == null;
    }

    public int altura() {
        return altura(raiz);
    }

    private int altura(NodeAVL n) {
        if (n == null) {
            return -1;
        }
        int altEsq = altura(n.getEsquerda());
        int altDir = altura(n.getDireita());
        if (altEsq > altDir) {
            return altEsq + 1;
        } else {
            return altDir + 1;
        }
    }

    private int fatorBalanceamento(NodeAVL n) {
        if (n == null) {
            return 0;
        }
        return altura(n.getEsquerda()) - altura(n.getDireita());
    }

    private NodeAVL rotacaoDireita(NodeAVL n) {
        NodeAVL temp = n.getEsquerda();
        n.setEsquerda(temp.getDireita());
        temp.setDireita(n);
        return temp;
    }

    private NodeAVL rotacaoEsquerda(NodeAVL n) {
        NodeAVL temp = n.getDireita();
        n.setDireita(temp.getEsquerda());
        temp.setEsquerda(n);
        return temp;
    }

    private NodeAVL rotacaoDuplaLR(NodeAVL n) {
        n.setEsquerda(rotacaoEsquerda(n.getEsquerda()));
        return rotacaoDireita(n);
    }

    private NodeAVL rotacaoDuplaRL(NodeAVL n) {
        n.setDireita(rotacaoDireita(n.getDireita()));
        return rotacaoEsquerda(n);
    }

    private NodeAVL balancear(NodeAVL n) {
        int fb = fatorBalanceamento(n);

        if (fb > 1) {
            if (fatorBalanceamento(n.getEsquerda()) >= 0) {
                return rotacaoDireita(n);
            } else {
                return rotacaoDuplaLR(n);
            }
        }

        if (fb < -1) {
            if (fatorBalanceamento(n.getDireita()) <= 0) {
                return rotacaoEsquerda(n);
            } else {
                return rotacaoDuplaRL(n);
            }
        }

        return n;
    }

    public void inserir(int valor) {
        raiz = inserir(raiz, valor);
    }

    private NodeAVL inserir(NodeAVL n, int valor) {
        if (n == null) {
            return new NodeAVL(valor);
        }
        if (valor < n.getValor()) {
            n.setEsquerda(inserir(n.getEsquerda(), valor));
        } else if (valor > n.getValor()) {
            n.setDireita(inserir(n.getDireita(), valor));
        } else {
            return n;
        }
        return balancear(n);
    }

    public boolean buscar(int valor) {
        NodeAVL atual = raiz;
        while (atual != null) {
            if (valor == atual.getValor()) {
                return true;
            }
            if (valor < atual.getValor()) {
                atual = atual.getEsquerda();
            } else {
                atual = atual.getDireita();
            }
        }
        return false;
    }

    public boolean remover(int valor) {
        if (!buscar(valor)) {
            return false;
        }
        raiz = remover(raiz, valor);
        return true;
    }

    private NodeAVL remover(NodeAVL n, int valor) {
        if (n == null) {
            return null;
        }
        if (valor < n.getValor()) {
            n.setEsquerda(remover(n.getEsquerda(), valor));
        } else if (valor > n.getValor()) {
            n.setDireita(remover(n.getDireita(), valor));
        } else {
            if (n.getEsquerda() == null) {
                return n.getDireita();
            }
            if (n.getDireita() == null) {
                return n.getEsquerda();
            }
            int antecessor = maiorValor(n.getEsquerda());
            n.setValor(antecessor);
            n.setEsquerda(remover(n.getEsquerda(), antecessor));
        }
        return balancear(n);
    }

    private int maiorValor(NodeAVL n) {
        while (n.getDireita() != null) {
            n = n.getDireita();
        }
        return n.getValor();
    }

    public void preOrdem() {
        preOrdem(raiz);
        System.out.println();
    }

    private void preOrdem(NodeAVL n) {
        if (n == null) {
            return;
        }
        System.out.print(n.getValor() + " ");
        preOrdem(n.getEsquerda());
        preOrdem(n.getDireita());
    }

    public void emOrdem() {
        emOrdem(raiz);
        System.out.println();
    }

    private void emOrdem(NodeAVL n) {
        if (n == null) {
            return;
        }
        emOrdem(n.getEsquerda());
        System.out.print(n.getValor() + " ");
        emOrdem(n.getDireita());
    }

    public void posOrdem() {
        posOrdem(raiz);
        System.out.println();
    }

    private void posOrdem(NodeAVL n) {
        if (n == null) {
            return;
        }
        posOrdem(n.getEsquerda());
        posOrdem(n.getDireita());
        System.out.print(n.getValor() + " ");
    }

    public boolean estaBalanceada() {
        return estaBalanceada(raiz);
    }

    private boolean estaBalanceada(NodeAVL n) {
        if (n == null) {
            return true;
        }
        int fb = fatorBalanceamento(n);
        if (fb > 1 || fb < -1) {
            return false;
        }
        return estaBalanceada(n.getEsquerda()) && estaBalanceada(n.getDireita());
    }

    public void imprimirEstrutura() {
        imprimirEstrutura(raiz, 0);
    }

    private void imprimirEstrutura(NodeAVL n, int nivel) {
        if (n == null) {
            return;
        }
        imprimirEstrutura(n.getDireita(), nivel + 1);
        for (int i = 0; i < nivel; i++) {
            System.out.print("      ");
        }
        System.out.println(n.getValor() + " (FB=" + fatorBalanceamento(n) + ")");
        imprimirEstrutura(n.getEsquerda(), nivel + 1);
    }
}
