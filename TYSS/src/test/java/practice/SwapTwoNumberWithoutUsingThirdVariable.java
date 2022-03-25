package practice;

public class SwapTwoNumberWithoutUsingThirdVariable {

	public static void main(String[] args) {
		int a=10;
		int b=20;
		System.out.println("a Value before Swapping :"+a);
		System.out.println("b Value before Swapping :"+b);
		a=a+b;
		b=a-b;
		a=a-b;
		System.out.println("a Value after Swapping :"+a);
		System.out.println("b Value after Swapping :"+b);
	}
}
