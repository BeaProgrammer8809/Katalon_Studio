package practice;

public class OccurenceOfParticularCharacter {

	public static void main(String[] args) {
		String s="mahabharat";
		int count=0;
		
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i)=='a') {
				count++;
			}
		}
		System.out.println('a'+" Present "+count+" Times");
	}
}
