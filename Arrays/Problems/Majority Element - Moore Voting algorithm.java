class Solution
{
    static int majorityElement(int a[], int size)
    {
        // Moore's voting algorithm
        int count = 0, element = 0;
        for(int i=0;i<size;i++){
            if(count == 0){
                // Choose new possible majority element
                element = a[i];
                count = 1;
            }
            else if(element == a[i]) count ++;
            else count -= 1;
        }
        count = 0;
        for(int i : a){
            if(i == element) count++;
        }
        return count > size/2 ? element : -1;
    }
}
