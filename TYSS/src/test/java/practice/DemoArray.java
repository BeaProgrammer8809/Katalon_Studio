package practice;

public class DemoArray {

	public static void main(String[] args) {
		River [] r=new River[5];
		
		r[0]=new River("Ganga");
		r[1]=new River("Yamuna");
		r[2]=new River("Sarswati");
		r[3]=new River("Nile");
		r[4]=new River("Brahmputra");
		
		for(River r1:r) {
			System.out.println(r1);
		}
	}
}
