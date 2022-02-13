/*
String p - processed = subset, up = unprocessed = remaining str
*/
class Solution{
	static void subsetpu(String p, String up){
    //No elements left to check
	    if(up.length()==0){
	        System.out.println(p);
	        return;
	    }
    //Include up[0] in subset and remove that element from up
	    subsetpu(p + up.charAt(0), up.substring(1));
    //Don't include in subset and remove from up
	    subsetpu(p, up.substring(1));
	    return;
	}
  	static ArrayList<String> subset(String p, String up){
    //No elements left to check
	    if(up.length()==0){
	      ArrayList<String> a = new ArrayList();
        a.add(p)
        return a;
	    }
      ArrayList<String> b = new ArrayList();
    //Include up[0] in subset and remove that element from up
	    b.addAll(subset(p + up.charAt(0), up.substring(1)));
    //Don't include in subset and remove from up
	    b.addAll(subset(p, up.substring(1)));
	    return;
	}
}
/*
0 "" 
0 "" 01 1
0 "" 01 1 02 012 12 2
*/
static void subsetListIterative(int[] arr){
	    ArrayList<ArrayList<Integer>> subsetCollection  = new ArrayList();
	    int len = 0;
	    for(int i = 0;i<arr.length;i++){
		    //add an empty and one other character
	        if(subsetCollection.size()==0){
	            ArrayList<Integer> a = new ArrayList();
	            ArrayList<Integer> b = new ArrayList();
	            b.add(arr[0]);
	            subsetCollection.add(a);
	            subsetCollection.add(b); 
	        }
	        else{
			//new element by adding this to all other elements
	            len = subsetCollection.size();
	            for(int j=0;j<len;j++){
	                System.out.println(subsetCollection.size());
	            ArrayList<Integer> x = new ArrayList(subsetCollection.get(j));
	            
	            x.add(arr[i]);
	            subsetCollection.add(x); 
	            }
	        }
	    }
	    System.out.println(subsetCollection);
	}
