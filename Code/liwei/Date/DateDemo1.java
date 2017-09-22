package liwei.Date;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


public class DateDemo1 {

	private static Scanner scanner;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        try {
			function_1();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void function_1() throws Exception {
		System.out.println("请输入生日格式 格式 YYYY-MM-dd");
		scanner = new Scanner(System.in);
	String birthdayString = scanner.next();
	// 将日期字符串转换成data对象
	SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
	Date birthdayDate = sdf.parse(birthdayString);
	// 获取今天的日期
	Date todayDate = new Date();
	// 转换成毫秒
	long secone = todayDate.getTime() - birthdayDate.getTime();
	if (secone < 0) {
		System.out.println("还没有出生");
	}
	else {
		System.out.println(secone/1000/60/60/24);
	}
	}
	
   /**
    *  创建SimpleDateFormat对象
    *     在构造方法中，写入字符串的日期格式
    *  SimpleDateFormat调用方法format对日期进行格式化
    *     String format（Date date）传递日期对象，返回字符串
    *     
    * */
	public static void function() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
		String date =sdf.format(new Date());
		System.out.println(date);
	}
}
