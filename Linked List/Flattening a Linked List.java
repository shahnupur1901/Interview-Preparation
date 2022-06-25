class GfG
{
    Node flatten(Node root)
    {
	    if(root.next == null) return root;
	    Node dummy = new Node(0);
	    Node ptr = dummy;
	    Node next = root.next.next;
	    Node ptr1 = root, ptr2 = root.next;
	    while(ptr1!=null && ptr2!=null){
	        if(ptr1.data < ptr2.data){
	            ptr.bottom = ptr1;
	            ptr1 = ptr1.bottom;
	            ptr = ptr.bottom;
	        }
	        else{
	            ptr.bottom = ptr2;
	            ptr2 = ptr2.bottom;
	            ptr = ptr.bottom;
	        }
	    }
	    if(ptr1!=null){
	        ptr.bottom = ptr1;
	    }
	    if(ptr2!=null){
	        ptr.bottom = ptr2;
	    }
	    
	    root = dummy.bottom;
	    dummy.bottom.next = next;
	    return flatten(root);
	    
    }
}
