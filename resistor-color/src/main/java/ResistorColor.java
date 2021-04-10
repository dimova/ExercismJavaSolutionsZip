class ResistorColor {
    int colorCode(String color) {
    
        if (color.equals("Black")){
           return 0;
        } else if(color.equals("Brown")){
           return 1;
        } else if(color.equals("Red")){
           return 2;
        } else if(color.equals("Orange")){
           return 3;
        } else if(color.equals("Yellow")){
           return 4;
        } else if(color.equals("Green")){
           return 5;
        } else if(color.equals("Blue")){
           return 6;
        } else if(color.equals("Violet")){
           return 7;
        } else if(color.equals("Grey")){
           return 8;
        } else if(color.equals("White")){
           return 9;
        }
        return 0;
    }

    String[] colors() {
        String[] myStringColorsArray = {
            "Black",
            "Brown",
            "Red",
            "Orange",
            "Yellow",
            "Green",
            "Blue",
            "Violet",
            "Grey",
            "White"

        };
        return myStringColorsArray;    
    }
}
