import java.util.Arrays;
public class Problem4 {

    public static int nextInt(int[] arr){
        Arrays.sort(arr);
        int out = 1;
        for(int i = 0; i < arr.length; i++){
            if(!(arr[i] < 1)){
                if(out < arr[i]){
                    return out;
                }else if(out == arr[i]){
                    out++;
                }

            }
        }
        return out++;
    }

    public static void main(String[] args) {
        int[] test1 = {3, 4, -1, 1}; //should return 2
        System.out.println(nextInt(test1)); //returns 2
        int[] test2 = {1, 2, 0}; //return 3
        System.out.println(nextInt(test2)); //returns 3
    }
}
