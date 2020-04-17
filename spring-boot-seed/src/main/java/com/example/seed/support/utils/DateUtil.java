package com.example.seed.support.utils;


import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

/**
 * 
 * @ClassName DateUtil
 * @Description 日期工具类
 * @author yedm yedm@hundsun.com
 * @date 2014-1-7
 */
public class DateUtil {
	/*秒*/
	public static final String DUE_UNIT_SECOND="1";
	/*分钟*/
	public static final String DUE_UNIT_MINUTE="2";
	/*小时*/
	public static final String DUE_UNIT_HOUR="3";
	/*天*/
	public static final String DUE_UNIT_DAY="4";
	/*月*/
	public static final String DUE_UNIT_MONTH="5";
	/*季度*/
	public static final String DUE_UNIT_QUARTER="6";
	/*年*/
	public static final String DUE_UNIT_YEAR="7";
	
	private static SimpleDateFormat dateFormat = new SimpleDateFormat();

	/**
	* @Title: dateToString
	* @Description:  将时间转换成字符串
	* @param date
	* @param format
	* @return
	* @throws
	 */
	public static String dateToString(Timestamp date, String format) {
		// 附加时间格式
		dateFormat.applyPattern(format);
		// 将时间转换成字符串
		return dateFormat.format(date);
	}
	
	/**
	* @Title: dateToString
	* @Description: 将时间转换成按要求格式
	* @param date
	* @param format 转换得格式 例如"yyyy-MM-dd HH:mm:ss"
	* @return
	* @throws
	 */
	public static String dateToString(java.util.Date date, String format) {
		// 附加时间格式
		dateFormat.applyPattern(format);
		// 将时间转换成字符串
		return dateFormat.format(date);
	}
	
