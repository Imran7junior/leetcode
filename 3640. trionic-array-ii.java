class Solution {
    public int maxSumTrionic(int[] A) {
        int n = A.length;
        long neg = -(1L << 50);
        long ans = neg;
        
        int i = 0, l = 0, p = 0, q = 0, r = 0;
        while (i < n - 1) {
            // Find l set Sum=0
            while (i < n - 1 && A[i] >= A[i + 1]) i++;
            l = i;
            long Sum = 0;
            
            // 1st uphill & find p, if p==l skip the rest
            while (i < n - 1 && A[i] < A[i + 1]) {
                int x = A[i];
                Sum += (x > 0 ? x : 0);
                i++;
            }
            p = i;
            if (p == l || (p + 1 < n && A[p] == A[p + 1])) continue;
            if (A[p - 1] < 0) Sum += A[p - 1];
            
            // 1st downhill & find q, if q==p skip the rest
            while (i < n - 1 && A[i] > A[i + 1]) {
                Sum += A[i];
                i++;
            }
            q = i;
            if (q == p || (q + 1 < n && A[q] == A[q + 1])) continue;
            
            // 2nd uphill & find r, if r>q update ans with Sum, back to i=q
            Sum += A[q];
            long inc = 0, maxInc = neg;
            while (i < n - 1 && A[i] < A[i + 1]) {
                inc += A[i + 1];
                maxInc = Math.max(maxInc, inc);
                i++;
            }
            r = i;
            if (r > q) {
                ans = Math.max(ans, Sum + maxInc);
                i = q;
            }
            i += (l == i ? 1 : 0);
        }
        
        return (int) ans;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        
        // Example 1
        int[] nums1 = {0, -2, -1, -3, 0, 2, -1};
        System.out.println(sol.maxSumTrionic(nums1));  // Expected: -4
        
        // Example 2
        int[] nums2 = {1, 4, 2, 7};
        System.out.println(sol.maxSumTrionic(nums2));  // Expected: 14
    }
}
