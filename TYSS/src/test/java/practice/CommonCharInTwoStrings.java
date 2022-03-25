package practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CommonCharInTwoStrings {
	
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.println("Please Enter the First String : ");
		String s1=s.nextLine();
		System.out.println("Please Enter the Second String : ");
		String s2=s.nextLine();
		System.out.println("Please Enter the Third String : ");
		String s3=s.nextLine();
		System.out.println("Please Enter the Forth String : ");
		String s4=s.nextLine();
		
		s.close();
		
		System.out.println("Output is : "+CommonChar(s1, s2,s3,s4));
		
	}
	public static String CommonChar(String str1,String str2,String str3,String str4) {
		if(str1.length()>0 & str2.length()>0 & str3.length()>0 & str4.length()>0) {
		List<Character> l1 = new ArrayList<Character>();
		List<Character> l2 = new ArrayList<Character>();
		List<Character> l3 = new ArrayList<Character>();
		List<Character> l4 = new ArrayList<Character>();
			
			for(int i=0;i<str1.length();i++) {
				l1.add(str1.charAt(i));
			}
			for(int i=0;i<str2.length();i++) {
				l2.add(str2.charAt(i));
			}
			for(int i=0;i<str3.length();i++) {
				l3.add(str3.charAt(i));
			}
			for(int i=0;i<str4.length();i++) {
				l4.add(str4.charAt(i));
			}
			l1.retainAll(l2);
			l1.retainAll(l3);
			l1.retainAll(l4);
			
			
			StringBuilder sb = new StringBuilder();
			
			for(Character c:l1) {
				sb.append(c);
			}
			return sb.toString();
		}else
			return "";
	}

}
