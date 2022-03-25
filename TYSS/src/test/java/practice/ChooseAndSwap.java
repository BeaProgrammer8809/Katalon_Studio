package practice;

public class ChooseAndSwap {

	public static void main(String[] args) {
		String s="ccad";
		String str="";

		for(int i=0;i<s.length();i++) {
			if(s.charAt(i)=='c') {
				str=str+'a';
			}else if(s.charAt(i)=='a') {
					str=str+'c';
				}else {
					str=str+s.charAt(i);
			}
		}
		
		System.out.println(str);
		
	}
}
