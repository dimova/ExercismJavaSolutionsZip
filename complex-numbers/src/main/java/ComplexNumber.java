class ComplexNumber {

	private final double real;
	private final double imag;

	public ComplexNumber(final double real, final double imag) {
		this.real = real;
		this.imag = imag;
	}

	double getReal() {
		return this.real;
	}

	double getImag() {
		return this.imag;
	}

	ComplexNumber times(final ComplexNumber complexNumber) {
		return new ComplexNumber(this.real * complexNumber.real - this.imag * complexNumber.imag,
								 this.real * complexNumber.imag + this.imag * complexNumber.real);
	}

	ComplexNumber add(final ComplexNumber complexNumber) {
		return new ComplexNumber(this.real + complexNumber.real, this.imag + complexNumber.imag);
	}

	ComplexNumber minus(final ComplexNumber complexNumber) {
		return new ComplexNumber(this.real - complexNumber.real, this.imag - complexNumber.imag);
	}

	ComplexNumber div(final ComplexNumber complexNumber) {
		final double k = (complexNumber.real * complexNumber.real + complexNumber.imag * complexNumber.imag);
		return new ComplexNumber((this.real * complexNumber.real + this.imag * complexNumber.imag) / k,
								 (this.imag * complexNumber.real - this.real * complexNumber.imag) / k);
	}

	double abs() {
		return Math.hypot(this.real, this.imag);
	}

	ComplexNumber conjugate() {
		return new ComplexNumber(this.real, this.imag * -1);
	}

	ComplexNumber exponentialOf() {
		final double k = Math.exp(this.real);
		return new ComplexNumber(k * Math.cos(this.imag), k * Math.sin(this.imag));
	}
}
