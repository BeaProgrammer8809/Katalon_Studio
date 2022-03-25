package practice;

import java.util.Scanner;

import org.testng.annotations.Test;

public class CommonCharInTwoStrings {
	@Test
	public  void CommonCharInTwoStrings() {
		
				Scanner s = new Scanner(System.in);
				System.out.println("Please enter the first string");
		 
				String string1 = s.nextLine();
		 
				System.out.println("Please enter the second string");
		 
				String string2 = s.nextLine();
		 
				s.close();
		 
				System.out.println("Output is :" + commonChars(string1, string2));
			}

	
	public static String commonChars(String str1, String str2) {
		StringBuilder commonChars = new StringBuilder();
 
		if (str1.length() > 0 & str2.length() > 0) {
			
			String toBeIterated = (str1.length() > str2.length() ? str2 : str1);
			
			String toBeChecked = toBeIterated.equals(str1) ? str2 : str1;
			System.out.println("String to be iterated: " + toBeIterated);
			System.out.println("String to be checked: " + toBeChecked);
 
			
			for (int i = 0; i < toBeIterated.length(); i++) {
				
				if (toBeChecked.contains(Character.toString(toBeIterated.charAt(i)))) {
					
					commonChars.append(Character.toString(toBeIterated.charAt(i)));
				}
			}
			return commonChars.toString();
		} else
			return "";
	}

}
