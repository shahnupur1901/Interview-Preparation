/*
Approach : 
Create 2 lists with new starting nodes, and then use the same nodes of existing lists.
And have their heads and corresponing ptrs.
Then join ptr below to ptrabove's next
Make sure ptrabove's next is null! Else you'll get a cycle
*/
class Solution {
    public ListNode partition(ListNode head, int x) {
    ListNode belowhead = new ListNode(x);
    ListNode abovehead = new ListNode(x);
    ListNode ptrbelow = belowhead;
    ListNode ptrabove = abovehead;
    ListNode ptr = head;
    while(ptr!=null){
        if(ptr.val < x){
            ptrbelow.next = ptr;
            ptrbelow = ptrbelow.next;
        }
        else{
            ptrabove.next = ptr;
            ptrabove = ptrabove.next;
        }
        ptr = ptr.next;
    }
        ptrabove.next = null;
        ptrbelow.next = abovehead.next;
        head = belowhead.next;
        return head;
    }
}
