package practice;

public class RotateLeft {

	public static void main(String[] args) {
		int [] x= {1,2,3,4,5};
		
		
		int n=3;
		for(int i=0;i<n;i++) {
			int first=x[0];
			for(int j=1;j<x.length;j++) {
				
				x[j-1]=x[j];
				
			}
			x[x.length-1]=first;
		}
		System.out.println();
		for(int i=0;i<x.length;i++) {
			System.out.println(x[i]);
		}
	}
}
