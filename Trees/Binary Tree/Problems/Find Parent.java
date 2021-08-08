Node findParent(Node localroot, int key) {
		if(localroot==null)
			return null;
		else if(localroot.val==key && localroot==root)
			return root;
		else if(localroot.left!=null && localroot.left.val==key)
			return localroot;
		else if(localroot.right!=null && localroot.right.val==key)
			return localroot;
		else {
			Node left = findParent(localroot.left,key);
			Node right = findParent(localroot.right,key);
			return left!=null ? left : right;
		}
}
