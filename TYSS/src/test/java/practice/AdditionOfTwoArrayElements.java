package practice;

public class AdditionOfTwoArrayElements {

	public static void main(String[] args) {
		 int a[]= {8,6,5};
         int b[]= {4,4,9,6,9,9};
         
         int count=a.length;
         if(count<b.length) {
                 count=b.length;
                 
                 
         }
         
        
         for(int i=0;i<count;i++) {
                 try {
                         int c=a[i]+b[i];
                         if(c>=10) {
                                 int d=c/10;
                                 System.out.print(d+" ");
                                 c=c%10;
                                 System.out.print(c+" ");
                         }else {
                                 System.out.print(c+" ");        
                         }
                 }
                  catch (Exception e) {
                         if(a.length>b.length) {
                                 System.out.print(a[i]+" ");
                         }
                         else {
                                 System.out.print(b[i]+" ");
                         }
                 }        
                 
         }
	}
}
