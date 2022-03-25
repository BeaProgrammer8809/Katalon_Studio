package practice;



public class Test {

	public static void main(String[] args) {
		String s="ghanshyamK";
		String s1="";
		
				//ghanshyam_k
		for(int i=0;i<s.length();i++) {
			
			Character c = s.charAt(i);
			if(Character.isLowerCase(c)) {
				s1=s1+c;
			
			}else {
				s1=s1+"_"+c.toLowerCase(c);
			}
			}
	
		System.out.println(s1);
	}
}
