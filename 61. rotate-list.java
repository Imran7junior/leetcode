/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        // Step 1: find length and tail
        int n = 1;
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
            n++;
        }

        // Step 2: reduce k
        k = k % n;
        if (k == 0) {
            return head;
        }

        // Step 3: make circular
        tail.next = head;

        // Step 4: find new tail
        int steps = n - k;
        ListNode newTail = head;
        for (int i = 1; i < steps; i++) {
            newTail = newTail.next;
        }

        // Step 5: break
        ListNode newHead = newTail.next;
        newTail.next = null;

        return newHead;
    }
    
    // Helper function to create linked list from array
    private static ListNode createLinkedList(int[] arr) {
        if (arr.length == 0) return null;
        ListNode head = new ListNode(arr[0]);
        ListNode current = head;
        for (int i = 1; i < arr.length; i++) {
            current.next = new ListNode(arr[i]);
            current = current.next;
        }
        return head;
    }
    
    // Helper function to convert linked list to array
    private static int[] linkedListToArray(ListNode head) {
        java.util.List<Integer> result = new java.util.ArrayList<>();
        ListNode current = head;
        while (current != null) {
            result.add(current.val);
            current = current.next;
        }
        int[] arr = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            arr[i] = result.get(i);
        }
        return arr;
    }
    
    // Test cases
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Example 1
        ListNode head1 = createLinkedList(new int[]{1, 2, 3, 4, 5});
        ListNode result1 = solution.rotateRight(head1, 2);
        int[] output1 = linkedListToArray(result1);
        System.out.println("Example 1: Input: head = [1,2,3,4,5], k = 2");
        System.out.print("Output: [");
        for (int i = 0; i < output1.length; i++) {
            System.out.print(output1[i]);
            if (i < output1.length - 1) System.out.print(",");
        }
        System.out.println("]");
        System.out.println("Expected: [4,5,1,2,3]\n");
        
        // Example 2
        ListNode head2 = createLinkedList(new int[]{0, 1, 2});
        ListNode result2 = solution.rotateRight(head2, 4);
        int[] output2 = linkedListToArray(result2);
        System.out.println("Example 2: Input: head = [0,1,2], k = 4");
        System.out.print("Output: [");
        for (int i = 0; i < output2.length; i++) {
            System.out.print(output2[i]);
            if (i < output2.length - 1) System.out.print(",");
        }
        System.out.println("]");
        System.out.println("Expected: [2,0,1]");
    }
}