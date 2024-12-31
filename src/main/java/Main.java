public class Main {

  public static void main(String[] args) {
      BinarySearchTree bst = new BinarySearchTree();
      bst.insert(5);
      bst.insert(3);
      bst.insert(7);
      bst.insert(1);
      bst.insert(4);

      System.out.println("Inorder traversal:");
      bst.inorder();

      System.out.println("\n\nSearch for 4: " + bst.search(4));
      System.out.println("Search for 8: " + bst.search(8));

      bst.remove(3);
      System.out.println("\nAfter removing 3:");
      bst.inorder();
  }
}