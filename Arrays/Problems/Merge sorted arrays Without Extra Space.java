{

    public void merge(int arr1[], int arr2[], int n, int m) {
        // code here
       int gap = Math.ceil((n+m)/2).intValue();
       while(gap >= 1){
           System.out.println(gap);
           int i = 0;
           while(i + gap < n){
               if(arr1[i] > arr1[i+gap]){
                   int temp = arr1[i];
                   arr1[i] = arr1[i+gap];
                   arr1[i+gap] = temp;
               }
               i++;
           }
           int j = gap - (n - i);
           //System.out.println(arr2[j]);
           while (i<n && j<m){
                 if(arr1[i] > arr2[j]){
                   int temp = arr1[i];
                   arr1[i] = arr2[j];
                   arr2[j] = temp;
               }
               i++;
               j++;
           }
           while(j+gap<m){
                  if(arr2[j] > arr2[j+gap]){
                   int temp = arr2[j];
                   arr2[j] = arr2[j+gap];
                   arr2[j+gap] = temp;
               }
               j++;
           }
           gap = Math.ceil(gap/2).intValue();
       }
    }
}
