import java.util.Arrays;

public class Problem2 {

    public static int[] productArray(int[] arr){
        int[] output = new int[arr.length];
        int totalProduct = 1;
        for (int i = 0; i < arr.length; i++) {
            totalProduct = totalProduct * arr[i];
        }
        for (int i = 0; i < output.length; i++) {
            output[i] = totalProduct / arr[i];
        }
        return output;
    }
    
    public static void main(String[] args) {
        int[] test1 = {1,2,3,4,5};
        test1 = productArray(test1);
        System.out.println(Arrays.toString(test1));

        int[] test2 = {3,2,1};
        test2 = productArray(test2);
        System.out.println(Arrays.toString(test2));
    }
}
