import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ArvoreNaria {
    public static class Node {
        public int val;
        public List<Node> filhos;

        Node (int v) {
            this.val = v;
            this.filhos = new ArrayList<Node>();
        }
    }

    public static List<List<Integer>> ordemNivel(Node root) {
        List<List<Integer>> resultado = new ArrayList<List<Integer>>();
        if (root == null) {
            return resultado;
        }

        Queue<Node> fila = new LinkedList<Node>();
        fila.add(root);

        while (!fila.isEmpty()) {
            int tamanho = fila.size();
            List<Integer> nivel = new ArrayList<Integer>();

            for (int i = 0; i < tamanho; i++) {
                Node atual = fila.poll();
                if (atual == null) continue;
                nivel.add(atual.val);
                if (atual.filhos != null){
                    for (Node f : atual.filhos){
                        fila.add(f);
                    }
                }
            }
            resultado.add(nivel);
        }
        return resultado;
    }

    //Teste

    public static void main(String[] args) {
        Node raiz = new Node(1);
        Node n10 =  new Node(10);
        Node n20 =  new Node(20);
        Node n50 =  new Node(50);
        Node n25 =  new Node(25);
        Node n35 =  new Node(35);

        n20.filhos.add(n25);
        n20.filhos.add(n35);

        raiz.filhos.add(n10);
        raiz.filhos.add(n20);
        raiz.filhos.add(n50);

        System.out.println(ordemNivel(raiz));
    }
}