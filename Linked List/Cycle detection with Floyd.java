public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
		ListNode slow = head;
		while(fast!=null && slow!=null) {
			if(fast.next!=null) {
				fast = fast.next.next;
			}
			else return null;
			slow = slow.next;
            if(slow==null || fast==null) return null;
			if(slow==fast)
				break;
		}
        ListNode ptr = head;
        while(ptr!=slow){
            ptr = ptr.next;
            slow = slow.next;
        }
        return ptr;
        
    }
 
}
