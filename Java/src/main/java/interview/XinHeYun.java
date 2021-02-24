package interview;

import java.util.LinkedList;
import java.util.List;

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

        return HEAD;
    }

    private static void addPath(Node pre, Node next, String unit) {
        Path path = new Path(pre, next, unit, "0");

        pre.addNextPath(path);
        next.addLastPath(path);

    }

    static class Node {
        // 这里暂时不写get、set了
        String name;
        List<Path> nextPath;
        List<Path> lastPath;

        public Node(String name) {
            this.name = name;
        }

        public void addNextPath(Path path) {
            if (nextPath == null) {
                nextPath = new LinkedList<>();
            }
            nextPath.add(path);
        }

        public void addLastPath(Path path) {
            if (lastPath == null) {
                lastPath = new LinkedList<>();
            }
            lastPath.add(path);
        }

        @Override
        public String toString() {
            return "name = " + name +
                    ", pathSize = " + (nextPath == null ? 0 : nextPath.size());
        }
    }

    static class Path {
        Node pre;
        Node next;
        double unit;
        double totalUnit; // 用于计算路径时保存链路的总unit

        public Path(Node pre, Node next, String unit, String totalUnit) {
            this.pre = pre;
            this.next = next;
            this.unit = new Double(unit);
            this.totalUnit = new Double(totalUnit);
        }

        @Override
        public String toString() {
            return "" + pre + " -> " + unit + " -> " + next;
        }
    }

    static class Solution {

        static Node HEAD = new Node("HEAD");
        static Node TAIL = new Node("TAIL");

        public static void main(String[] args) {

            initData(HEAD, TAIL);
            // 默认是无环图
            // 深度优先遍历
            Path path = deepSearch(HEAD);

            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(path).append("\t");

            Path clonePath = path;
            while (true) {
                stringBuilder.append(clonePath.next);
                if (path.next == null || path.next.nextPath == null) {
                    break;
                }

                clonePath = clonePath.next.nextPath.get(0);
            }

            System.out.println(stringBuilder.toString());
        }

        public static Path deepSearch(Node node) {
            System.out.println("traverse " + node.name);
            if (node.nextPath == null) {
                return new Path(null, null, "0", String.valueOf(Integer.MAX_VALUE));
            }

            Path minUnitPath = deepSearch(node.nextPath.get(0).next);
            Path currentPath = null;
            for (int i = 1; i < node.nextPath.size(); i++) {
                Path path = node.nextPath.get(i);
                if (path.next == TAIL) {
                    Path tailPath = new Path(null, null, "0", "0");
                    tailPath.totalUnit = new Double("0");
                    return tailPath;
                }

                currentPath = deepSearch(path.next);
                if (currentPath.totalUnit < minUnitPath.totalUnit) {
                    minUnitPath = currentPath;
                }
            }

            return minUnitPath;
        }
    }
}
