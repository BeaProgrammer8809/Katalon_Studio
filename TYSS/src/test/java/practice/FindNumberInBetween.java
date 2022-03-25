package practice;

public class FindNumberInBetween {

	public static void main(String[] args) {
		int a[]= {1,3,7,9,15};


		for(int i=0;i<a.length-1;i++) {
		        for(int j=a[i];j<a[i+1]-1;j++) {
		                System.out.println(j+1);   
		        }
		}
	}
}
