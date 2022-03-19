public class Problem7 {

    // Works except for things with "dboules" in a row
    public static int numDecodes(String in){
        String numDecodes = "";
        int binaryRep = 0B0;
        Boolean wasLastValid = false;
        char[] inArr = in.toCharArray();
        for(int i = 1; i < in.length(); i++){
            int curr = Character.getNumericValue(inArr[i-1])*10 + Character.getNumericValue(inArr[i]);
            if(curr < 26){
                numDecodes += "1";
                if(wasLastValid){
                    binaryRep = Integer.parseInt(numDecodes, 2);
                    binaryRep = binaryRep - 0B1;
                    numDecodes = Integer.toString(binaryRep, 2);
                }else{
                    wasLastValid = true;
                }
            }else{
                wasLastValid = false;
            }
        }


        return (int)(Integer.parseInt(numDecodes, 2) + 0b1);
    }

    public static void main(String[] args) {
        String test1 = "111";
        System.out.println(numDecodes(test1));
        String test2 = "111111";
        System.out.println(numDecodes(test2));
        String test3 = "1111";
        System.out.println(numDecodes(test3));
        String test4 = "132511";
        System.out.println(numDecodes(test4));
    }
    
}


//First attempt at numDecodes:
// int numDecodes = 0;
//         int curr = 0;
//         int last = 0;
//         while(in > 0){
//             curr = (int)(in / (Math.pow(10, Integer.toString(in).length() - 1)));
//             in = in / 10;
//             if(curr == 0 && last == 0)
//                 return -1;
//             if(0 < last && last < 3){
//                 numDecodes += 2;
//             }else{
//                 numDecodes++;
//             }
//             last = curr;
//         }
//         return numDecodes;
