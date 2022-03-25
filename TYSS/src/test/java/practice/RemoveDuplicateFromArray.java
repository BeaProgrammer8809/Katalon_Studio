package practice;

import java.util.LinkedHashSet;

public class RemoveDuplicateFromArray {

	public static void main(String[] args) {
		int [] x= {2,5,3,2,5};
		LinkedHashSet<Integer> set = new LinkedHashSet<Integer>();
		
		for(int s:x) {
			set.add(s);
		}
		System.out.println(set);
	}
}
