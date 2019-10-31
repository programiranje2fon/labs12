package problem1.business_logic;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import problem1.business_logic.Converter;

public class ConverterTest {

	private Converter converter;
	
	@Before
	public void setUp() throws Exception {
		converter = new Converter();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void method_convertDinarsToEuro() {
		double actual = converter.convertDinarsToEuros(240);
		assertEquals("Dinars to euros conversion is not being calculated well", 2, actual, 0.01);
	}

	@Test
	public void method_convertEurosToDinars() {
		double actual = converter.convertEurosToDinars(10);
		assertEquals("Euros to dinars conversion is not being calculated well", 1200, actual, 0.01);
	}

}
