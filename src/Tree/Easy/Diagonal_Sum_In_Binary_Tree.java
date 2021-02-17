package Tree.Easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Diagonal_Sum_In_Binary_Tree {
    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }

        public Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        System.out.println(diagOnalSumOfBTree(root));
    }

    private static ArrayList<Integer> diagOnalSumOfBTree(Node root) {
        Map<Integer, Integer> diagonalSumMap = new HashMap<>();
        ArrayList<Integer> diagonalSum = new ArrayList<>();
        getDiagonalSum(root, diagonalSumMap, 0);
        for (Map.Entry<Integer, Integer> entry : diagonalSumMap.entrySet()) {
            diagonalSum.add(entry.getValue());
        }
        return diagonalSum;
    }

    //Put root distance as 0 and make Right child as parent  and left as parent+1.
    private static void getDiagonalSum(Node node, Map<Integer, Integer> diagonalSumMap, int daigonalDistance) {
        if (node == null) {
            return;
        }
        diagonalSumMap.put(daigonalDistance, diagonalSumMap.getOrDefault(daigonalDistance, 0) + node.data);
        getDiagonalSum(node.right, diagonalSumMap, daigonalDistance);
        getDiagonalSum(node.left, diagonalSumMap, daigonalDistance + 1);
    }
}
