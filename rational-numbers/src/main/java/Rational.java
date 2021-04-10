public class Rational {

    private int numerator;
    private int denominator;

    Rational(int numerator, int denominator) {
        
        int gcd = gcd(Math.abs(numerator), denominator);
        this.numerator = numerator / gcd;
        this.denominator = denominator / gcd;

        if (this.denominator < 0) {
            this.numerator *= -1; 
            this.denominator *= -1;
		}
    }

    int getNumerator() {
        return this.numerator;
    }

    int getDenominator() {
        return this.denominator;
    }
    
    public Rational add(Rational r) {
        return new Rational(numerator * r.denominator 
                            + r.numerator * denominator, 
                            denominator * r.denominator);
    }

    public Rational subtract(Rational r) {
        return new Rational(numerator * r.denominator - 
                            r.numerator * denominator, 
                            denominator * r.denominator);
    }

    public Rational multiply(Rational r) {
        return new Rational(numerator * r.numerator, 
                            denominator * r.denominator);
	}
    
    public Rational divide(Rational r) {
        return new Rational(numerator * r.denominator, 
                            denominator * r.numerator);
    }
    
    public Rational abs() {
        return new Rational(Math.abs(numerator), 
                            Math.abs(denominator));
    }
    
    public Rational pow(int exponent) {
        return new Rational((int) Math.pow(this.numerator, 
                                           Math.abs(exponent)), 
                            (int) Math.pow(this.denominator, 
                                           Math.abs(exponent)));
    }

    public double exp(double base) {
        return Math.pow(Math.pow(base, 1.0 / denominator), 
                                 numerator);
	}

    private static int gcd(int n1, int n2) {
        return n2 == 0 ? n1 : gcd(n2, n1 % n2);
    }

    @Override
    public String toString() {
        return String.format("%d/%d", 
                             this.getNumerator(), 
                             this.getDenominator());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || 
           !this.getClass()
                .isAssignableFrom(obj.getClass())) {
            return false;
        }

        Rational other = (Rational) obj;
        return this.getNumerator() == other.getNumerator() && 
               this.getDenominator() == other.getDenominator();
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int result = 1;
        result = prime * result + this.getNumerator();
        result = prime * result + this.getDenominator();

        return result;
    }

}
