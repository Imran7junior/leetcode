import java.util.*;

class Solution {
    public double separateSquares(int[][] squares) {
        Map<Integer, Integer> axis = new HashMap<>();
        int total = 0;
        
        for (int[] square : squares) {
            int y = square[1];
            int s = square[2];
            int area = s * s;
            total += area;
            axis.put(y, axis.getOrDefault(y, 0) + s);
            axis.put(y + s, axis.getOrDefault(y + s, 0) - s);
        }
        
        double target = total / 2.0;
        
        List<Map.Entry<Integer, Integer>> events = new ArrayList<>(axis.entrySet());
        Collections.sort(events, Map.Entry.comparingByKey());
        
        int cur = 0;
        int last_y = events.get(0).getKey() - 1;
        
        for (Map.Entry<Integer, Integer> entry : events) {
            int y = entry.getKey();
            int a_unit = entry.getValue();
            int dy = y - last_y;
            double nar = cur * dy;
            
            if (target - nar <= 0) {
                return last_y + (target / nar) * dy;
            }
            
            target -= nar;
            cur += a_unit;
            last_y = y;
        }
        
        return 0.0;
    }

    // Test cases
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test case 1
        int[][] squares1 = {{0,0,1},{2,2,1}};
        double output1 = solution.separateSquares(squares1);
        System.out.println("Test 1: squares = [[0,0,1],[2,2,1]]");
        System.out.printf("Output: %.5f, Expected: 1.00000%n", output1);
        
        // Test case 2
        int[][] squares2 = {{0,0,2},{1,1,1}};
        double output2 = solution.separateSquares(squares2);
        System.out.println("Test 2: squares = [[0,0,2],[1,1,1]]");
        System.out.printf("Output: %.5f, Expected: 1.16667%n", output2);
        
        System.out.println("\nTest cases executed!");
    }
}
