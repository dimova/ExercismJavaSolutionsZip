class ReverseString {

    String reverse(String inputString) {
        if(inputString == null) {
            return inputString;
        }
    
        String output = "";
    
        for (int i = inputString.length() - 1; i >= 0; i--) {
            output = output + inputString.charAt(i);
        }
    
        return output;
    }
  
}
