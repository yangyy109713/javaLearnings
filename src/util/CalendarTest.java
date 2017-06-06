package util;

import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

public class CalendarTest {
	@Test
	public void calenTest(){
		Calendar ca = Calendar.getInstance();
		int first = ca.getFirstDayOfWeek();
		int lastest = ca.getMinimalDaysInFirstWeek();
		int weeksNum = ca.getWeeksInWeekYear();//当年有多少个星期
		ca.set(1999,8,31);
		ca.set(Calendar.MONTH, Calendar.SEPTEMBER);//sets the date to September 31, 1999
		//ca.set(Calendar.DAY_OF_MONTH, 30);//将每月日期设为30天,ca.getTime()输出：Thu Sep 30 10:41:21 CST 1999
		Date time = ca.getTime();//输出：Fri Oct 01 10:42:56 CST 1999
		System.out.println("time:"+time.toString());
		System.out.println("first:"+first+" ,lastest:"+lastest+" ,weeksNum:"+weeksNum);
		
		System.out.println("all_styles:"+ca.get(Calendar.ALL_STYLES));
		
		
	}
}
