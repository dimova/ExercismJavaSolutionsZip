import java.util.Random;

public class Robot {

	String name = "";

	public Robot() {
		this.name = generateName();
	}

	public String getName() {
		return this.name;
	}	

	public void reset() {
		this.name = generateName();
	}

	private String generateName() {
		String generatedName = "";
		String[] allowedChars = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P",
									"Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};

		Random random = new Random();
		for (int a=0; a<2; a++) {
			generatedName += allowedChars[random.nextInt(26)];
		}
		for (int i=0; i<3; i++) {
			generatedName += String.valueOf(random.nextInt(10));
		}
		return generatedName;
	}

}