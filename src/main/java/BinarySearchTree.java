
/**
 * A class representing a Binary Search Tree (BST) data structure.
 */
class BinarySearchTree {
    Node root;

    /**
     * Constructs an empty Binary Search Tree.
     */
    BinarySearchTree() {
        root = null;
    }

    /**
     * Inserts a new value into the Binary Search Tree.
     *
     * @param value The value to be inserted.
     */
    void insert(int value) {
        Node newNode = new Node(value);

        if (root == null) {
            root = newNode;
            return;
        }

        Node current = root;
        Node parent = null;

        while (current != null) {
            parent = current;

            if (value < current.value) {
                current = current.left;
            } else {
                current = current.right;
            }
        }

        if (value < parent.value) {
            parent.left = newNode;
        } else {
            parent.right = newNode;
        }
    }

    /**
     * Searches for a value in the Binary Search Tree.
     *
     * @param value The value to be searched.
     * @return true if the value is found, false otherwise.
     */
    boolean search(int value) {
        Node current = root;
        while (current != null) {
            if (value == current.value) {
                return true;
            } else if (value < current.value) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        return false;
    }

    /**
     * Removes a value from the Binary Search Tree.
     *
     * @param value The value to be removed.
     */
    void remove(int value) {
        Node parent = null;
        Node current = root;
        // Find the node to be removed and its parent
        while (current != null && current.value != value) {
            parent = current;
            if (value < current.value) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        // If the value is not found, return
        if (current == null) {
            return;
        }

        // Case 1: Leaf node (no children)
        if (current.left == null && current.right == null) {
            if (parent == null) {
                root = null;
            } else if (parent.left == current) {
                parent.left = null;
            } else {
                parent.right = null;
            }
        }
        // Case 2: Single child (left child)
        else if (current.left == null) {
            if (parent == null) {
                root = current.right;
            } else if (parent.left == current) {
                parent.left = current.right;
            } else {
                parent.right = current.right;
            }
        }
        // Case 3: Single child (right child)
        else if (current.right == null) {
            if (parent == null) {
                root = current.left;
            } else if (parent.left == current) {
                parent.left = current.left;
            } else {
                parent.right = current.left;
            }
        }
        // Case 4: Two children
        else {
            Node successor = null;
            Node predecessorParent = current;
            Node predecessor = current.right;

            // Find the in-order predecessor (maximum value in the left subtree)
            while (predecessor.left != null) {
                predecessorParent = predecessor;
                predecessor = predecessor.left;
            }

            // If the predecessor is not the right child of the current node
            if (predecessorParent != current) {
                predecessorParent.left = predecessor.right;
                predecessor.right = current.right;
            }

            // Replace the value of the current node with the predecessor's value
            successor = predecessor;
            successor.left = current.left;

            if (parent == null) {
                root = successor;
            } else if (parent.left == current) {
                parent.left = successor;
            } else {
                parent.right = successor;
            }
        }
    }

    /**
     * Performs an inorder traversal of the Binary Search Tree and prints the values.
     */
    void inorder() {
        Node current = root;
        Node pre;

        while (current != null) {
            if (current.left == null) {
                System.out.print(current.value + " ");
                current = current.right;
            } else {
                pre = current.left;
                while (pre.right != null && pre.right != current) {
                    pre = pre.right;
                }

                if (pre.right == null) {
                    pre.right = current;
                    current = current.left;
                } else {
                    pre.right = null;
                    System.out.print(current.value + " ");
                    current = current.right;
                }
            }
        }
    }
}