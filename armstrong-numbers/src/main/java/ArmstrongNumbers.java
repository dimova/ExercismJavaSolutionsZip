class ArmstrongNumbers {
    boolean isArmstrongNumber(int numberToCheck) {
        int result = 0; 
        int orig = numberToCheck; 
        while(numberToCheck != 0){ 
            int remainder = numberToCheck%10; 
            result = result + remainder*remainder*remainder;
            numberToCheck = numberToCheck/10; 
        } 
        if(orig == result){ return true; } 
        return false;
    }
}
