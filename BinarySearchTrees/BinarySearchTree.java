
import java.io.*;
import java.util.*;

////////////////////////////////////////////////////////////////
//                                                            //
//             BinarySearchTree class                         //
//                                                            //
////////////////////////////////////////////////////////////////

public class BinarySearchTree {
    // Root of the tree, is null if tree is empty
    private Node root;

    ////////////////////////////////////////////////////////////
    //                                                        //
    //                     Node class                         //
    //                                                        //
    ////////////////////////////////////////////////////////////

    private static class Node {
        Node left;
        Node right;
        int data;

        Node(int data) {
            this.data = data;
        }
    }

    // Returns true if data is in the tree
    // Calls recursive helper
    public boolean contains(int data) {
        return contains(root, data);
    }

    // Recursively look for a given node
    private boolean contains(Node node, int data) {
        if(node == null)
            return false;
        if(data == node.data)
            return true;
        if(data < node.data)
            return contains(node.left, data);
        return contains(node.right, data);
    }

    // Insert given data into the tree
    // Calls recursive helper
    public void insert(int data) {
        root = insert(root, data);
    }

    // Recursively insert the data into the proper spot
    private Node insert(Node node, int data) {
        if(node == null)
            node = new Node(data);
        else if(data <= node.data)
            node.left = insert(node.left, data);
        else
            node.right = insert(node.right, data);
        return node;
    }

    // Returns the number of nodes in the tree
    // Calls recursive helper
    public int size() {
        return size(root);
    }

    // Recursively count the number of nodes in the tree
    private int size(Node node) {
        if(node == null)
            return 0;
        return size(node.left) + 1 + size(node.right);
    }

    // Returns the max root-to-leaf edge count
    // Returns -1 if tree is empty, 0 is tree consists of only the root
    // Calls recursive helper
    public int height() {
        return height(root) - 1;
    }

    // Recursively find the largest root-to-leaf length of the tree
    private int height(Node node) {
        if(node == null)
            return 0;
        
        int lHeight = height(node.left);
        int rHeight = height(node.right);
        return Math.max(lHeight, rHeight) + 1;
    }

    // Returns the min value of a non-empty tree
    // Calls iterative helper
    // Precondition: root != null
    public int min() {
        if(root == null)
            throw new IllegalArgumentException("violation of precondition: root != null");
        return min(root);
    }

    // Iteratively finds the min value of the tree
    private int min(Node node) {
        Node current = node;
        while(current.left != null)
            current = current.left;
        return current.data;
    }

    // Returns the max value of a non-empty tree
    // Calls iterative helper
    // Precondition: root != null
    public int max() {
        if(root == null)
            throw new IllegalArgumentException("violation of precondition: root != null");
        return min(root);
    }

    // Iteratively finds the max value of the tree
    private int max(Node node) {
        Node current = node;
        while(current.right != null)
            current = current.right;
        return current.data;
    }
    
    // Prints tree in the inorder order
    // Calls recrursive helper
    public void printTree() {
        printTree(root);
        System.out.println();
    }

    // Recursively prints the tree traversed in the inorder order
    private void printTree(Node node) {
        if(node == null)
            return;

        printTree(node.left);
        System.out.println(node.data + " ");
        printTree(node.right);
    }

    // Prints tree in the preorder order
    // Calls recrursive helper
    public void printPreorder() {
        printPreorder(root);
        System.out.println();
    }

    // Recursively prints the tree traversed in the preorder order
    private void printPreorder(Node node) {
        if(node == null)
            return;

        System.out.println(node.data + " ");
        printTree(node.left);
        printTree(node.right);
    }

    // Prints tree in the postorder order
    // Calls recrursive helper
    public void printPostorder() {
        printPostorder(root);
        System.out.println();
    }

    // Recursively prints the tree traversed in the postorder order
    private void printPostorder(Node node) {
        if(node == null)
            return;

        printTree(node.left);
        printTree(node.right);
        System.out.println(node.data + " ");
    }

    // Determines whether there exists a path from the root to a leaf with a certain sum
    // Calls recursive helper
    public boolean hasPathSum(int sum) {
        return hasPathSum(root, sum);
    }

    // Recursively subtract the node value from the sum and check for a zero sum when at leaf
    private boolean hasPathSum(Node node, int sum) {
        if(node == null)
           return sum == 0;

        sum -= node.data;
        return hasPathSum(node.left, sum) || hasPathSum(node.right, sum);
    }

    // Print all the root-to-leaf paths
    // Calls recursive helper
    public void printPaths() {
        int[] path = new int[1000];
        printPaths(root, path, 0);
    }

    // Recursively appends the current node to the path and displays if at leaf
    private void printPaths(Node node, int[] path, int pathLength) {
        if(node == null)
            return;

        path[pathLength++] = node.data;

        if(node.left == null && node.right == null)
            printArray(path, pathLength);
        else {
            printPaths(node.left, path, pathLength);
            printPaths(node.right, path, pathLength);
        }
    }

    // Prints the contents of an array from 0 to a given length
    private void printArray(int[] array, int length) {
        for(int i=0; i<length; i++)
            System.out.println(array[i] + " ");
        System.out.println();
    }

    // Changes the tree into its mirror image
    // Calls recursive helper
    public void mirror() {
        mirror(root);
    }

    // Recursively swap left and right children
    private void mirror(Node node) {
        if(node != null) {
            mirror(node.left);
            mirror(node.right);

            Node temp = node.left;
            node.left = node.right;
            node.right = temp;
        }
    }

    // Recursively insert a duplicate node on each node's left
    // Calls recursive helper
    public void doubleTreeLeft() {
        doubleTreeLeft(root);
    }

    // Recursively duplicates node and insert to left of node
    private void doubleTreeLeft(Node node) {
        if(node == null)
            return;

        doubleTreeLeft(node.left);
        doubleTreeLeft(node.right);

        Node oldLeft = node.left;
        node.left = new Node(node.data);
        node.left.left = oldLeft;
    }

    // Recursively insert a duplicate node on each node's right
    // Calls recursive helper
    public void doubleTreeRight() { 
        doubleTreeRight(root);
    }

    // Recursively duplicates node and insert to right of node
    private void doubleTreeRight(Node node) {
        if(node == null)
            return;
        
        doubleTreeRight(node.left);
        doubleTreeRight(node.right);

        Node oldRight = node.right;
        node.right = new Node(node.data);
        node.right.right = oldRight;
    }

    // Determines whether two binary search trees are equal
    // Calls recursive helper
    public boolean isEqual(BinarySearchTree other) {
        return isEqual(root, other.root);
    }

    // Recursively compares the node's data
    private boolean isEqual(Node a, Node b) {
        if(a == null && b == null)
            return true;
        else if(a != null && b != null)
            return a.data == b.data && isEqual(a.left, b.left) && isEqual(a.right, b.right);
        else
            return false;
    }

    // Determines whether the given tree is a subtree
    // Calls recursive helper
    public boolean isSubTree(BinarySearchTree other) {
        return isSubTree(root, other.root);
    }

    // Recursively checks if a subtree exists from roots a and b or a's children
    private boolean isSubTree(Node a, Node b) {
        if(b == null)
            return true;
        if(a == null)
            return false;
        return isEqual(a, b) || isSubTree(a.left,  b) || isSubTree(a.right, b);
    }
}
