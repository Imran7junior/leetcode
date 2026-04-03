class Solution {
    public int maxWalls(int[] robots, int[] distance, int[] walls) {
        int n = robots.length;
        int[][] arr = new int[n][2];
        
        for (int i = 0; i < n; i++) {
            arr[i][0] = robots[i];
            arr[i][1] = distance[i];
        }
        
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));
        Arrays.sort(walls);
        
        int exactWalls = 0;
        for (int i = 0; i < n; i++) {
            if (Arrays.binarySearch(walls, arr[i][0]) >= 0) {
                exactWalls++;
            }
        }
        
        int[][] dp = new int[n][2];
        dp[0][0] = countW(walls, arr[0][0] - arr[0][1], arr[0][0] - 1);
        dp[0][1] = 0;
        
        for (int i = 1; i < n; i++) {
            int pPrev = arr[i - 1][0];
            int dPrev = arr[i - 1][1];
            int pCurr = arr[i][0];
            int dCurr = arr[i][1];
            
            int aStart = pPrev + 1;
            int aEnd = Math.min(pCurr - 1, pPrev + dPrev);
            int cA = countW(walls, aStart, aEnd);
            
            int bStart = Math.max(pPrev + 1, pCurr - dCurr);
            int bEnd = pCurr - 1;
            int cB = countW(walls, bStart, bEnd);
            
            int cBoth = countW(walls, bStart, aEnd);
            int unionCount = cA + cB - cBoth;
            
            dp[i][0] = Math.max(dp[i - 1][0] + cB, dp[i - 1][1] + unionCount);
            dp[i][1] = Math.max(dp[i - 1][0], dp[i - 1][1] + cA);
        }
        
        int lastRight = countW(walls, arr[n - 1][0] + 1, arr[n - 1][0] + arr[n - 1][1]);
        int maxDestroyed = Math.max(dp[n - 1][0], dp[n - 1][1] + lastRight);
        
        return maxDestroyed + exactWalls;
    }
    
    private int countW(int[] arr, int l, int r) {
        if (l > r) return 0;
        int leftIdx = getL(arr, l);
        int rightIdx = getU(arr, r) - 1;
        return Math.max(0, rightIdx - leftIdx + 1);
    }
    
    private int getL(int[] arr, int target) {
        int l = 0, r = arr.length - 1;
        int ans = arr.length;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] >= target) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }
    
    private int getU(int[] arr, int target) {
        int l = 0, r = arr.length - 1;
        int ans = arr.length;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] > target) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }
    
    // Test cases
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Example 1
        int[] robots1 = {4};
        int[] distance1 = {3};
        int[] walls1 = {1, 10};
        int result1 = solution.maxWalls(robots1, distance1, walls1);
        System.out.println("Example 1: Input: robots = [4], distance = [3], walls = [1, 10]");
        System.out.println("Output: " + result1);
        System.out.println("Expected: 1\n");
        
        // Example 2
        int[] robots2 = {10, 2};
        int[] distance2 = {5, 1};
        int[] walls2 = {5, 2, 7};
        int result2 = solution.maxWalls(robots2, distance2, walls2);
        System.out.println("Example 2: Input: robots = [10, 2], distance = [5, 1], walls = [5, 2, 7]");
        System.out.println("Output: " + result2);
        System.out.println("Expected: 3\n");
        
        // Example 3
        int[] robots3 = {1, 2};
        int[] distance3 = {100, 1};
        int[] walls3 = {10};
        int result3 = solution.maxWalls(robots3, distance3, walls3);
        System.out.println("Example 3: Input: robots = [1, 2], distance = [100, 1], walls = [10]");
        System.out.println("Output: " + result3);
        System.out.println("Expected: 0");
    }
}