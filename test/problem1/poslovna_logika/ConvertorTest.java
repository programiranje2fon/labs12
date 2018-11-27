package problem1.poslovna_logika;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import problem1.poslovna_logika.Convertor;

public class ConvertorTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void method_convertDIE() {
		double actual = Convertor.convertDIE(240);
		assertEquals("Dinars to euros conversion is not being calculated well", 2, actual, 0.01);
	}

	@Test
	public void testConvertEID() {
		double actual = Convertor.convertEID(10);
		assertEquals("Euros to dilars conversion is not being calculated well", 1200, actual, 0.01);
	}

}
