class Solution {
    public long largestSquareArea(int[][] bl, int[][] tr) {
        long s = 0;
        int n = bl.length;
        
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int minX = Math.max(bl[i][0], bl[j][0]);
                int maxX = Math.min(tr[i][0], tr[j][0]);
                int minY = Math.max(bl[i][1], bl[j][1]);
                int maxY = Math.min(tr[i][1], tr[j][1]);
                
                if (minX < maxX && minY < maxY) {
                    int length = Math.min(maxX - minX, maxY - minY);
                    s = Math.max(s, length);
                }
            }
        }
        
        return s * s;
    }

    // Test cases
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test case 1
        int[][] bottomLeft1 = {{1,1},{2,2},{3,1}};
        int[][] topRight1 = {{3,3},{4,4},{6,6}};
        long output1 = solution.largestSquareArea(bottomLeft1, topRight1);
        System.out.println("Test 1: bottomLeft = [[1,1],[2,2],[3,1]], topRight = [[3,3],[4,4],[6,6]]");
        System.out.println("Output: " + output1 + ", Expected: 1");
        
        // Test case 2
        int[][] bottomLeft2 = {{1,1},{1,3},{1,5}};
        int[][] topRight2 = {{5,5},{5,7},{5,9}};
        long output2 = solution.largestSquareArea(bottomLeft2, topRight2);
        System.out.println("Test 2: bottomLeft = [[1,1],[1,3],[1,5]], topRight = [[5,5],[5,7],[5,9]]");
        System.out.println("Output: " + output2 + ", Expected: 4");
        
        // Test case 3
        int[][] bottomLeft3 = {{1,1},{2,2},{1,2}};
        int[][] topRight3 = {{3,3},{4,4},{3,4}};
        long output3 = solution.largestSquareArea(bottomLeft3, topRight3);
        System.out.println("Test 3: bottomLeft = [[1,1],[2,2],[1,2]], topRight = [[3,3],[4,4],[3,4]]");
        System.out.println("Output: " + output3 + ", Expected: 1");
        
        // Test case 4
        int[][] bottomLeft4 = {{1,1},{3,3},{3,1}};
        int[][] topRight4 = {{2,2},{4,4},{4,2}};
        long output4 = solution.largestSquareArea(bottomLeft4, topRight4);
        System.out.println("Test 4: bottomLeft = [[1,1],[3,3],[3,1]], topRight = [[2,2],[4,4],[4,2]]");
        System.out.println("Output: " + output4 + ", Expected: 0");
        
        System.out.println("\nTest cases executed!");
    }
}
