package String.Easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Convert_Ternary_Expression_to_Binary_Tree {
    static class Node {
        char data;
        Node left;
        Node right;

        public Node(char data) {
            this.data = data;
        }
    }

    static class MyReader {
        BufferedReader input;
        StringTokenizer stringTokenizer;

        public MyReader() {
            input = new BufferedReader(new InputStreamReader(System.in));
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public String next() {
            while (stringTokenizer == null || !stringTokenizer.hasMoreTokens()) {
                try {
                    stringTokenizer = new StringTokenizer(input.readLine().trim());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return stringTokenizer.nextToken();
        }
    }

    public static void main(String[] args) {
        MyReader input = new MyReader();
        int testCase = input.nextInt();
        while (testCase-- > 0) {
            String str = input.next();
            Node node = convertTerniaryToBinary(str, 0);
            StringBuilder sb = new StringBuilder("");
            printInorder(node, sb);
            System.out.println(sb);
        }
    }

    private static void printInorder(Node node, StringBuilder sb) {
        if (node == null) {
            return;
        }
        sb.append(node.data + " ");
        printInorder(node.left, sb);
        printInorder(node.right, sb);
    }

    private static Node convertTerniaryToBinary(String str, int pointer) {
        int length = str.length();
        if (pointer > length) {
            return null;
        }
        Node node = new Node(str.charAt(pointer));
        pointer++;
        if (pointer < length && str.charAt(pointer) == '?') {
            node.left = convertTerniaryToBinary(str, ++pointer);
        } else if (pointer < length && str.charAt(pointer) == ':') {
            node.right = convertTerniaryToBinary(str, ++pointer);
        }
        return node;
    }
}
