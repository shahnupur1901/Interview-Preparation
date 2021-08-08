	void reverse() {
		Node ptr1 = null;
		Node ptr2 = head;
		Node ptr3 = head.next;
		while(ptr2!=null) {
			ptr2.next = ptr1;
			ptr1 = ptr2;
			ptr2 = ptr3;
			if(ptr3!=null)ptr3 = ptr3.next;
		}
		head = ptr1;
		return;
	}
