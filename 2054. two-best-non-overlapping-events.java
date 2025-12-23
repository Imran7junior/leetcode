import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public int maxTwoEvents(int[][] events) {
        int n = events.length;

        Arrays.sort(events, (a,b) ->  Integer.compare(a[0], b[0]));

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> Integer.compare(a[1], b[1]));

        int prevMax = 0;

        int max = 0;
        
        for(int i = 0; i < n; i++){
            int s = events[i][0];
            int e = events[i][1];
            int v = events[i][2];


            while(!minHeap.isEmpty() && minHeap.peek()[1] < s){
                prevMax = Math.max(prevMax, minHeap.poll()[2]);
            }

            max = Math.max(max, v+prevMax);

            minHeap.offer(events[i]);
        }

        return max;
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] events = {
            {1, 3, 2},
            {4, 5, 2},
            {2, 4, 3}
        };
        System.out.println(sol.maxTwoEvents(events));
    }


}


