/*
Idea : Find the preorder and inorder strings of tree and subtree. Where null is present, append a character like '/'
This captures the structure of the trees
Later see if preorder of tree contains pre of subtree and do for iorder too
*/

class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        StringBuffer preRoot = new StringBuffer();
        preorder(root,preRoot);
        StringBuffer preSubRoot = new StringBuffer();
        preorder(subRoot,preSubRoot);
        if(!preRoot.toString().contains(preSubRoot.toString())) return false;
        StringBuffer inRoot = new StringBuffer();
        inorder(root,inRoot);
        StringBuffer inSubRoot = new StringBuffer();
        inorder(subRoot,inSubRoot);
        if(!inRoot.toString().contains(inSubRoot.toString())) return false;
        return true;
    }
    void preorder(TreeNode lroot,StringBuffer s){
        if(lroot!=null){
            s.append(lroot.val);
            preorder(lroot.left,s);
            preorder(lroot.right,s);
        }
        else{
            s.append('/');
        }
    }
     void inorder(TreeNode lroot,StringBuffer s){
        if(lroot!=null){
           
            inorder(lroot.left,s);
             s.append(lroot.val);
            inorder(lroot.right,s);
        }
          else{
             s.append('/');
        }
     }
}
