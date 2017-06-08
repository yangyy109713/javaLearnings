package util;

import java.util.ArrayList;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.JUnitCore;
import org.junit.Rule;

import java.util.List;

import static org.junit.Assert.fail;
import static org.junit.Assert.assertThat;

public class TestException {
	/* new ArrayList<Object>().get(0);//This code should throw an IndexOutOfBoundsException. 
	 * The @Test annotation has an optional parameter "expected" that takes as values subclasses of Throwable.
	 * If we wanted to verify that ArrayList throws the correct exception, we would write:
	 */
	
	@Test(expected = IndexOutOfBoundsException.class)
	//添加了"expected"后，运行该Test不会再抛出IndexOutOfBoundsException异常
	//有任何一行代码抛出IndexOutOfBoundsException异常，test都会通过
	public void testEmpty(){
		new ArrayList<Object>().get(0);
	}
	
	//@Test
	public void testExceptionMessage(){
		try{
			new ArrayList<Object>().get(0);
			fail("Expected an IndexOutOfBoundsException to be thrown");
		}catch(IndexOutOfBoundsException anException){
			//assertThat(anException.getMessage(),is("Index: 0,Size: 0"));//JUnit 3.8.x 版本才支持
		}
	}
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void shouldTestExceptionMessage() throws IndexOutOfBoundsException {
		List<Object> list = new ArrayList<Object>();
		thrown.expect(IndexOutOfBoundsException.class);
		thrown.expectMessage("Index: 0, Size: 0");
		thrown.expectMessage(Matchers.containsString("Size: 0"));
		list.get(0);// execution will never get past this line
	}
	
	@Test
	public void testGetVersion(){
		JUnitCore juc = new JUnitCore();
		String version = juc.getVersion();
		System.out.println("JUnit-version:"+version);//输出JUnit-version:4.11
	}
	
}
