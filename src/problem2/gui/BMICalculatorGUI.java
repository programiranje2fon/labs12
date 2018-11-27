package problem2.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import problem2.business_logic.BMICalculator;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BMICalculatorGUI {

	private JFrame frmBMICalculator;
	private JTextField heightField;
	private JTextField weightField;
	private JTextField bmiField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BMICalculatorGUI window = new BMICalculatorGUI();
					window.frmBMICalculator.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public BMICalculatorGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBMICalculator = new JFrame();
		frmBMICalculator.setTitle("BMI Calculator");
		frmBMICalculator.setBounds(100, 100, 270, 300);
		frmBMICalculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBMICalculator.getContentPane().setLayout(null);
		
		JLabel lblVisina = new JLabel("Height:");
		lblVisina.setBounds(26, 32, 46, 14);
		frmBMICalculator.getContentPane().add(lblVisina);
		
		JLabel lblTezina = new JLabel("Weight:");
		lblTezina.setBounds(26, 76, 46, 14);
		frmBMICalculator.getContentPane().add(lblTezina);
		
		heightField = new JTextField();
		heightField.setBounds(133, 29, 86, 20);
		frmBMICalculator.getContentPane().add(heightField);
		heightField.setColumns(10);
		
		weightField = new JTextField();
		weightField.setBounds(133, 73, 86, 20);
		frmBMICalculator.getContentPane().add(weightField);
		weightField.setColumns(10);
		
		JButton btnCalculateBMI = new JButton("Calculate BMI");
		btnCalculateBMI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double height = Double.parseDouble(heightField.getText());
				double weight = Double.parseDouble(weightField.getText());
				double bmi = BMICalculator.calculateBMI(height, weight);
				bmiField.setText(""+bmi);				
			}
		});
		btnCalculateBMI.setBounds(58, 129, 105, 23);
		frmBMICalculator.getContentPane().add(btnCalculateBMI);
		
		JLabel lblBmi = new JLabel("BMI:");
		lblBmi.setBounds(26, 190, 38, 14);
		frmBMICalculator.getContentPane().add(lblBmi);
		
		bmiField = new JTextField();
		bmiField.setBounds(133, 187, 86, 20);
		frmBMICalculator.getContentPane().add(bmiField);
		bmiField.setColumns(10);
	}

}
