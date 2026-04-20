class Solution {
    static public int maxDistance(int[] colors) {
        final int n=colors.length;
        final int c0=colors[0], cN=colors[n-1];
        int lMax=0, rMax=0;
        for(int i=0; i<n; i++){
            final int c=colors[i];
            if (c0!=c && i>lMax) lMax=i;
            if (cN!=c && n-1-i>rMax) rMax=n-1-i;
        }
        return Math.max(lMax, rMax);
    }
    
    public static void main(String[] args) {
        // Example 1
        int[] colors1 = {1,1,1,6,1,1,1};
        int output1 = maxDistance(colors1);
        System.out.println("Example 1: colors=[1,1,1,6,1,1,1]");
        System.out.println("Output: " + output1);
        System.out.println("Expected: 3");
        System.out.println();
        
        // Example 2
        int[] colors2 = {1,8,3,8,3};
        int output2 = maxDistance(colors2);
        System.out.println("Example 2: colors=[1,8,3,8,3]");
        System.out.println("Output: " + output2);
        System.out.println("Expected: 4");
        System.out.println();
        
        // Example 3
        int[] colors3 = {0,1};
        int output3 = maxDistance(colors3);
        System.out.println("Example 3: colors=[0,1]");
        System.out.println("Output: " + output3);
        System.out.println("Expected: 1");
    }
}