import java.util.Objects;

public class BinaryTree {

	private Zipper root;

	public BinaryTree(final Zipper zipper) {
		this.root = zipper;
	}

	public BinaryTree(final int value) {
		this.root = new Zipper(value);
	}

	public Zipper getRoot() {
		return this.root;
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		BinaryTree that = (BinaryTree) o;
		return Objects.equals(this.root, that.root);
	}

	@Override
	public int hashCode() {
		return Objects.hash(root);
	}

	public String printTree() {
		return root.toString();
	}
}