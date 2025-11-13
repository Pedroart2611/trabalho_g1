package Dominio;
import java.util.*;

public class MainLab {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int opcao = -1;

        while (opcao != 0) {

            System.out.println("\n====== MENU PRINCIPAL ======");
            System.out.println("1 - Bloco A (Collections & List)");
            System.out.println("2 - Bloco B (Stack & Queue)");
            System.out.println("3 - Bloco C (Sets & Maps)");
            System.out.println("4 - Bloco D (Listas & Árvore)");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            opcao = sc.nextInt();
            System.out.println();

            switch (opcao) {
                case 1 -> blocoA_CollectionsEList();
                case 2 -> blocoB_StackQueue();
                case 3 -> blocoC_SetsMaps();
                case 4 -> blocoD_ListasEArvore();
                case 0 -> System.out.println("Encerrando...");
                default -> System.out.println("Opção inválida.");
            }
        }

        sc.close();
    }

    private static void blocoA_CollectionsEList() {
        System.out.println("=== Bloco A: Collections & List ===\n");

        System.out.print("Quantos números deseja cadastrar na lista? ");
        int n = sc.nextInt();

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            System.out.print("Digite o número " + (i + 1) + ": ");
            list.add(sc.nextInt());
        }

        System.out.println("Lista inicial: " + list);

        List<Integer> sortedList = new ArrayList<>(list);
        Collections.sort(sortedList);
        System.out.println("Lista ordenada: " + sortedList);

        System.out.print("Digite um número para buscar: ");
        int busca = sc.nextInt();
        int index = Collections.binarySearch(sortedList, busca);
        System.out.println("Índice após binarySearch: " + index);

        Collections.reverse(sortedList);
        System.out.println("Lista após reverse: " + sortedList);

        Collections.shuffle(sortedList);
        System.out.println("Lista após shuffle: " + sortedList);

        System.out.println("\nAgora crie a lista l1:");
        List<String> l1 = new ArrayList<>();
        sc.nextLine();
        System.out.print("Digite palavras separadas por espaço: ");
        l1.addAll(Arrays.asList(sc.nextLine().split(" ")));

        System.out.println("Crie agora a lista l2:");
        List<String> l2 = new ArrayList<>();
        System.out.print("Digite palavras separadas por espaço: ");
        l2.addAll(Arrays.asList(sc.nextLine().split(" ")));

        System.out.println("Lista l1: " + l1);
        System.out.println("Lista l2: " + l2);

        System.out.print("Quantos itens deseja adicionar em l1? ");
        int qtdAdd = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < qtdAdd; i++) {
            System.out.print("Item " + (i + 1) + ": ");
            l1.add(sc.nextLine());
        }

        System.out.println("l1 após addAll: " + l1);

        System.out.print("Digite uma palavra para contar frequência em l1: ");
        String palavra = sc.nextLine();
        int freq = Collections.frequency(l1, palavra);
        System.out.println("Frequência: " + freq);

        boolean disjoint = Collections.disjoint(l1, l2);
        System.out.println("l1 e l2 são disjuntas? " + disjoint);

        System.out.print("Digite números separados por espaço para obter min/max: ");
        List<Integer> nums = new ArrayList<>();
        for (String s : sc.nextLine().split(" ")) nums.add(Integer.parseInt(s));

        System.out.println("Min: " + Collections.min(nums));
        System.out.println("Max: " + Collections.max(nums));

        System.out.println();
    }

    private static void blocoB_StackQueue() {
        System.out.println("=== Bloco B: Stack & Queue ===\n");

        Stack<Integer> stack = new Stack<>();
        System.out.print("Digite valores para a pilha (separe por espaço): ");
        sc.nextLine();
        for (String s : sc.nextLine().split(" ")) stack.push(Integer.parseInt(s));

        System.out.println("Stack inicial: " + stack);
        System.out.println("Pop: " + stack.pop());
        System.out.println("Peek: " + stack.peek());
        System.out.println("Stack final: " + stack + "\n");

        Queue<String> queue = new LinkedList<>();
        System.out.print("Digite nomes para a fila (separe por espaço): ");
        for (String s : sc.nextLine().split(" ")) queue.add(s);

        System.out.println("Queue inicial: " + queue);
        System.out.println("Poll: " + queue.poll());
        System.out.println("Peek: " + queue.peek());
        System.out.println("Queue final: " + queue + "\n");

        PriorityQueue<Tarefa> pq = new PriorityQueue<>();

        System.out.print("Quantas tarefas deseja cadastrar? ");
        int qtd = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < qtd; i++) {
            System.out.print("Nome da tarefa: ");
            String nome = sc.nextLine();

            System.out.print("Prioridade (número): ");
            int prio = sc.nextInt();
            sc.nextLine();

            pq.add(new Tarefa(nome, prio));
        }

        System.out.println("Removendo por prioridade:");
        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
        }

        System.out.println();
    }

    static class Tarefa implements Comparable<Tarefa> {
        String nome;
        int prioridade;
        Tarefa(String nome, int prioridade) {
            this.nome = nome;
            this.prioridade = prioridade;
        }
        public int compareTo(Tarefa o) {
            return Integer.compare(this.prioridade, o.prioridade);
        }
        public String toString() {
            return nome + " (prioridade " + prioridade + ")";
        }
    }

    private static void blocoC_SetsMaps() {
        System.out.println("=== Bloco C: Sets & Maps ===\n");

        System.out.print("Digite palavras com duplicatas (separe por espaço): ");
        sc.nextLine();
        Set<String> conjunto = new HashSet<>(Arrays.asList(sc.nextLine().split(" ")));
        System.out.println("Set sem duplicatas: " + conjunto);

        SortedSet<String> treeSet = new TreeSet<>(conjunto);
        System.out.println("TreeSet ordenado: " + treeSet);

        System.out.print("Digite palavras para contar frequência: ");
        List<String> palavras = Arrays.asList(sc.nextLine().split(" "));
        Map<String, Integer> freq = new HashMap<>();

        for (String p : palavras) {
            freq.put(p, freq.getOrDefault(p, 0) + 1);
        }

        System.out.println("Frequência via HashMap: " + freq);

        SortedMap<String, Integer> sortedFreq = new TreeMap<>(freq);
        System.out.println("Frequência via TreeMap: " + sortedFreq);

        System.out.println();
    }

    private static void blocoD_ListasEArvore() {
        System.out.println("=== Bloco D: Listas & Árvore ===\n");

        LinkedList<String> lista = new LinkedList<>();

        System.out.print("Digite itens para a LinkedList: ");
        for (String s : sc.nextLine().split(" ")) lista.add(s);

        System.out.println("LinkedList inicial: " + lista);

        System.out.print("Digite um item para remover: ");
        String remover = sc.nextLine();
        lista.remove(remover);

        System.out.println("Após remover: " + lista);

        System.out.println("Iteração da lista:");
        for (String s : lista) System.out.println(s);
        System.out.println();

        BSTree<Integer> bst = new BSTree<>();

        System.out.print("Digite números para inserir na árvore: ");
        for (String s : sc.nextLine().split(" ")) bst.insert(Integer.parseInt(s));

        System.out.println("InOrder: " + bst.inOrderTraversal());
        System.out.println("PreOrder: " + bst.preOrderTraversal());
        System.out.println("PostOrder: " + bst.postOrderTraversal());

        System.out.print("Digite um valor para buscar na árvore: ");
        int search = sc.nextInt();
        System.out.println("Existe? " + bst.contains(search));

        System.out.print("Digite um valor para remover: ");
        int rem = sc.nextInt();
        bst.remove(rem);

        System.out.println("InOrder após remoção: " + bst.inOrderTraversal());
        System.out.println();
    }

    static class BSTree<T extends Comparable<T>> {

        class Node {
            T value;
            Node left, right;
            Node(T v) { value = v; }
        }

        private Node root;

        public void insert(T value) {
            root = insertRec(root, value);
        }

        private Node insertRec(Node n, T value) {
            if (n == null) return new Node(value);
            int cmp = value.compareTo(n.value);
            if (cmp < 0) n.left = insertRec(n.left, value);
            else if (cmp > 0) n.right = insertRec(n.right, value);
            return n;
        }

        public boolean contains(T value) {
            Node current = root;
            while (current != null) {
                int cmp = value.compareTo(current.value);
                if (cmp == 0) return true;
                current = (cmp < 0) ? current.left : current.right;
            }
            return false;
        }

        public void remove(T value) {
            root = removeRec(root, value);
        }

        private Node removeRec(Node n, T value) {
            if (n == null) return null;

            int cmp = value.compareTo(n.value);
            if (cmp < 0) n.left = removeRec(n.left, value);
            else if (cmp > 0) n.right = removeRec(n.right, value);
            else {
                if (n.left == null) return n.right;
                if (n.right == null) return n.left;
                Node successor = minNode(n.right);
                n.value = successor.value;
                n.right = removeRec(n.right, successor.value);
            }
            return n;
        }

        private Node minNode(Node n) {
            while (n.left != null) n = n.left;
            return n;
        }

        public List<T> inOrderTraversal() {
            List<T> res = new ArrayList<>();
            inOrder(root, res);
            return res;
        }

        private void inOrder(Node n, List<T> res) {
            if (n == null) return;
            inOrder(n.left, res);
            res.add(n.value);
            inOrder(n.right, res);
        }

        public List<T> preOrderTraversal() {
            List<T> res = new ArrayList<>();
            preOrder(root, res);
            return res;
        }

        private void preOrder(Node n, List<T> res) {
            if (n == null) return;
            res.add(n.value);
            preOrder(n.left, res);
            preOrder(n.right, res);
        }

        public List<T> postOrderTraversal() {
            List<T> res = new ArrayList<>();
            postOrder(root, res);
            return res;
        }

        private void postOrder(Node n, List<T> res) {
            if (n == null) return;
            postOrder(n.left, res);
            postOrder(n.right, res);
            res.add(n.value);
        }
    }
}
