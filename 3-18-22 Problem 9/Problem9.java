public class Problem9 {

    public static int largestSumNonAdjacent(int[] arr){
        int total = arr[0];
        
        if(arr.length < 3){
            if(arr[1] > total)
                return arr[1];
            else
                return total;
        }
        
        Boolean[] picked = new Boolean[arr.length];
        for (int i = 0; i < picked.length; i++) {
            picked[i] = false;
        }
        total += arr[2];
        if(arr[1] > total){
            total = arr[1];
            picked[1] = true;
        }else{
            picked[0] = true;
            picked[2] = true;
        }
        
        for(int i = 3; i < arr.length; i++){
            if(arr[i] > 0){
                if(picked[i-1] == false){
                    picked[i] = true;
                    total = sumOfPicked(arr, picked, i);
                }else{
                    picked[i-1] = false; picked[i] = true;
                    int tempTot = sumOfPicked(arr, picked, i);
                    if(total < tempTot){
                        total = tempTot;
                    }else{
                        picked[i-1] = true; picked[i] = false;
                    }
                }
            }
        }
        printPicked(arr, picked);
        return total;
    }
    public static int sumOfPicked(int[] arr, Boolean[] picked, int cap) {
        int sum = 0;
        for (int i = 0; i <= cap; i++) {
            if(picked[i])
                sum += arr[i];
        }
        return sum;
    }
    public static void printPicked(int[] arr, Boolean[] picked){
        for (int i = 0; i < picked.length; i++) {
            if(picked[i])
                System.out.printf("%d, ", arr[i]);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] test0 = {7,6};
        System.out.println(largestSumNonAdjacent(test0));
        int[] test1 = {2, 4, 6, 2, 5};
        System.out.println(largestSumNonAdjacent(test1));
        int[] test2 = {5,1,1,5};
        System.out.println(largestSumNonAdjacent(test2));
        int[] test3 = {2,9,6,1,7,2,8,8,6,1};
        System.out.println(largestSumNonAdjacent(test3));
        int[] test4 = {29,74,-10,92,-91,65,65,-11,-81,-56,-15,89,70,31,-1};
        System.out.println(largestSumNonAdjacent(test4));
    }
}