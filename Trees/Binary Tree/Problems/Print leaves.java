int printleaves(Node localroot) {
		if(localroot==null)
			return 0;
		if(localroot.left==null && localroot.right==null) {
			System.out.print("Leaf : "+localroot.val);
			return 1;
		}
		else {
			return printleaves(localroot.left) + printleaves(localroot.right);
		}
}
