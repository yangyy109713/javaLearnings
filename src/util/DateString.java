package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.junit.Test;

public class DateString {
	
	/**
	 * 通过SimpleDateFormat 获取日期/时间。有多种格式可以选择
	 */
	private void testSimpleDateFormats() {
	    String[] formats = new String[] {
	      "HH:mm",                // 14:22
	      "h:mm a",                // 2:22 下午
	      "HH:mm z",               // 14:22 CST
	      "HH:mm Z",               // 14:22 +0800
	      "HH:mm zzzz",              // 14:22 中国标准时间
	      "HH:mm:ss",               // 14:22:30
	      "yyyy-MM-dd",              // 2013-09-19
	      "yyyy-MM-dd HH:mm",           // 2013-09-19 14:22
	      "yyyy-MM-dd HH:mm:ss",         // 2013-09-19 14:22:30
	      "yyyy-MM-dd HH:mm:ss zzzz",       // 2013-09-19 14:22:30 中国标准时间
	      "EEEE yyyy-MM-dd HH:mm:ss zzzz",    // 星期四 2013-09-19 14:22:30 中国标准时间
	      "yyyy-MM-dd HH:mm:ss.SSSZ",       // 2013-09-19 14:22:30.000+0800
	      "yyyy-MM-dd'T'HH:mm:ss.SSSZ",      // 2013-09-19T14:22:30.000+0800
	      "yyyy.MM.dd G 'at' HH:mm:ss z",     // 2013.09.19 公元 at 14:22:30 CST
	      "K:mm a",                // 2:22 下午, CST
	      "EEE, MMM d, ''yy",           // 星期四, 九月 19, '13
	      "hh 'o''clock' a, zzzz",        // 02 o'clock 下午, 中国标准时间
	      "yyyyy.MMMMM.dd GGG hh:mm aaa",     // 02013.九月.19 公元 02:22 下午
	      "EEE, d MMM yyyy HH:mm:ss Z",      // 星期四, 19 九月 2013 14:22:30 +0800
	      "yyMMddHHmmssZ",            // 130919142230+0800
	      "yyyy-MM-dd'T'HH:mm:ss.SSSZ",      // 2013-09-19T14:22:30.000+0800
	      "EEEE 'DATE('yyyy-MM-dd')' 'TIME('HH:mm:ss')' zzzz",    // 星期四 2013-09-19 14:22:30 中国标准时间
	    };
	 
	    //Date date = (new Date(0));          // date为1970-01-01 07:00:00
	    //Date date = Calendar.getInstance().getTime(); // date为当前时间
	    Date date = new Date(113, 8, 19, 14, 22, 30);  // date为2013-09-19 14:22:30
	    for (String format : formats) {
	      SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.SIMPLIFIED_CHINESE);
	      //SimpleDateFormat sdf = new SimpleDateFormat(format);
	      System.out.format("%30s  %s\n", format, sdf.format(date));
	     }
	  }
	  
	@Test
	public void testdate(){
		Date date = new Date();
		System.out.println(date);
		//System.out.println(date.toString());//打印结果和上面语句一致
		//日期串的格式
		String str1 = "yyyy-MM-dd";
		String str2 = "yyyy-MM-dd HH:mm:ss";
		String str3 = "yyyy年MM月dd日 HH:mm:ss";
		String str4 = "yyyy年MM月dd日 HH时mm分ss秒";
		String str5 = "yyyy/MM/dd HH/mm/ss";
		System.out.println(dateToStr(date,str1));
		System.out.println(dateToStr(date,str2));
		System.out.println(dateToStr(date,str3));
		System.out.println(dateToStr(date,str4));
		System.out.println(dateToStr(date,str5));
		
		String string1 = "2017-06-01";
		String string2 = "2017-06-01 14:20:01";
		String string3 = "2017年06月01日 14:20:01";
		String string4 = "2017年06月01日 14时20分01秒";
		String string5 = "2017/06/01 14/20/01";
		System.out.println(stringToDate(string1,str1));
		System.out.println(stringToDate(string2,str2));
		System.out.println(stringToDate(string3,str3));
		System.out.println(stringToDate(string4,str4));
		System.out.println(stringToDate(string5,str5));
		//给定的格式不能比字符串多，可以比字符串少
		//System.out.println(stringToDate(string1,str5));//会报错
		System.out.println(stringToDate(string2,str1));
		
		testSimpleDateFormats();
	}
	
	/**
	 * 根据给定的日期和格式，转换成对应的String
	 * @param date 日期
	 * @param strStyle 格式
	 * @return
	 */
	public String dateToStr(Date date,String strStyle){
		SimpleDateFormat sdf = new SimpleDateFormat(strStyle);//定义转换的格式
		return sdf.format(date);
	}
	
	/**
	 * 根据给定日期字符串和格式，转换成Date
	 * @param str 日期字符串
	 * @param strStyle 格式
	 * @return
	 */
	public Date stringToDate(String str,String strStyle){
		SimpleDateFormat sdf = new SimpleDateFormat(strStyle);
		try {
			return sdf.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}
}
