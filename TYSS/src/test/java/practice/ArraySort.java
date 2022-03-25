package practice;

public class ArraySort {

	public static void main(String[] args) {
		int [] x= {20,28,4,21,3,1};
		
		for(int i=0;i<x.length;i++) {
			for(int j=i+1;j<x.length;j++) {
				if(x[i]>x[j]) {
					int temp=x[i];
					x[i]=x[j];
					x[j]=temp;
				}
			}
		}
		for(int r:x) {
			System.out.println(r);
		}
	}
}
