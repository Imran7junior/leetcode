import java.util.Arrays;
class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        // Calculate total apples
        int total = 0;
        for (int a : apple) {
            total += a;
        }
        
        // Sorts in ascending order
        Arrays.sort(capacity);
        
        int cnt = 0;
        // Iterate from the end to pick largest boxes first
        for (int i = capacity.length - 1; i >= 0; i--) {
            total -= capacity[i];
            cnt++;
            if (total <= 0) {
                return cnt;
            }
        }
        return cnt;
    }
	public static void main(String[] args) {
		Solution sol = new Solution();
		int[] apple = {1, 3, 2};
		int[] capacity = {4, 3, 1, 5, 2};
		System.out.println(sol.minimumBoxes(apple, capacity)); // Output: 2
	}
}