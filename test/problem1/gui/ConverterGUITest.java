package problem1.gui;

import static org.junit.Assert.*;

import java.lang.reflect.Field;

import javax.swing.JTextField;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import problem1.gui.ConverterGUI;

public class ConverterGUITest {

	ConverterGUI gui;
	
	@Before
	public void setUp() throws Exception {
		gui = new ConverterGUI();
	}

	@After
	public void tearDown() throws Exception {
		gui = null;
	}

	@Test
	public void tekstualnaPoljaKonvertorGUI() {

		try {
			Field dinField = ConverterGUI.class.getDeclaredField("dinField");
			dinField.setAccessible(true);
			JTextField dinTextField = (JTextField) dinField.get(gui);	
		} catch (NoSuchFieldException e) {
			fail("There is no field to enter dinar amount.");
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			Field eurField = ConverterGUI.class.getDeclaredField("eurField");
			eurField.setAccessible(true);
			JTextField eurTextField = (JTextField) eurField.get(gui);					
		} catch (NoSuchFieldException e) {
			fail("There is no field to enter euro amount.");
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		

	}

}
