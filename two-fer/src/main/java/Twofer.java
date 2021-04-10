public class Twofer {
    public String twofer(String name) {
        
        if(isNullOrSpaces(name)){
            name = "you";
        }
        return "One for " + name + ", one for me."; 
    }
     // Method returns true if String is null or empty
    private static boolean isNullOrSpaces(String str){
        if(str == null || str.isBlank())
            return true;
        return false;
    }
}
