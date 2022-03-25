package practice;

public class CopyArray {

	
	
	public static void main(String[] args) {
		int [] x= {1,2,3,4,5};
		int [] s= new int [x.length];
	
		for(int i=0;i<x.length;i++) {
			s[i]=x[i];
		}
	
		for(int s1:s) {
			System.out.print(s1+" ");
		}
		
	}
}
