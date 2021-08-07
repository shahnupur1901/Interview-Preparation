/*
1. Sorting : O(nlogn)
Sort and check

2. Keep a count array O(n)

*/

boolean anagramCheck(String s1, String s2) {
		s1 = s1.toLowerCase();
		s2 = s2.toLowerCase();
		if(s1.length()!=s2.length()) return false;
		int hash1[] = new int[26];
		int hash2[] = new int[26];
		Arrays.fill(hash1, 0);
		Arrays.fill(hash2, 0);
		for(int i = 0;i<s1.length();i++) {
			hash1[s1.charAt(i)-'a']++;
			hash2[s2.charAt(i)-'a']++;
		}
		for(int i=0;i<26;i++) {
			if(hash1[i]!=hash2[i])
				return false;
		}
		return true;
	}
