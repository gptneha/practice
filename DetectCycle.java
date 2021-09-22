/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
import java.util.*;
public class Solution {
    public boolean hasCycle(ListNode head) {
        
        if (head == null) {
            return false;
        }
        Map<ListNode, Integer>  result = new HashMap<>();
        
        while (head != null) {
            if (result.containsKey(head)) {
                return true;
            }
            result.put(head, head.val);
            head = head.next;
        }
        return false;
    }
}
