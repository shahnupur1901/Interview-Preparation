/*
Window with start and max
*/
class Solution{
    
    /*  Function to calculate the longest consecutive ones
    *   N: given input to calculate the longest consecutive ones
    */
    public static int maxConsecutiveOnes(int n) {
        
        // Your code here\
        int start = 0, max = 0, current = 0;
        int numDigits = (int)(Math.log(n) / Math.log(2)) + 1;
        int res = n;
        while(res!=0){
            int digit = res & 1;
            if(digit==1)
                current++;
            if(max < current)
                max = current;
            if(digit==0)
                current = 0;
            res = res >> 1;
        }
        return max;
    }
}
