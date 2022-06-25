class Solution
{
	public static Node sortedInsert(Node head,int data)
         {
            //add code here.
            Node ptr = head;
            Node x = new Node(data);
          
            while(true){
                if(ptr.next.data >= data && data > head.data){
                    x.next = ptr.next;
                    ptr.next = x;
                    break;
                }
                else if (ptr.next == head && data > ptr.data){
                    ptr.next = x;
                    x.next = head; break;
                }
                 else if (ptr.next == head && data <= head.data){
                    ptr.next = x;
                    x.next = head; 
                    head = x;
                    break;
                }
                ptr = ptr.next;
                
            }
            return head;
         }
}
