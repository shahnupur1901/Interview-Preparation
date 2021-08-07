String stringSwap(String s,int i, int j) {
		char arr[] = s.toCharArray();
		char temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
		return String.valueOf(arr);
	}
	void permute(String s,int left,int right) {
		if(left==right) {
			System.out.println(s);
			return;
		}
		else {
			for(int i = left;i<=right;i++) {
				s = stringSwap(s,left,i);
				permute(s,left+1,right);
			}
		}
	}