	/**
	* @Title: dateToDate
	* @Description: 将时间转换成按要求格式
	* @param date
	* @param format 转换得格式 例如"yyyy-MM-dd HH:mm:ss"
	* @return
	* @throws
	 */
	public static java.util.Date dateToDate(java.util.Date date, String format) {
		// 附加时间格式
		dateFormat.applyPattern(format);
		// 将时间转换成字符串
		try {
			return dateFormat.parse(dateToString(date, format));
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	* @Title: stringToDate
	* @Description: 将字符串转换成时间
	* @param dateString 需要转换的时间字符串
	* @param format 转换得格式 例如"yyyy-MM-dd HH:mm:ss"
	* @return 
	* @throws
	 */
	public static java.util.Date stringToDate(String dateString, String format) {
		// 附加时间格式
		dateFormat.applyPattern(format);
		// 将时间转换成字符串
		try {
			return dateFormat.parse(dateString);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	* @Title: dateDiff
	* @Description: 比较两个时间的差值(以秒为单位)
	* @param date1
	* @param date2
	* @return
	* @throws
	 */
	public static long dateDiff(java.util.Date date1, java.util.Date date2) {
		return date2.getTime() / 1000 - date1.getTime() / 1000; // 用立即数，减少乘法计算的开销
	}

	/**
	* @Title: date
	* @Description: 获取当前日期 格式 2012－10－22 返回类型：Date 参数：null
	* @return
	* @throws
	 */
	public static Date date() {
		// 获取当前日期
		String strDate = new SimpleDateFormat("yyyy-MM-dd").format(Calendar
				.getInstance().getTime());
		// 将字符串日期转换成 java.sql.Date 日期类型
		return Date.valueOf(strDate);
	}

	/**
	* @Title: getDateByDay
	* @Description:  获取当前日期的前几天或者后几天日期
	* @param day 天数 负数代表前几天，正数代表后几天
	* @return
	* @throws
	 */
	public static Date getDateByDay(int day){
		// 获取当前日期
		Calendar date = Calendar.getInstance();
		date.set(Calendar.DATE, date.get(Calendar.DATE)+day);
		String strDate = new SimpleDateFormat("yyyy-MM-dd").format(date.getTime());
		// 将字符串日期转换成 java.sql.Date 日期类型
		return Date.valueOf(strDate);
	}

	/**
	* @Title: datetime
	* @Description: 获取当前日期 格式 2007－3－4 12：10：20 返回类型：Date 参数：null
	* @return
	* @throws
	 */
	public static Timestamp datetime() {
		// 获取当前日期
		String strTimestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
				.format(Calendar.getInstance().getTime());
		// 将字符串日期转换成 java.sql.Date 日期类型
		return Timestamp.valueOf(strTimestamp);
	}

	/**
	* @Title: datetimeByString
	* @Description: 获取当前日期 格式 2007－3－4 12：10：20 返回类型：Date 参数：null
	* @return
	* @throws
	 */
	public static String datetimeByString() {
		// 获取当前日期
		String strTimestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
				.format(Calendar.getInstance().getTime());
		// 将字符串日期转换成 java.sql.Date 日期类型
		return strTimestamp;
	}

	/**
	* @Title: time
	* @Description: 获取当前时间 格式 12：10：20 返回类型：Date 参数：null
	* @return
	* @throws
	 */
	public static Time timeNow() {
		// 获取当前日期
		String strTime = new SimpleDateFormat("HH:mm:ss").format(Calendar
				.getInstance().getTime());
		// 将字符串日期转换成 java.sql.Date 日期类型
		return Time.valueOf(strTime);
	}
	/**
	 * 取得当前的毫秒
	 * @Title: getCurrentDateMill
	 * @Description: 取得当前日期的String
	 * @param 
	 * @return 当前日期
	 * @throws
	 * @author wuhao08298
	 */
	public static String getCurrentDatemill(){
		String tDate = new String();
		Calendar Cld = Calendar.getInstance();
		tDate = tDate+Cld.get(Calendar.MILLISECOND);
		return tDate;
	}
	
	/**
	 * 取得当前日期
	 * @Title: getCurrentDate
	 * @Description: 取得当前日期的String
	 * @param aFormat 日期格式
	 * @return 当前日期
	 * @throws
	 */
	public static String getCurrentDate(String aFormat) {
		TimeZone time = TimeZone.getTimeZone("GMT+8"); //设置为东八区
		time = TimeZone.getDefault();// 这个是国际化所用的
		TimeZone.setDefault(time);// 设置时区
		Calendar calendar = Calendar.getInstance();// 获取实例
		DateFormat format1 = new SimpleDateFormat(aFormat);//构造格式化模板
		java.util.Date date = (java.util.Date) calendar.getTime(); //获取Date对象
		String tDate = format1.format(date);
        return tDate;
    }
	
	/**
	 * 获取当前日期。 <br>
	 * 获取的日期格式为yyyyMMddHHmmss
	 * 
	 * @return String - 返回当前日期
	 */
	public static String getCurrentDateTime() {
		// 获取当前日期
//		String strDate = new SimpleDateFormat("yyyyMMddHHmmss").format(Calendar
//				.getInstance().getTime());
		
		return getCurrentDate("yyyyMMddHHmmss");
	}
	/**
	 *获取当前14位时间+日期 
	 */
	public static String getCurrentDateTime14(){
		return getCurrentDate("yyyyMMddHHmmss");
	}
	/**
	 * 获取当前8位日期
	 */
	public static String getCurrentDate8(){
		return getCurrentDate("yyyyMMdd");
	}
	
	/**
	 * 获取当前6位日期
	 */
	public static String getCurrentDate6(){
		return getCurrentDate("yyyyMM");
	}
	
	/**
	 * 获取当前4位日期
	 */
	public static String getCurrentDate4(){
		return getCurrentDate("yyyy");
	}
	
	/**
	 * 获取当前6位时间
	 */
	public static String getCurrentTime6(){
		return getCurrentDate("HHmmss");
	}
	/**
	 * 获取当前时间
	 * @Method: getCurrentDate 
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @return
	 */
	public static java.util.Date getCurrentDate() {
		TimeZone time = TimeZone.getTimeZone("GMT+8"); //设置为东八区
		time = TimeZone.getDefault();// 这个是国际化所用的
		TimeZone.setDefault(time);// 设置时区
		Calendar calendar = Calendar.getInstance();// 获取实例
		java.util.Date date = (java.util.Date) calendar.getTime(); //获取Date对象
        return date;
    }
	/**
	 * 判断是否过期
	 * @Method: isOverDue 
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @param startDate 开始时间
	 * @param dueUnit 过期单位
	 * @param dueValue 过期值
	 * @return
	 */
	public static boolean isOverDue(Date startDate, String dueUnit, String dueValue){
		java.util.Date dueDate=getOverDue(startDate,dueUnit,dueValue);
		java.util.Date currDate=getCurrentDate();
		if(dueDate!=null&&dueDate.getTime()>currDate.getTime()){
			return true;
		}else{
			return false;
		}
	}
	/**
	 * 获取过期时间
	 * @Method: getOverDue 
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @param startDate
	 * @param dueUnit
	 * @param dueValue
	 * @return
	 */
	public static java.util.Date getOverDue(java.util.Date startDate, String dueUnit, String dueValue){
		/* 有效期单位:1-秒;2-分;3-小时;4-天;5-月;6-季;7-年 */ 
		java.util.Date dueDate=null;
		if(DUE_UNIT_SECOND.equals(dueUnit)){ 
			Calendar cal = Calendar.getInstance();
			cal.setTime(startDate); 
			cal.add(Calendar.SECOND, Integer.parseInt(dueValue));
			dueDate = cal.getTime(); 
		}else if(DUE_UNIT_MINUTE.equals(dueUnit)){ 
			Calendar cal = Calendar.getInstance();
			cal.setTime(startDate); 
			cal.add(Calendar.MINUTE, Integer.parseInt(dueValue));
			dueDate = cal.getTime(); 
		}else if(DUE_UNIT_HOUR.equals(dueUnit)){ 
			Calendar cal = Calendar.getInstance();
			cal.setTime(startDate); 
			cal.add(Calendar.HOUR_OF_DAY, Integer.parseInt(dueValue));
			dueDate = cal.getTime(); 
		}else if(DUE_UNIT_DAY.equals(dueUnit)){ 
			Calendar cal = Calendar.getInstance();
			cal.setTime(startDate); 
			cal.add(Calendar.DAY_OF_MONTH, Integer.parseInt(dueValue));
			dueDate = cal.getTime(); 
		}else if(DUE_UNIT_MONTH.equals(dueUnit)){ 
			Calendar cal = Calendar.getInstance();
			cal.setTime(startDate); 
			cal.add(Calendar.MONTH, Integer.parseInt(dueValue));
			dueDate = cal.getTime(); 
		}else if(DUE_UNIT_QUARTER.equals(dueUnit)){ 
			Calendar cal = Calendar.getInstance();
			cal.setTime(startDate); 
			cal.add(Calendar.MONTH, 3* Integer.parseInt(dueValue));
			dueDate = cal.getTime(); 
		}else if(DUE_UNIT_YEAR.equals(dueUnit)){ 
			Calendar cal = Calendar.getInstance();
			cal.setTime(startDate); 
			cal.add(Calendar.YEAR, Integer.parseInt(dueValue));
			dueDate = cal.getTime(); 
		}
		return dueDate;

	}
	
	/** 
	 * @Method: getFirstDayofMonth 
	 * @Description: 获取一个月的第一天
	 * @param month
	 * @return
	 */
	public static String getFirstDayofMonth(String month) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, Integer.parseInt(month.substring(0, 4)));
		cal.set(Calendar.MONTH, Integer.parseInt(month.substring(4, 6)));
		cal.set(Calendar.DAY_OF_MONTH, 1);
		cal.add(Calendar.MONTH, -1);
		return DateUtil.dateToString(cal.getTime(), "yyyyMMdd");
	}
	
	/** 
	 * @Method: getLastDayofMonth 
	 * @Description: 获取一个月的最后一天
	 * @param month
	 * @return
	 */
	public static String getLastDayofMonth(String month) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, Integer.parseInt(month.substring(0, 4)));
		cal.set(Calendar.MONTH, Integer.parseInt(month.substring(4, 6)));
		cal.set(Calendar.DAY_OF_MONTH, 1);
		cal.add(Calendar.DAY_OF_MONTH, -1);
		return DateUtil.dateToString(cal.getTime(), "yyyyMMdd");
	}
	
	
	/** 
	 * @Method: getLastMonth 
	 * @Description: 根据当前日期获取上一个月
	 * @param dateString
	 * @return
	 */
	public static String getLastMonth(String dateString){
		String lastYearMonth = "";
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(DateUtil.stringToDate(dateString, "yyyyMMdd"));
		cal.add(Calendar.MONTH, -1);
		lastYearMonth = DateUtil.dateToString(cal.getTime(), "yyyyMM");
		return lastYearMonth;
	}
	
