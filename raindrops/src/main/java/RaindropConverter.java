class RaindropConverter {

    String convert(int number) {

        String raindropSounds = "";

        if (number % 3 == 0) {
            raindropSounds += "Pling";
        }

        if (number % 5 == 0) {
            raindropSounds += "Plang";
        }

        if (number % 7 == 0) {
            raindropSounds += "Plong";
        }

        if (number % 3 != 0 && number % 5 != 0 && number % 7 != 0) {
            raindropSounds += number;
        }

        return raindropSounds;
    }

}
