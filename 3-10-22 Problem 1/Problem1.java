import java.util.Arrays;
public class Problem1 {
    // Memory Effeciency
    public static boolean twoSum_Mem(int[] arr, int target){
        for(int i = 0; i < arr.length-1; i++){
            for(int k = 1; k < arr.length; k++){
                if(arr[i] + arr[k] == target)
                    return true;
            }
        }
        return false;
    }

    // Pass Effeciency
    public static boolean twoSum_Pass(int[] arr, int target){
        Arrays.sort(arr);
        for (int i = arr.length-1; i > 0; i--) {
            if(Arrays.binarySearch(arr, target-arr[i]) > -1)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] test = {-1,1,17,36,420,69,12,34,56,78,90};
        int tar = -6;
        System.out.println(twoSum_Pass(test, tar));
    }
}