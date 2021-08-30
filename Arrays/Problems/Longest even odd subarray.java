/*
even + even = odd + odd = even
odd + even = odd
*/
static int longestEvenOddSubarray(int a[], int n)
{
    // Length of longest
    // alternating subarray
    int longest = 1;
    int cnt = 1;
 
    // Iterate in the array
    for (int i = 0; i < n - 1; i++)
    {
 
        // increment count if consecutive
        // elements has an odd sum
        if ((a[i] + a[i + 1]) % 2 == 1)
        {
            cnt++;
        }
        else

            longest = Math.max(longest, cnt);
            cnt = 1;
        }
    }
    if (longest == 1)
        return 0;
 
    return Math.max(cnt, longest);





