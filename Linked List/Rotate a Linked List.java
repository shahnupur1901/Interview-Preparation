class Solution{
    //Function to rotate a linked list.
    public Node rotate(Node head, int k) {
        Node fast = head, slow = head;k--;
        while(k>0 && fast!=null){
            fast = fast.next;k--;
        }
       //System.out.println(fast.data);
       if(fast.next==null) return head;
        Node newhead = fast.next;
        fast.next = null;
        Node ptr = newhead;
        while(ptr.next!=null){
            ptr = ptr.next;
        }
        ptr.next = head;
        return newhead;
        
    }
  
}
