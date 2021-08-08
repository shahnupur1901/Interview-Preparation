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
