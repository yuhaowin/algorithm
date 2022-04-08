package class14.yuhao;

import java.util.HashMap;
import java.util.List;

/**
 * 并查集
 */
public class UnionFind<V> {

    private HashMap<V, Node<V>> nodes;
    private HashMap<Node<V>, Node<V>> parents;
    private HashMap<Node<V>, Integer> sizeMap;

    public UnionFind(List<V> list) {
        nodes = new HashMap<>();
        parents = new HashMap<>();
        sizeMap = new HashMap<>();
        for (V v : list) {
            Node<V> node = new Node<>(v);
            nodes.put(v, node);
            parents.put(node, node);
            sizeMap.put(node, 1);
        }
    }

    public V findRoot(V v) {
        return findRoot(nodes.get(v)).value;
    }

    public boolean isSameSet(V a, V b) {
        return findRoot(nodes.get(a)) == findRoot(nodes.get(b));
    }

    public void union(V a, V b) {
        Node<V> rootA = findRoot(nodes.get(a));
        Node<V> rootB = findRoot(nodes.get(b));
        if (rootA == rootB) {
            return;
        }
        int aSetSize = sizeMap.get(rootA);
        int bSetSize = sizeMap.get(rootB);
        Node<V> big = aSetSize > bSetSize ? rootA : rootB;
        Node<V> small = aSetSize < bSetSize ? rootA : rootB;
        parents.put(small, big);
        sizeMap.put(big, aSetSize + bSetSize);
        sizeMap.remove(small);
    }

    private Node<V> findRoot(Node<V> node) {
        while (node != parents.get(node)) {
            node = parents.get(node);
        }
        return node;
    }

    //------------------------------------------------------------------------------------------------------------------

    private class Node<V> {
        V value;

        public Node(V v) {
            value = v;
        }
    }
}
