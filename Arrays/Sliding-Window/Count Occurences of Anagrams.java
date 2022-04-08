
    int search(String pat, String txt) {
        int ans = 0;
        int k = pat.length();
        int i = 0, j = 0;
        HashMap<Character, Integer> map = new HashMap();
        for(int x=0;x<k;x++){
            map.put(pat.charAt(x), map.getOrDefault(pat.charAt(x), 0)+1);
        }
        //count of elements with 0
        int count = map.size();
        while(j<txt.length()){
            //check if in map, if so, decrement the value.
            if(map.containsKey(txt.charAt(j))){
                map.put(txt.charAt(j), map.getOrDefault(txt.charAt(j), 0)-1);
                if(map.get(txt.charAt(j)) == 0) count--; 
            }
            if(j-i+1 < k) j++;
            else{
                //All elements for anagram present
                if(count == 0) ans++;
                //map has the element which is gonna be removed when we slide it
                if(map.containsKey(txt.charAt(i))) 
                {
                    if(map.get(txt.charAt(i)) == 0) count++;
                    map.put(txt.charAt(i), map.getOrDefault(txt.charAt(i), 0) +1);
                }
                i++;
                j++;
            }
        }
        return ans;
    }
