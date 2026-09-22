public class MainAVL {
    public static void main(String[] args) {
        System.out.println("EXERCICIO 1: 50, 30, 10, 70, 80");
        ArvoreAVL ex1 = new ArvoreAVL();
        int[] seq1 = {50, 30, 10, 70, 80};
        for (int i = 0; i < 5; i++) {
            ex1.inserir(seq1[i]);
            System.out.println("Inseriu " + seq1[i] + ":");
            ex1.imprimirEstrutura();
            System.out.println();
        }

        System.out.println("EXERCICIO 2: 50, 20, 40, 70, 60");
        ArvoreAVL ex2 = new ArvoreAVL();
        int[] seq2 = {50, 20, 40, 70, 60};
        for (int i = 0; i < 5; i++) {
            ex2.inserir(seq2[i]);
            System.out.println("Inseriu " + seq2[i] + ":");
            ex2.imprimirEstrutura();
            System.out.println();
        }

        System.out.println("EXERCICIO 3: {50, 30, 70, 20, 40, 60}");
        ArvoreAVL ex3 = new ArvoreAVL();
        int[] seq3 = {50, 30, 70, 20, 40, 60};
        for (int i = 0; i < 6; i++) {
            ex3.inserir(seq3[i]);
        }
        ex3.imprimirEstrutura();
        System.out.println();
        System.out.println("Remover 60: " + ex3.remover(60));
        ex3.imprimirEstrutura();
        System.out.println();
        System.out.println("Remover 20: " + ex3.remover(20));
        ex3.imprimirEstrutura();
        System.out.println();

        System.out.println("TRAVESSIAS");
        System.out.print("Pre-ordem: ");
        ex3.preOrdem();
        System.out.print("Em ordem:  ");
        ex3.emOrdem();
        System.out.print("Pos-ordem: ");
        ex3.posOrdem();
        System.out.println();

        System.out.println("BUSCA");
        System.out.println("Buscar 40: " + (ex3.buscar(40) ? "encontrado" : "nao encontrado"));
        System.out.println("Buscar 99: " + (ex3.buscar(99) ? "encontrado" : "nao encontrado"));
        System.out.println("Remover 99: " + ex3.remover(99));
        System.out.println();

        System.out.println("DUPLICADO IGNORADO");
        ex3.inserir(40);
        System.out.print("Em ordem apos inserir 40 de novo: ");
        ex3.emOrdem();
        System.out.println();

        System.out.println("REMOCAO COM ROTACAO SIMPLES (filho com FB=0)");
        ArvoreAVL r1 = new ArvoreAVL();
        int[] seq5 = {50, 30, 70, 20, 40};
        for (int i = 0; i < 5; i++) {
            r1.inserir(seq5[i]);
        }
        r1.imprimirEstrutura();
        System.out.println("Remover 70: " + r1.remover(70));
        r1.imprimirEstrutura();
        System.out.println("Balanceada: " + r1.estaBalanceada());
        System.out.println();

        System.out.println("REMOCAO COM ROTACAO DUPLA");
        ArvoreAVL r2 = new ArvoreAVL();
        int[] seq6 = {50, 30, 70, 40};
        for (int i = 0; i < 4; i++) {
            r2.inserir(seq6[i]);
        }
        r2.imprimirEstrutura();
        System.out.println("Remover 70: " + r2.remover(70));
        r2.imprimirEstrutura();
        System.out.println("Balanceada: " + r2.estaBalanceada());
        System.out.println();

        System.out.println("SEQUENCIA ORDENADA (a que degenerava na ABB)");
        ArvoreAVL ordenada = new ArvoreAVL();
        int[] seq4 = {30, 47, 86, 95, 115, 130, 138, 159, 166, 184, 206, 212, 219, 224, 237, 258, 296, 307, 314};
        for (int i = 0; i < 19; i++) {
            ordenada.inserir(seq4[i]);
        }
        ordenada.imprimirEstrutura();
        System.out.println("Altura: " + ordenada.altura() + " (com 19 nos)");
        System.out.println("Balanceada: " + ordenada.estaBalanceada());
    }
}
