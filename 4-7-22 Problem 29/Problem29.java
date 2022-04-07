public class Problem29{

    public static String runLengthEncoder(String s){
        return "";
    }

    public static String runLengthDecoder(String s){
        if(s.length() < 2){return "";}
        String out = "";
        //This doesn't work if there are more than 9 of a single digit
        for(int i = 0; i < s.length(); i += 2){
            int numChar = Integer.parseInt(s.substring(i, i+1));
            char curr = s.charAt(i+1);
            for(int k = 0; k < numChar; k++){
                out += curr;
            }
        }
        return out;
    }

    public static void main(String args[]){
        String test1 = "4A3B2C1D2A";
        System.out.println(runLengthDecoder(test1));
    }
}