package practice;

public class Prime_8 {
	public static void main(String[] args) {
		for(int i=10;i<=100;i++) {
			int count=0;
			for(int j=1;j<=i;j++) {
				if(i%j==0) {
					count++;
				}
			}
			if(count==2) {
				int num=i;
				int sum=0;
				while(num!=0) {
					int rem=num%10;
					sum=sum+rem;
					num=num/10;
					
				}
				if(sum==8) {
					System.out.println(i);
				}
			}
		}
		
	}
}
