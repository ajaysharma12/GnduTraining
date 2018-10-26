package com.gndu.islabs0002.abstraction.test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.gndu.islabs0002.abstraction.Car;
import com.gndu.islabs0002.abstraction.GearException;

public class TestCar {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	// @Test
	// public void test() {
	// fail("Not yet implemented");
	// }

	@Test
	public void TestSwitchGearsForGear2() {
		Car swift = new Car();

		try {
			Assert.assertEquals("Wrong Gear Returned !!", 0, swift.switchGears(2, "forward"));
			Assert.assertEquals("Failed", 0, swift.switchGears(3, "forward"));
		} catch (GearException ex) {
			System.out.println(ex.getMessage());
		}

	}

	@Test
	public void TestSwitchGearsForGear3() throws Exception {
		Car swift = new Car();
		Assert.assertEquals("Wrong Gear Returned !!", 0, swift.switchGears(2, "forward"));
	}

}
