 void printLCS(int t[][], String str1, String str2){
        int x = str1.length();
        int y = str2.length();
        while(x>0 && y>0){
            if(str1.charAt(x-1) == str2.charAt(y-1)){
                System.out.print(str1.charAt(x-1));
                x = x-1;
                y = y-1;
            }
            else{
                int a = t[x-1][y];
                int b = t[x][y-1];
                if(a>b){
                    x = x-1;
                }
                else{
                    y=y-1;
                }
            }
        }
    }
