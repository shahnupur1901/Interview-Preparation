/*
Left Subtree elements should be < root
Right Subtree elements should be > root
All other node's subtrees must be BSTs
*/

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
