package practice;

public class EvenPosition {

	public static void main(String[] args) {
		int [] x= {1,2,3,4,5};
		
		for(int i=0;i<x.length;i++) {
			if(x[i]%2==0) {
				System.out.println(x[i]);
			}
		}
	}
}
