class Solution {
    public int maxDistance(int side, int[][] points, int k) {
        long[] res = new long[points.length];
        long lSide = (long) side;

        for (int i = 0; i < points.length; i++) {
            long x = points[i][0];
            long y = points[i][1];
            if (x == 0) res[i] = y;
            else if (y == lSide) 
                res[i] = lSide + x;
            else if (x == lSide) 
                res[i] = lSide * 3 - y;
            else res[i] = lSide * 4 - x;
        }
        Arrays.sort(res);

        int left = 1;
        int right = (int) ((lSide * 4) / k) + 1;
        
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (check(mid, res, lSide, k)) 
                left = mid;
            else right = mid;
        }
        return left;
    }

    private boolean check(int n, long[] res, long lSide, int k) {
        int m = res.length;
        int[] idx = new int[k];
        long perimeter = lSide * 4;
        
        idx[0] = 0;
        long curr = res[0];
        for (int i = 1; i < k; i++) {
            int pos = Arrays.binarySearch(res, curr + n);
            if (pos < 0) 
                pos = -(pos + 1);
            if (pos == m) 
                return false;
            idx[i] = pos;
            curr = res[pos];
        }
        
        if (res[idx[k - 1]] - res[0] <= perimeter - n) 
            return true;

        for (idx[0] = 1; idx[0] < idx[1]; idx[0]++) {
            for (int j = 1; j < k; j++) {
                while (idx[j] < m && res[idx[j]] < res[idx[j - 1]] + n) {
                    idx[j]++;
                }
                if (idx[j] == m) 
                    return false;
            }
            if (res[idx[k - 1]] - res[idx[0]] <= perimeter - n) 
                return true;
        }
        return false;
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        // Example 1
        int side1 = 2;
        int[][] points1 = {{0,2},{2,0},{2,2},{0,0}};
        int k1 = 4;
        int output1 = sol.maxDistance(side1, points1, k1);
        System.out.println("Example 1: side=2, points=[[0,2],[2,0],[2,2],[0,0]], k=4");
        System.out.println("Output: " + output1);
        System.out.println("Expected: 2");
        System.out.println();
        
        // Example 2
        int side2 = 2;
        int[][] points2 = {{0,0},{1,2},{2,0},{2,2},{2,1}};
        int k2 = 4;
        int output2 = sol.maxDistance(side2, points2, k2);
        System.out.println("Example 2: side=2, points=[[0,0],[1,2],[2,0],[2,2],[2,1]], k=4");
        System.out.println("Output: " + output2);
        System.out.println("Expected: 1");
        System.out.println();
        
        // Example 3
        int side3 = 2;
        int[][] points3 = {{0,0},{0,1},{0,2},{1,2},{2,0},{2,2},{2,1}};
        int k3 = 5;
        int output3 = sol.maxDistance(side3, points3, k3);
        System.out.println("Example 3: side=2, points=[[0,0],[0,1],[0,2],[1,2],[2,0],[2,2],[2,1]], k=5");
        System.out.println("Output: " + output3);
        System.out.println("Expected: 1");
    }
}