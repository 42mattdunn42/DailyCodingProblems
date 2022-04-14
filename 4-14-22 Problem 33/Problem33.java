import java.util.Arrays;
public class Problem33 {

    public static void runningMedian(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            int[] curr = new int[i+1];
            for (int j = 0; j < i+1; j++) {
                curr[j] = arr[j];
            }
            Arrays.sort(curr);
            if(i % 2 == 0){
                System.out.println(curr[(i+1) / 2]);
            }else{
                double ave = ((double)curr[i/2] + curr[(i/2)+1] )/ 2;
                System.out.println(ave);
            }
        }
    }




    public static void main(String[] args) {
        int[] test1 = {2, 1, 5, 7, 2, 0, 5};
        runningMedian(test1);
    }
}