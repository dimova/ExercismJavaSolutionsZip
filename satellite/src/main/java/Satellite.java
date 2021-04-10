import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Satellite {
  public Tree treeFromTraversals(List<Character> preorder, List<Character> inorder) {
    if (preorder.size() != inorder.size()) {
      throw new IllegalArgumentException("traversals must have the same length");
    }

    Set<Character> allChars = new HashSet<>(preorder);
    allChars.addAll(inorder);
    if (allChars.size() < preorder.size()) {
      throw new IllegalArgumentException("traversals must contain unique items");
    }
    if(allChars.size() > preorder.size()) {
      throw new IllegalArgumentException("traversals must have the same elements");
    }

    return new Tree(fromTraversals(preorder, inorder));
  }

  private Node fromTraversals(List<Character> preorder, List<Character> inorder) {
    if (preorder.isEmpty() || inorder.isEmpty()) {
      return null;
    }

    Node root = new Node(preorder.get(0));
    int rootIndex = inorder.indexOf(root.value);

    List<Character> preorderLeft = preorder.subList(1, preorder.size());
    List<Character> preorderRight = preorder.subList(rootIndex + 1, preorder.size());

    List<Character> inorderLeft = inorder.subList(0, rootIndex);
    List<Character> inorderRight = inorder.subList(rootIndex + 1, inorder.size());

    root.left = fromTraversals(preorderLeft, inorderLeft);
    root.right = fromTraversals(preorderRight, inorderRight);

    return root;
  }
}
