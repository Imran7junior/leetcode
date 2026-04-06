import java.util.*;

class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        // Store obstacles
        Set<String> blocked = new HashSet<>();
        for (int[] o : obstacles) {
            blocked.add(o[0] + "," + o[1]);
        }

        // Directions: North, East, South, West
        int[][] directions = {
            {0, 1}, {1, 0}, {0, -1}, {-1, 0}
        };

        int x = 0, y = 0;
        int dir = 0; // initially facing North
        int maxDist = 0;

        for (int cmd : commands) {
            if (cmd == -1) {
                dir = (dir + 1) % 4; // turn right
            } 
            else if (cmd == -2) {
                dir = (dir + 3) % 4; // turn left
            } 
            else {
                while (cmd-- > 0) {
                    int nx = x + directions[dir][0];
                    int ny = y + directions[dir][1];

                    // check obstacle
                    if (blocked.contains(nx + "," + ny)) break;

                    x = nx;
                    y = ny;

                    maxDist = Math.max(maxDist, x * x + y * y);
                }
            }
        }

        return maxDist;
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        // Example 1
        int[] commands1 = {4,-1,3};
        int[][] obstacles1 = {};
        int output1 = sol.robotSim(commands1, obstacles1);
        System.out.println("Example 1: commands=[4,-1,3], obstacles=[]");
        System.out.println("Output: " + output1);
        System.out.println("Expected: 25");
        System.out.println();
        
        // Example 2
        int[] commands2 = {4,-1,4,-2,4};
        int[][] obstacles2 = {{2,4}};
        int output2 = sol.robotSim(commands2, obstacles2);
        System.out.println("Example 2: commands=[4,-1,4,-2,4], obstacles=[[2,4]]");
        System.out.println("Output: " + output2);
        System.out.println("Expected: 65");
        System.out.println();
        
        // Example 3
        int[] commands3 = {6,-1,-1,6};
        int[][] obstacles3 = {{0,0}};
        int output3 = sol.robotSim(commands3, obstacles3);
        System.out.println("Example 3: commands=[6,-1,-1,6], obstacles=[[0,0]]");
        System.out.println("Output: " + output3);
        System.out.println("Expected: 36");
    }
}