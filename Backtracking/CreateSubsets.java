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
