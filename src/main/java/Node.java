/**
 * A class representing a node in a Binary Search Tree (BST).
 */
class Node {
    int value;
    Node left;
    Node right;

    /**
     * Constructs a new Node with the given value.
     *
     * @param value The value to be stored in the node.
     */
    Node(int value) {
        this.value = value;
        left = null;
        right = null;
    }
}
