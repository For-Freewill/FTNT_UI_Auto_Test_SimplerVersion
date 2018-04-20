package ftnt.qa.autotest.ui.fortisiem.testcases;


import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import ftnt.qa.autotest.ui.framework.testbase.TestBase;

public class Credentials extends TestBase{

	@Test
	public void test1() {
		sleep(5000);
		System.out.println(">>>test1");
	}

	@Test
	public void test2() {
		sleep(3000);
		System.out.println(">>>test2");
	}

	@Test
	public void test3() {
		sleep(2000);
		System.out.println(">>>test3");
	}

	@Test
	public void test4() {
		sleep(5000);
		System.out.println(">>>test4");
	}

	@Test
	public void test5() {
		sleep(5000);
		System.out.println(">>>test5");
	}

	private void sleep(long time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