	/**
	* @Title: main
	* @Description: 测试main方法
	* @param args
	* @throws
	 */
	public static void main(String[]args){
//		String strTimestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
//		
//		String str=DateUtil.dateToString(DateUtil.datetime(), "HH:mm:ss");
		System.out.println(DateUtil.getLastMonth("20140501"));
		System.out.println(DateUtil.getCurrentDateTime14());
		System.out.println(DateUtil.getCurrentDate8());
		//System.out.println(DateUtil.getCurrentTime6());
//		Date.valueOf(strTimestamp);
//		System.out.println(timeNow());
//		System.out.println(dateDiff(date(), stringToDate("2012-08-28", "yyyy-MM-dd") )/3600/24);
//		System.out.println(getDateByDay(-56));
//		System.out.println(datetimeByString());
//		System.out.println(DateUtil.stringToDate(strTimestamp, "yyyy-MM-dd HH:mm:ss"));
//		
//		System.out.println(DateUtil.getCurrentDate("yyyy-MM-dd HH:mm:ss"));
//		System.out.println(DateUtil.date());
//		System.out.println(DateUtil.getCurrentDate("HHmmss"));
//		java.util.Date cd=new java.util.Date();
//		System.out.println(dateToString(getOverDue(cd ,"1","5"),"yyyy-MM-dd HH:mm:ss"));
//		System.out.println(dateToString(getOverDue(cd ,"2","5"),"yyyy-MM-dd HH:mm:ss"));
//		System.out.println(dateToString(getOverDue(cd ,"3","15"),"yyyy-MM-dd HH:mm:ss"));
//		System.out.println(dateToString(getOverDue(cd ,"4","5"),"yyyy-MM-dd HH:mm:ss"));
//		System.out.println(dateToString(getOverDue(cd ,"5","5"),"yyyy-MM-dd HH:mm:ss"));
//		System.out.println(dateToString(getOverDue(cd ,"6","5"),"yyyy-MM-dd HH:mm:ss"));
//		System.out.println(dateToString(getOverDue(cd ,"7","5"),"yyyy-MM-dd HH:mm:ss"));
	}
	/**
	 * 获取的日期格式为yyyyMMdd
	 * @Method: getDate 
	 * @Description: 获取的日期格式为yyyyMMdd
	 * @param @return 返回当前日期
	 * @return String
	 */
	public static String getDate() {
		return getCurrentDate8();
	}
	
	/**
	 * 获取当前时间，格式HHmmss
	 * @Method: getTime 
	 * @Description: 获取当前时间，格式HHmmss
	 * @param @return 获取当前时间
	 * @return String
	 */
	public static String getTime() {
		return getCurrentTime6();
	}

}
