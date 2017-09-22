package liwei;

import java.util.Random;
import java.util.Scanner;

public class helloWord {
   public static void hh(int a) {
	   System.out.println(a);
	   
   }
	public static void main(String[] args) {
//		hh(10);
		int surplusTime = 2000;
		int day = surplusTime / (24 * 60);
		    surplusTime = surplusTime % (24 * 60);
		    int hour = surplusTime / 60;
		    surplusTime = surplusTime % 60;
		System.out.println(day+"-"+hour + "-"+surplusTime);
//	   test2();
	}
	public static void test2(){
		for (int i = 0; i < 5; i++) {
			int r = new Random().nextInt(10)+1;
			System.out.println(r);
		}
		
	}
    public static void test1() {
	 @SuppressWarnings("resource")
		char chs[] = String.valueOf(new Scanner(System.in).nextInt()).toCharArray();
	    System.out.println("个位数是："+chs[2]+"\n十位数是："+chs[1]+"\n百位数是："+chs[0]);
    }
}
