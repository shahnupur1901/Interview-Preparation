	void merge(Node head2) {
		Node ptr = head;
		Node ptrnext = head.next;
		Node ptr2 = head2;
		Node ptr2next = head2.next;
		while(ptr!=null && ptr2!=null) {
			ptr.next = ptr2;
			ptr2.next = ptrnext;
			ptr2 = ptr2next;
			ptr = ptr.next.next;
			if(ptr2next!=null)ptr2next = ptr2next.next;
			if(ptrnext!=null)ptrnext = ptr.next;
		}
	}
