/*
Left Subtree elements should be < root
Right Subtree elements should be > root
All other node's subtrees must be BSTs


Approach 1 :
1. Maintain a minimum and maximum range of values
2. If the node's value is not within this range return false
3. Call the check function again for left and right subtrees. Update the max for the left call, and min for the right call.
*/
class Solution {
    public boolean isValidBST(TreeNode root) {
        return check(root,null,null);
    }
    boolean check(TreeNode lroot, Integer min, Integer max){
        if(lroot==null){
            return true;
        }
        else if((min!=null && lroot.val<=min )||(max!=null && lroot.val >= max)){//if duplicates not allowed, allow = both sides
            return false;
        }
        else if(!check(lroot.left,min,lroot.val) || !check(lroot.right,lroot.val,max))
            return false;
        else
            return true;
    }
}
class Solution {
    public boolean isValidBST(TreeNode root) {
        if(root==null || (root.left==null && root.right==null))//leaf node is also a BST
            return true;
       boolean left = lessThan(root.left,root.val); //check if left subtree element value < root 
       boolean right = greaterThan(root.right,root.val); //check if right subtree element value > root 
       if(!(left && right)) return false;//if either not, not a BST
        return isValidBST(root.left) && isValidBST(root.right);//now check subtrees of left and right subtree.
    }
    public boolean lessThan(TreeNode root, int key){//root, its left and right subtree should be < key
        if(root==null)
            return true;
        else if(root!=null && root.val >= key){
            return false;
        }
        else if(root.right!=null && root.right.val >= key)
            return false;
        else if(root.left!=null && root.left.val >= key)
            return false;
        else
            return lessThan(root.left,key) && lessThan(root.right,key);
    }
    public boolean greaterThan(TreeNode root, int key){//root, its left and right subtree should be > key
        if(root==null)
            return true;
        else if(root!=null && root.val <= key){
            return false;
        }
        else if(root.right!=null && root.right.val <= key)
            return false;
        else if(root.left!=null && root.left.val <= key)
            return false;
        else
            return greaterThan(root.left,key) && greaterThan(root.right,key);
    }
}
