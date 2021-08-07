/*
Preorder : ROOT - LEFT - RIGHT
Inorder  : LEFT - ROOT - RIGHT
Recursive subroutine : 
Get the root from preorder traversal.
Find that node value in the inorder traversal.
Node's left subtree : left of that node from inorder traversal
Node's right subtree : right of that node from inorder traversal
*/
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length<=0) return null;
        return construct(0,0,inorder.length-1,preorder,inorder);//helper function
    }
    
    public TreeNode construct(int preidx, int instart,int inend ,int[] preorder,int[] inorder){
      /*
      preidx : to get root from preorder
      instart, inend : parameters from inorder 
      */
        if(preidx>=preorder.length || instart >inend) return null;
        int idx = instart;
        TreeNode root = new TreeNode(preorder[preidx]); //create a node
        for(int i = 0;i<inorder.length;i++){  //find the node in inorder traversal
            if(root.val==inorder[i]){
                idx = i;
                break;
            }
        }
        root.left = construct(preidx+1,instart,idx-1,preorder,inorder); //left subtree
        root.right = construct(preidx + idx-instart+1,idx+1,inend,preorder,inorder);//right subtree ; idx - instart + 1 is the left subtree length. To calculate the 
      // root of right subtree found by adding left subtree length to preidx
        return root;
        
    }
}
