package practice;

public class CharNumWithoutUsingHashSet {

	 public static void main(String[] args) {
         String s="aaabcfffsda";
         int count=1;
         String rev="";
         int l=s.length()-1;
         for(int i=0;i<l;i++) {
        	 if(s.charAt(i)==s.charAt(i+1)) {
        		 count++;
        		 
        	 }else {
        		 rev=rev+s.charAt(i)+count;
        		 count=1;
        	 }
        	 
         }
         rev=rev+s.charAt(l)+count;
         System.out.println(rev);

 }
}
