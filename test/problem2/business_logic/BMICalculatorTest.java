package problem2.business_logic;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import problem2.business_logic.BMICalculator;

public class BMICalculatorTest {

	private BMICalculator bmiCalculator;
	
	@Before
	public void setUp() throws Exception {
		bmiCalculator = new BMICalculator();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void method_calculateBMI() {
		double actual = bmiCalculator.calculateBMI(4, 4);
		assertEquals("BMI was not calculated well", 0.25, actual, 0.0001);
	}

}
