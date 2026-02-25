class Solution {
    public int[] sortByBits(int[] arr) {
        Integer[] boxedarr = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) {
            boxedarr[i] = arr[i];
        }
        
        java.util.Arrays.sort(boxedarr, (a, b) -> {
            int counta = Integer.bitCount(a);
            int countb = Integer.bitCount(b);
            if (counta == countb) {
                return a.compareTo(b);
            }
            return Integer.compare(counta, countb);
        });
        
        for (int i = 0; i < arr.length; i++) {
            arr[i] = boxedarr[i];
        }
        return arr;
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        // Example 1:
        int[] arr1 = {0,1,2,3,4,5,6,7,8};
        int[] output1 = sol.sortByBits(arr1);
        System.out.println("Example 1: Input: arr = [0,1,2,3,4,5,6,7,8]");
        System.out.print("Output: [");
        for (int i = 0; i < output1.length; i++) {
            System.out.print(output1[i]);
            if (i < output1.length - 1) System.out.print(",");
        }
        System.out.println("]");
        System.out.println("Expected: [0,1,2,4,8,3,5,6,7]");
        System.out.println();
        
        // Example 2:
        int[] arr2 = {1024,512,256,128,64,32,16,8,4,2,1};
        int[] output2 = sol.sortByBits(arr2);
        System.out.println("Example 2: Input: arr = [1024,512,256,128,64,32,16,8,4,2,1]");
        System.out.print("Output: [");
        for (int i = 0; i < output2.length; i++) {
            System.out.print(output2[i]);
            if (i < output2.length - 1) System.out.print(",");
        }
        System.out.println("]");
        System.out.println("Expected: [1,2,4,8,16,32,64,128,256,512,1024]");
    }
}