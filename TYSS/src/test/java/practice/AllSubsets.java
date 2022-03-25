package practice;

public class AllSubsets {

	public static void main(String[] args) {
		String str = "FUNAALU";  
        int len = str.length();  
        int temp = 0;  
        
        //Total possible subsets for string of size n is n*(n+1)/2  
        String arr[] = new String[len*(len+1)/2];  
  
          
        for(int i = 0; i < len; i++) {  
           
            for(int j = i; j < len; j++) {  
                arr[temp] = str.substring(i, j+1);  
                temp++;  
            }  
        }  
  
       
        System.out.println("All subsets for given string are: ");  
        for(int i = 0; i < arr.length; i++) {  
            System.out.println(arr[i]);  
            StringBuffer sb=new StringBuffer(arr[i]);
            StringBuffer reverse = sb.reverse();
            System.out.println(reverse);
       
	}
}
}
