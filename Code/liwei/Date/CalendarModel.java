package liwei.Date;

import java.util.Calendar;

public class CalendarModel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        function();
	}
   public static void function() {
	Calendar calendar = Calendar.getInstance();
	// 获取年份
	int year = calendar.get(Calendar.YEAR);
	int month = calendar.get(Calendar.MONTH) + 1;
	int day = calendar.get(Calendar.DAY_OF_MONTH);
	System.out.println(year + "年" + month + "月" + day + "日");
    }
}
