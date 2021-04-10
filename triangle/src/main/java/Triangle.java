public class Triangle {
	private enum Type {
		EQUILATERAL,
		ISOSCELES,
		SCALENE
	}

	private Type type;

	public Triangle(double a, double b, double c) throws TriangleException {
		if ((a <= 0 || b <= 0 || c <= 0) || (a + b < c || a + c < b || b + c < a)) {
			throw new TriangleException("Invalid triangle");
		}
		if (a == b && a == c) {
			type = Type.EQUILATERAL;
		} else if (a == b || a == c || b == c) {
			type = Type.ISOSCELES;
		} else {
			type = Type.SCALENE;
		}
	}

	public boolean isEquilateral() {
		return type == Type.EQUILATERAL;
	}

	public boolean isIsosceles() {
		return type == Type.EQUILATERAL || type == Type.ISOSCELES;
	}

	public boolean isScalene() {
		return type == Type.SCALENE;
	}
}
