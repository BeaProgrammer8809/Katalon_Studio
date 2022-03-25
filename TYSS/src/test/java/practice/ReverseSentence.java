package practice;

public class ReverseSentence {

	public static void main(String[] args) {
		String s="Bonda Egg eat to use kiccha ";
		String[] str = s.split(" ");
		
		for(int i=str.length-1;i>=0;i--) {
			System.out.print(str[i]+" ");
		}
		
	}
}
