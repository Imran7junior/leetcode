import java.util.*;

class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;
        Integer[] indices = new Integer[n];
        for (int i = 0; i < n; i++)
            indices[i] = i;

        Arrays.sort(indices, (a, b) -> positions[a] - positions[b]);

        int[] st = new int[n];
        int top = -1;

        for (int idx : indices) {
            if (directions.charAt(idx) == 'R') {
                st[++top] = idx; // push right-moving robot
            } else {
                while (top >= 0 && healths[idx] > 0) {
                    int rightRobot = st[top]; // peek top
                    if (healths[rightRobot] < healths[idx]) {
                        healths[rightRobot] = 0;
                        healths[idx]--;
                        top--; // pop
                    } else if (healths[rightRobot] > healths[idx]) {
                        healths[idx] = 0;
                        healths[rightRobot]--;
                    } else {
                        healths[rightRobot] = 0;
                        healths[idx] = 0;
                        top--; // pop
                    }
                }
            }
        }

        // Collect survivors from healths array
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (healths[i] > 0)
                result.add(healths[i]);
        }
        return result;
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        // Example 1
        int[] positions1 = {5,4,3,2,1};
        int[] healths1 = {2,17,9,15,10};
        String directions1 = "RRRRR";
        List<Integer> output1 = sol.survivedRobotsHealths(positions1, healths1, directions1);
        System.out.println("Example 1: positions=[5,4,3,2,1], healths=[2,17,9,15,10], directions=\"RRRRR\"");
        System.out.println("Output: " + output1);
        System.out.println("Expected: [2,17,9,15,10]");
        System.out.println();
        
        // Example 2
        int[] positions2 = {3,5,2,6};
        int[] healths2 = {10,10,15,12};
        String directions2 = "RLRL";
        List<Integer> output2 = sol.survivedRobotsHealths(positions2, healths2, directions2);
        System.out.println("Example 2: positions=[3,5,2,6], healths=[10,10,15,12], directions=\"RLRL\"");
        System.out.println("Output: " + output2);
        System.out.println("Expected: [14]");
        System.out.println();
        
        // Example 3
        int[] positions3 = {1,2,5,6};
        int[] healths3 = {10,10,11,11};
        String directions3 = "RLRL";
        List<Integer> output3 = sol.survivedRobotsHealths(positions3, healths3, directions3);
        System.out.println("Example 3: positions=[1,2,5,6], healths=[10,10,11,11], directions=\"RLRL\"");
        System.out.println("Output: " + output3);
        System.out.println("Expected: []");
    }
}