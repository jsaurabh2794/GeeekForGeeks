package Tree.Easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Array_to_BST {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        int[] res = sortedArrayToBST(arr);
        Arrays.stream(res).forEach(value -> System.out.print(value + " "));
    }

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

    public static int[] sortedArrayToBST(int[] nums) {
        Node root = constructBST(nums, 0, nums.length - 1);
        List<Integer> finalArray = new ArrayList<>();
        preOrderofTree(root, finalArray);
        int c = 0;
        int arr[] = new int[nums.length];
        for (Integer t : finalArray) {
            arr[c++] = t;
        }
        return arr;
    }

    private static void preOrderofTree(Node root, List<Integer> finalArray) {
        if (root == null) {
            return;
        }
        finalArray.add(root.data);
        preOrderofTree(root.left, finalArray);
        preOrderofTree(root.right, finalArray);
    }

    private static Node constructBST(int[] nums, int l, int r) {
        if (l <= r) {
            int index = l + (r - l) / 2;
            Node newNode = new Node(nums[index]);
            newNode.left = constructBST(nums, l, index - 1);
            newNode.right = constructBST(nums, index + 1, r);
            return newNode;
        }
        return null;
    }


}
