package practice;

public class Pallindrome {

	public static int next_Palindrome(int n1) {
        int num1=n1;
        int rem =0; 
        int sum=0;
        int temp=0;          
        while(true)
        {
          num1--;
          temp=num1;
          sum=0;
          rem=0;
         
         while(temp>0) {  
                rem=temp%10;
                sum=sum*10+rem;
                temp=temp/10;                    
        }            
        if(sum==num1) {
                System.out.println(sum +" num is palindrome");
                break;
      
        }
     }
        return sum;
}
	public static int prev_Palindrome(int n1) {
        int num1=n1;
        int rem =0; 
        int sum=0;
        int temp=0;          
        while(true)
        {
          num1++;
          temp=num1;
          sum=0;
          rem=0;
         
         while(temp>0) {  
                rem=temp%10;
                sum=sum*10+rem;
                temp=temp/10;                    
        }            
        if(sum==num1) {
                System.out.println(sum +" num is palindrome");
                break;
      
        }
     }
        return sum;
}
	
	

    public static void main(String[] args) {
            
            int num=323;
            int first_num=next_Palindrome(num);
            int sec_num=prev_Palindrome(num);
            if((first_num-num)>(sec_num-num)) {
            	System.out.println("Nearest Palindrome is : "+ sec_num);
            }else {
            	System.out.println("Nearest Palindrome is : "+ first_num);
            }
            
            
    }
    
}
