package practice;

import java.util.LinkedHashSet;

public class SortArrayMaxandMin {

	public static void main(String[] args) {
		int [] x= {1,3,6,5,7,9,2,9,7,8,4,10};
		
		for(int i=0;i<x.length;i++) {
			
			for(int j=0;j<x.length;j++) {
				if(x[i]>x[j]) {
					int temp=x[i];
					x[i]=x[j];
					x[j]=temp;
				}
			}
			
		}
		// for Even
//		int count=x.length-1;
//		for(int i=0;i<x.length/2;i++) {
//			System.out.print(x[count]+" ");
//			System.out.print(x[i]+" ");
//			count--;
//		}
		
		//for both even and odd
		LinkedHashSet<Integer> set=new LinkedHashSet<Integer>();
		for(int i=0;i<=x.length/2;i++) {
			set.add(x[x.length-1]+i);
			set.add(x[i]);
		}
		System.out.print(set);
	}
}
