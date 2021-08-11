class Solution {
    static int setBits(int n) {
        // code here
        int numDigits = (int)((Math.log(n))/Math.log(2)) + 1;
        int res = n;
        int count = 0;
        while(res!=0){
            res = res & (res-1);
            count++;
        }
        count = 0;
        res = n;
        for(int i=0;i<numDigits;i++){
            if((res & 1)==1)
                count++;
            res = res>>1;
        }
        return count;
    }
}
