class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    int res;
    ListNode left;

    public int pairSum(ListNode head) {
        left = head;
        dfs(head);
        return res;
    }

    private void dfs(ListNode right) {
        if (right.next != null)
            dfs(right.next);
        res = Math.max(res, left.val + right.val);
        left = left.next;
    }
}

class TestMaxTwinSum {
    private static ListNode build(int[] arr) {
        if (arr.length == 0) return null;
        ListNode head = new ListNode(arr[0]);
        ListNode cur = head;
        for (int i = 1; i < arr.length; i++) {
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
        return head;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // Example 1
        ListNode h1 = build(new int[]{5,4,2,1});
        int out1 = sol.pairSum(h1);
        System.out.println("Example 1: head=[5,4,2,1]");
        System.out.println("Output: " + out1);
        System.out.println("Expected: 6");
        System.out.println();

        // Example 2
        ListNode h2 = build(new int[]{4,2,2,3});
        int out2 = sol.pairSum(h2);
        System.out.println("Example 2: head=[4,2,2,3]");
        System.out.println("Output: " + out2);
        System.out.println("Expected: 7");
        System.out.println();

        // Example 3
        ListNode h3 = build(new int[]{1,100000});
        int out3 = sol.pairSum(h3);
        System.out.println("Example 3: head=[1,100000]");
        System.out.println("Output: " + out3);
        System.out.println("Expected: 100001");
    }
}