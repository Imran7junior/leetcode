import java.util.*;

class Solution {
    public int mostBooked(int n, int[][] meetings) {
        // Sort meetings by start time
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));

        // Min-heap of available rooms
        PriorityQueue<Integer> available = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            available.offer(i);
        }

        // Min-heap of used rooms: {endTime, room}
        PriorityQueue<long[]> used = new PriorityQueue<>(
            (a, b) -> a[0] == b[0] ? Long.compare(a[1], b[1]) : Long.compare(a[0], b[0])
        );

        int[] count = new int[n];

        for (int[] meeting : meetings) {
            long start = meeting[0];
            long end = meeting[1];

            // Free rooms that have finished by 'start'
            while (!used.isEmpty() && used.peek()[0] <= start) {
                long[] cur = used.poll();
                available.offer((int) cur[1]);
            }

            // If no room available, delay until earliest one frees
            if (available.isEmpty()) {
                long[] cur = used.poll();
                long endTime = cur[0];
                int room = (int) cur[1];
                end = endTime + (end - start);
                start = endTime;
                available.offer(room);
            }

            int room = available.poll();
            used.offer(new long[]{end, room});
            count[room]++;
        }

        // Find room with maximum count
        int ans = 0;
        for (int i = 1; i < n; i++) {
            if (count[i] > count[ans]) {
                ans = i;
            }
        }
        return ans;
    }

    // Test
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.mostBooked(2,
                new int[][]{{0,10},{1,5},{2,7},{3,4}})); // Output: 0
        System.out.println(solution.mostBooked(3,
                new int[][]{{1,20},{2,10},{3,5},{4,9},{6,8}})); // Output: 1
    }
}
