package practice;

public class ReverseEachWordOfString {

	public static void main(String[] args) {
		String s="Welcome to Sony";
		String[] str = s.split(" ");
		String rev="";
		
		for(String s1:str) {
			for(int i=s1.length()-1;i>=0;i--) {
				System.out.print(s1.charAt(i));
			}
			System.out.print(" ");
		}
		
	}
	
}
