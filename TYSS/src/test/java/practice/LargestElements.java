package practice;



import org.testng.annotations.Test;

public class LargestElements {
	@Test
public void LargestElements() {
		
		
	int []  a = {1, 23, 12, 9, 30, 2, 50};
	
	for(int i=0;i<a.length;i++) {
	for(int j=1;j<a.length;j++) {
		
		if(a[i]>a[j]) {
			int temp=a[i];
			a[i]=a[j];
			a[j]=temp;
			}
		}
	}
	System.out.println("2nd largest number in array is : "+a[2]);	
}
}
