package interview;

import java.util.LinkedList;
import java.util.List;

/**
 * interview.XinHeYun.Solution#main(java.lang.String[])
 */
public class XinHeYun {
    private static Node initData(Node HEAD, Node TAIL) {

        Node A = new Node("A");
        Node B = new Node("B");
        Node C = new Node("C");
        Node D = new Node("D");
        Node E = new Node("E");
        Node F = new Node("F");
        Node G = new Node("G");
        Node H = new Node("H");
        Node I = new Node("I");
        Node J = new Node("J");


        addPath(HEAD, A, "0.5");
        addPath(A, B, "0.5");
        addPath(B, C, "0.5");
        addPath(C, D, "0.5");
        addPath(D, E, "1");
        addPath(E, TAIL, "0");

        addPath(HEAD, F, "0.5");
        addPath(F, G, "1");
        addPath(G, C, "0.5");

        addPath(HEAD, H, "1");
        addPath(H, I, "1");
        addPath(I, J, "2");
        addPath(J, E, "1");


        // K节点不可达TAIL
        Node K = new Node("K");
        addPath(HEAD, K, "0.01");

        return HEAD;
    }

    private static void addPath(Node pre, Node next, String unit) {
        Path path = new Path(pre, next, unit);
        pre.addNextPath(path);
    }

    static class Solution {

        static Node HEAD = new Node("HEAD");
        static Node TAIL = new Node("TAIL");
        static Node NOT_TAIL = new Node("NOT_TAIL");

        public static void main(String[] args) {

            initData(HEAD, TAIL);
            // 设置一个非TAIL节点, 如果有节点是中断的, 使其通过这条路径到达TAIL
            NOT_TAIL.setQuickestNextNode(new Path(NOT_TAIL, TAIL, String.valueOf(Integer.MAX_VALUE)));
            // 默认是无环图, 深度优先遍历
            traverseQuickestNextNode(HEAD);

            StringBuilder stringBuilder = new StringBuilder();

            Node node = HEAD;
            stringBuilder.append(node.name);
            while (node.quickestPath != null && (node = node.quickestPath.next) != null) {
                stringBuilder.append("->").append(node.name);
            }

            System.out.println(stringBuilder.toString());
        }

        public static Node traverseQuickestNextNode(Node node) {
            if (node.quickestPath != null) {
                return node.quickestPath.next;
            }
            System.out.println("traverse " + node.name);
            List<Path> nextPath = node.nextPath;

            Path shortestCandidate = nextPath.get(0);

            Path path = null;
            // 这里用0是为了让里面的逻辑走一遍
            for (Path value : nextPath) {
                path = value;
                if (path.next == TAIL) {
                    shortestCandidate = path;
                    break;
                }
                if (path.next.nextPath == null) {
                    // 如果出现无法到达TAIL的节点
                    path.next.setQuickestNextNode(new Path(path.next, NOT_TAIL, String.valueOf(Integer.MAX_VALUE)));
                }

                // 当前path长度 + （path终点节点到TAIL的最短路径），即是节点node到TAIL的最短路径
                double current = path.unit + traverseQuickestNextNode(path.next).quickestPathUnit;
                double candidate = shortestCandidate.unit + traverseQuickestNextNode(shortestCandidate.next).quickestPathUnit;
                if (current < candidate) {
                    shortestCandidate = path;
                }
            }

            node.setQuickestNextNode(shortestCandidate);
            return shortestCandidate.next;
        }
    }

    static class Node {
        // 这里暂时不写get、set了
        String name;
        List<Path> nextPath;
        /**
         * 到达TAIL的最短路径中的第一条
         */
        Path quickestPath;
        /**
         * 到达TAIL的最短路径的总长度
         */
        double quickestPathUnit;

        public Node(String name) {
            this.name = name;
        }

        public void addNextPath(Path path) {
            if (nextPath == null) {
                nextPath = new LinkedList<>();
            }
            nextPath.add(path);
        }

        public void setQuickestNextNode(Path path) {
            this.quickestPath = path;
            this.quickestPathUnit = path.unit + path.next.quickestPathUnit;
        }

        @Override
        public String toString() {
            return "name = " + name;
        }
    }

    static class Path {
        Node pre;
        Node next;
        double unit;

        public Path(Node pre, Node next, String unit) {
            this.pre = pre;
            this.next = next;
            this.unit = new Double(unit);
        }

        @Override
        public String toString() {
            return "" + pre + " -> " + unit + " -> " + next;
        }
    }

}