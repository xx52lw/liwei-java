package util;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.DateFormatUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Slf4j
public class DateUtils {
//    protected final static log log = LogManager.getLogger(DateUtils.class);

    /** 日期格式 **/
    public interface DATE_PATTERN {
        String HHMMSS = "HHmmss";
        String HH_MM_SS = "HH:mm:ss";
        String YYYYMMDD = "yyyyMMdd";
        String YYYYMM = "yyyyMM";
        String YYYY_MM_DD = "yyyy-MM-dd";
        String YYYY_MM_DD_SEP = "yyyy/MM/dd";
        String YYYYMMDDHHMMSS = "yyyyMMddHHmmss";
        String YYYYMMDDHHMMSSSSS = "yyyyMMddHHmmssSSS";
        String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
        String YYYY_MM_DD_HH_MM = "yyyy-MM-dd HH:mm";
        String D_H_M_S = "%d天%d小时%d分钟%d秒";
        String YYYYMMDD_IN_CHAINA = "yyyy年MM月dd日";

    }


	/**
	 * 得到当前日期字符串 格式（yyyy-MM-dd）
	 */
	public static String getDate() {
		return getDate("yyyy-MM-dd");
	}

	public static String getCurrentMonthFirstDay() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal_1 = Calendar.getInstance();// 获取当前日期
		cal_1.add(Calendar.MONTH, 0);
		cal_1.set(Calendar.DAY_OF_MONTH,1);//设置为1号,当前日期既为本月第一天 
		String firstDay = format.format(cal_1.getTime());
		return firstDay;
	}

	public static String getCurrentMonthLastDay() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cale = Calendar.getInstance();
		cale.set(Calendar.DAY_OF_MONTH, cale.getActualMaximum(Calendar.DAY_OF_MONTH));  
		String lastDay = format.format(cale.getTime());
		return lastDay;
	}
	
	public static String getLastMonth(Date date) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMM");
	    Calendar calendar = Calendar.getInstance();
	    calendar.setTime(date); // 设置为当前时间
	    calendar.add(Calendar.MONTH, -1); // 设置为上一个月
	    date = calendar.getTime();
		return dateFormat.format(date);
	}
	/**
	 * 获取当前日期对应之前3月的年月
	 * @param date
	 * @return
	 */
	public static List<String> getQMonth(Date date) {
		List<String> list = new ArrayList<String>();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMM");
	    Calendar calendar = Calendar.getInstance();
	    calendar.setTime(date); // 设置为当前时间
	    calendar.add(Calendar.MONTH, - 1); // 设置为上一个月
	    date = calendar.getTime();
	    list.add(dateFormat.format(date));
	    
	    calendar.add(Calendar.MONTH, - 1); // 设置为上一个月
	    date = calendar.getTime();
	    list.add(dateFormat.format(date));
	    
	    calendar.add(Calendar.MONTH, - 1); // 设置为上一个月
	    date = calendar.getTime();
	    list.add(dateFormat.format(date));
	    
		return list;
	}
	
	public static List<String> getYearMonth(Date date) {
		List<String> list = new ArrayList<String>();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy");
	    Calendar calendar = Calendar.getInstance();
	    calendar.setTime(date); // 设置为当前时间
	    calendar.add(Calendar.MONTH, - 1); // 设置为上一个月
	    date = calendar.getTime();
	    String year = dateFormat.format(date);
	    list.add(year+"01");
	    list.add(year+"02");
	    list.add(year+"03");
	    list.add(year+"04");
	    list.add(year+"05");
	    list.add(year+"06");
	    list.add(year+"07");
	    list.add(year+"08");
	    list.add(year+"09");
	    list.add(year+"10");
	    list.add(year+"11");
	    list.add(year+"12");
		return list;
	}
	

	/**
	 * 获取两个日期之间的日期
	 * 
	 * @param start
	 *            开始日期
	 * @param end
	 *            结束日期
	 * @return 日期集合
	 */
	public static List<String> getBetweenDates(String start, String end) {
		return getBetweenDates(start, end, "yyyy-MM-dd");
	}
	
	/**
     * 获取两个日期之间的日期
     * 
     * @param start
     *            开始日期
     * @param end
     *            结束日期
     * @param dateFormat
     *            日期格式
     * @return 日期集合
     */
    public static List<String> getBetweenDates(String start, String end, String dateFormat) {
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        List<String> result = new ArrayList<String>();
        Calendar tempStart = Calendar.getInstance();
        Calendar tempEnd = Calendar.getInstance();
        try {
            tempStart.setTime(sdf.parse(start));
            tempEnd.setTime(sdf.parse(end));
        } catch (ParseException e) {
            log.error("error", e);
        }
        tempStart.add(Calendar.DAY_OF_YEAR, 1);
        result.add(start);
        while (tempStart.before(tempEnd)) {
            result.add(sdf.format(tempStart.getTime()));
            tempStart.add(Calendar.DAY_OF_YEAR, 1);
        }
        if(!end.equals(start)){
        	 result.add(end);
        }
        return result;
    }
    
    /**
     * 获取两个日期之间的月份
     * 
     * @param start
     *            开始日期
     * @param end
     *            结束日期
     * @return 日期集合
     */
    public static List<String> getBetweenMonths(String start, String end, String dateFormat) {
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        List<String> result = new ArrayList<String>();
        Calendar tempStart = Calendar.getInstance();
        Calendar tempEnd = Calendar.getInstance();
        try {
            tempStart.setTime(sdf.parse(start));
            tempEnd.setTime(sdf.parse(end));
        } catch (ParseException e) {
            log.error("error", e);
        }
        tempStart.add(Calendar.MONTH, 1);
        result.add(start);
        while (tempStart.before(tempEnd)) {
            result.add(sdf.format(tempStart.getTime()));
            tempStart.add(Calendar.MONTH, 1);
        }
        result.add(end);
        return result;
    }
    
    /**
     * 获取两个日期之间的年份
     * 
     * @param start
     *            开始日期
     * @param end
     *            结束日期
     * @return 日期集合
     */
    public static List<String> getBetweenYears(String start, String end, String dateFormat) {
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        List<String> result = new ArrayList<String>();
        Calendar tempStart = Calendar.getInstance();
        Calendar tempEnd = Calendar.getInstance();
        try {
            tempStart.setTime(sdf.parse(start));
            tempEnd.setTime(sdf.parse(end));
        } catch (ParseException e) {
            log.error("error", e);
        }
        tempStart.add(Calendar.YEAR, 1);
        result.add(start);
        while (tempStart.before(tempEnd)) {
            result.add(sdf.format(tempStart.getTime()));
            tempStart.add(Calendar.YEAR, 1);
        }
        result.add(end);
        return result;
    }
    
    /**
     * 获取两个日期之间的季度。
     * 
     * @param start
     *            开始日期(yyyyQn)
     * @param end
     *            结束日期(yyyyQn)
     * @return 日期集合
     */
    public static List<String> getBetweenQuarters(String start, String end, String dateFormat) {
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        List<String> result = new ArrayList<String>();
        Calendar tempStart = Calendar.getInstance();
        Calendar tempEnd = Calendar.getInstance();
        try {
            tempStart.setTime(sdf.parse(start.substring(0, 4)));
            tempEnd.setTime(sdf.parse(end.substring(0, 4)));
        } catch (ParseException e) {
            log.error("error", e);
        }
        tempStart.add(Calendar.YEAR, 1);
        int startQn = Integer.parseInt(start.substring(5, 6));
        while (startQn < 5) {
            result.add(start.substring(0, 4) + "Q" + startQn);
            startQn ++;
        }
        while (tempStart.before(tempEnd)) {
            result.add(sdf.format(tempStart.getTime()) + "Q1");
            result.add(sdf.format(tempStart.getTime()) + "Q2");
            result.add(sdf.format(tempStart.getTime()) + "Q3");
            result.add(sdf.format(tempStart.getTime()) + "Q4");
            tempStart.add(Calendar.YEAR, 1);
        }
        int i = 1;
        int endQn = Integer.parseInt(end.substring(5, 6));
        while (i <= endQn) {
            result.add(end.substring(0, 4) + "Q" + i); 
            i ++;
        }
        return result;
    }
	
	public static String getDate(String pattern) {
		return DateFormatUtils.format(new Date(), pattern);
	}

    /**
     * 返回昨天
     * @return
     */
    public static Date getYesterday() {
        Calendar now = Calendar.getInstance();
        now.setTimeInMillis(System.currentTimeMillis());
        now.add(Calendar.DAY_OF_YEAR, -1);
        return now.getTime();
    }

    /**
     * 返回明天
     * @return
     */
    public static Date getTomorrow() {
        Calendar now = Calendar.getInstance();
        now.setTimeInMillis(System.currentTimeMillis());
        now.add(Calendar.DAY_OF_YEAR, 1);
        return now.getTime();
    }

	/**
     * 当前日期
     * 
     * @return 系统当前时间
     */
    public static Date getCurrentDate() {
        return new Date();
    }
	
    public static Date str2Date(String str, String dateFormat) {
        if (str == null || "".equals(str)) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        Date date = null;
        try {
            date = sdf.parse(str);
        } catch (ParseException e) {
            log.error("error", e);
        }
        return date;
    }
    
    public static String date2Str(Date date, String dateFormat) {
        if (date == null) {
            return "";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        return sdf.format(date);
    }
    
    /**
     * 根据查询日期格式判断查询方式。
     * 
     * @param date
     * @return       
     * @throws
     */
    public static String getDateType(String date) {
        if (date.length() == 8) {
            return "day";//按日查询
        } else if (date.length() == 4) {
            return "year";//按年查询
        } else if (date.toUpperCase().indexOf("Q") > 0) {
            return "quarter";//按季度查询
        } else if (date.length() == 6) {
            return "month";//按月查询
        }
        return null;
    }
    
    /**  
     * 计算两个日期之间相差的天数  
     * @param smdate 较小的时间 
     * @param bdate  较大的时间 
     * @return 相差天数 
     * @throws ParseException  
     */    
    public static int daysBetween(Date smdate,Date bdate) throws ParseException    
    {    
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");  
        smdate=sdf.parse(sdf.format(smdate));  
        bdate=sdf.parse(sdf.format(bdate));  
        Calendar cal = Calendar.getInstance();    
        cal.setTime(smdate);    
        long time1 = cal.getTimeInMillis();                 
        cal.setTime(bdate);    
        long time2 = cal.getTimeInMillis();         
        long between_days=(time2-time1)/(1000*3600*24);  
            
       return Integer.parseInt(String.valueOf(between_days));           
    }    
    
    /**  
     * 当前时间是否在时间范围内
     * @param beginDate 较小的时间 
     * @param endDate  较大的时间 
     * @param date  目标时间的时间 
     * @return boolean
     * @throws ParseException  
     */    
    public static boolean isBetween(Date beginDate,Date endDate ,Date date)    
    {    
    	boolean re = false ;
    	if(date.after(beginDate) && date.before(endDate)){
    		re = true;
    	}
        return re;     
    }
    
    
    
    public static void main(String[] args) throws ParseException {
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    	//Date date = sdf.parse("2017-04-01 12:35:46");
		//System.out.println(getLastMonth(date));
		
		System.out.println(daysBetween(sdf.parse("2016-01-09"),sdf.parse("2015-01-10")));
	}
    

}
