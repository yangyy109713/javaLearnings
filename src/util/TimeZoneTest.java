package util;

import java.util.TimeZone;

import org.junit.Test;

public class TimeZoneTest {
	@Test
	public void test(){
		TimeZone tz = TimeZone.getDefault();
		System.out.println(tz.toString());
		System.out.println(tz.getDisplayName());
		System.out.println(tz.getID());
		System.out.println(tz.getDSTSavings());
		System.out.println(tz.toZoneId());
	}
	
}
