package com.liwei.common.cm.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * 日期处理
 *
 *@file common.utils
 *@author liwei
 *@Date：下午8:15 下午8:15
*/
public class DateUtils {
	
	/** 时间格式(yyyy-MM-dd) */
	public final static String DATE_PATTERN = "yyyy-MM-dd";

	/** 时间格式(yyyy/MM/dd) */
	public final static String DATE_PATTERN_SLASH = "yyyy/MM/dd";
	
	/** 时间格式(yyyy-MM-dd HH:mm:ss) */
	public final static String DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";
	/** 时间格式(yyyy-MM-dd HH:mm:ss SSS) */
	public final static String DATE_TIME_PATTERNSSS = "yyyy-MM-dd HH:mm:ss SSS";

	public static String format(Date date) {
		return format(date, DATE_PATTERN);
	}

	public static String format(Date date, String pattern) {
		if (date != null) {
			SimpleDateFormat df = new SimpleDateFormat(pattern);
			return df.format(date);
		}
		return null;
	}
	
}
