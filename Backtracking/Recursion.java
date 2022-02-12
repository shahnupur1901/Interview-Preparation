
public class Main
{
	public static void main(String[] args) {
		System.out.println("Hello World");
		int arr[] = {1,4,2,7,8};
	    printt1(5);
	}
	
	static void printt1(int n){
	    if(n==0) return;
	    else{
	        System.out.println();
	        for(int i = 0;i<n;i++){
	            System.out.print("*");
	        }
	        printt1(n-1);
	        return;
	    }
	}
	 public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        s = s.replaceAll(
          "[^a-zA-Z0-9]", "");
        if(s.length()==1 || s.length()==0) return true;
        else if(s.charAt(0) != s.charAt(s.length()-1)) return false;
        else{
          
            return isPalindrome(s.substring(1, s.length()-1));
        }
    }
    
    static int count0(int n){
        if(n/10 == 0){
            return 0;
        }
        if(n%10==0){
            return 1 + count0(n/10);
        }
        return count0(n/10);
        
        
    }
	static int sumDigits(int n){
	    if(n==0){
	        return 0;
	    }
	    return n%10 + sumDigits(n/10);
	}
	static int factorial(int n){
	    if(n==1){
	        return 1;
	       
	    }
	    return n*factorial(n-1);
	    
	}
	static void printdecreasing(int n){
	    if(n==0)
	    return;
	    System.out.println(n);
	    printdecreasing(n-1);
	}
	static void printincreasing(int n){
	    if(n==0)
	    return;
	    printincreasing(n-1);
	   System.out.println(n);
	}
	static void both(int n){
	    if(n==0)
	    return;
	    System.out.println(n);
	    both(n-1);
	    System.out.println(n);
	}
	static int fib(int n){
	    if(n==1){
	        return 1;
	    }
	    else if(n==0){
	        return 0;
	    }
	    return fib(n-1) + fib(n-2);
	    
	}
	
	static boolean bsearch(int[] arr, int low, int high, int target){
	    if(low>=high){
	        return false;
	    }
	    int mpt = (low+high)/2;
	    if(target == arr[mpt]){
	        return true;
	    }
	    if(target < arr[mpt]){
	        return bsearch(arr, low, mpt-1, target);
	    }
	    else{
	        return bsearch(arr, mpt+1, high, target);
	    }
	}
}
