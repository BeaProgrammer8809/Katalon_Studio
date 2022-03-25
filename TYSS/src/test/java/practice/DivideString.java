package practice;

public class DivideString {

	public static void main(String[] args) throws Exception {
		String s="aaaabbbbcccd";
		
		int n=3;
		if(s.length()%n!=0) {
			try {
				System.out.println("aalu");
				throw new Exception("Hello Allu");
			}
			catch (Exception e) {
				System.out.println("Exception handled");
				throw e;
			}
		} else {
			int div=s.length()/n;
			int i=0;
			for(int j=0;j<div-1;j++) {
				System.out.println(s.substring(i,i+div));
				i=i+div;
			}
			
		}
	}
}
