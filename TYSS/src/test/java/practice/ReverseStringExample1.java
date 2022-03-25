package practice;

public class ReverseStringExample1 {

	public static void main(String[] args) {
		String s="Rakesh is a good boy";
		
		for(int i=s.length()-1;i>=0;i--) {
			System.out.print(s.charAt(i));
		}
	}
}
