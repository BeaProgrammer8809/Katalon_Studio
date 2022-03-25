package practice;

public class Anagram {

	public static void main(String[] args) {
		String s="Grab";
		String s1="Brag";
		 int count=0;
		 s = s.toLowerCase();
		 s1 = s1.toLowerCase();
		 
		 for(int i=0;i<s.length();i++) {
			
			 for(int j=0;j<s1.length();j++) {
				 if(s.charAt(i)==s1.charAt(j)) {
					count++;
				 }
			 }
		 }
		if(count==s.length()) {
			System.out.println("Strings are anagram");
		}else {
			System.out.println("String are not anagram");
		}
	}
}
