import java.util.Optional;

class Zipper {

	private static final String TEMPLATE = "value: %d, left: %s, right: %s";
	private static final String BRACES = "{ %s }";

	private int value;
	Zipper left;
	Zipper right;
	Zipper up;

	public Zipper(final int value) {
		this.value = value;
	}

	public int getValue() {
		return this.value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public void setLeft(final Zipper left) {
		this.left = left;
		if (left != null) {
			left.up = this;
		}
	}

	public void setRight(final Zipper right) {
		this.right = right;
		if (right != null) {
			right.up = this;
		}
	}

	public BinaryTree toTree() {
		return toTree(this);
	}

	private BinaryTree toTree(final Zipper zipper) {
		return zipper.up == null ? new BinaryTree(zipper) : this.toTree(zipper.up);
	}

	@Override
	public String toString() {
		return this.toString(this);
	}

	private String toString(final Zipper zipper) {
		return String.format(TEMPLATE,
							 zipper.value,
							 this.toStringWithBraces(zipper.left),
							 this.toStringWithBraces(zipper.right));
	}

	private String toStringWithBraces(final Zipper zipper) {
		return Optional.ofNullable(zipper)
			.map(z -> String.format(BRACES, this.toString(z)))
			.orElse("null");
	}
}