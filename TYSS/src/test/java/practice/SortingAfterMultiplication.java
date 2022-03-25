package practice;


import java.util.TreeSet;

public class SortingAfterMultiplication {

	public static void main(String[] args) {
		TreeSet<Integer> li=new TreeSet<Integer>();
		int [] x= {9,2,3,6,5,6,7,8,9,10};
		int   p= 0;
		
		try {
			for(int i=0;i<x.length;i++) {
				 p=x[i]*x[i+1]*x[i+2];
				 li.add(p);
			}
			
		}catch (Exception e) {
			System.out.println("Done");
		}
		 
		 
		
		System.out.println(li);
}
}