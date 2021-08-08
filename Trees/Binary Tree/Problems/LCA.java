/*
Approach 1:

The LCA will have p and q in different subtrees!
*/
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode localroot, TreeNode p, TreeNode q) {
        if(localroot==null)
            return null;
        else if(p.val==localroot.val || q.val==localroot.val)//p is the local root and q has a child in its subtree
            return localroot;
        else{
            boolean pRight = isInSubtree(localroot.right,p);//see if p is in right subtree
            boolean qRight = isInSubtree(localroot.right,q);//-------q--------------------
            if(pRight != qRight){//In different subtrees, so return the localroot which is the lca
                return localroot;
            }
            else if(pRight && qRight){//both in right
                return lowestCommonAncestor(localroot.right,p,q);
                
            }
            else//in left
                return lowestCommonAncestor(localroot.left,p,q);
           
            
        }
    }
    boolean isInSubtree(TreeNode localroot, TreeNode p){
        if(localroot==null)
            return false;
        else if(localroot.val==p.val)
            return true;
        else{
            return isInSubtree(localroot.left,p) || isInSubtree(localroot.right,p);
        }
    }
}

/*
Approach 2 :
Create stacks of ancestors. Keep popping till not same. The last same popped node is the LCA
*/
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Stack<TreeNode> sp = new Stack();
        Stack<TreeNode> sq = new Stack();
        ancestor(root,p,sp);
        ancestor(root,q,sq);
        TreeNode ans = null;
        for(int i=0;!sp.isEmpty() && !sq.isEmpty();i++){
            TreeNode x = sp.pop();
            TreeNode y = sq.pop();
            if(x!=y)
                return ans;
            ans = x;
        }
        return ans;
    }
    boolean ancestor(TreeNode localroot,TreeNode p,Stack s){
        if(localroot==null)
            return false;
        else if(localroot.val==p.val){
            s.push(localroot);
            return true;
        }
        else{
            if(ancestor(localroot.left,p,s) || ancestor(localroot.right,p,s)){
                s.push(localroot);
                return true;
            }
            else
                return false;
        }
    }
}
