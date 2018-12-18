package problem2.gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import problem2.business_logic.BMICalculator;

public class BMICalculatorGUI extends JFrame {

	private static final long serialVersionUID = 1L;

	private BMICalculator bmiCalculator = new BMICalculator();
	
	private JPanel contentPane;
	private JLabel lblHeight;
	private JLabel lblWeight;
	private JTextField heightField;
	private JTextField weightField;
	private JButton btnCalculateBMI;
	private JLabel lblBmi;
	private JTextField bmiField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BMICalculatorGUI frame = new BMICalculatorGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public BMICalculatorGUI() {
		setTitle("BMI Calculator");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 296, 279);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblHeight());
		contentPane.add(getLblWeight());
		contentPane.add(getHeightField());
		contentPane.add(getWeightField());
		contentPane.add(getBtnIzracunajBmi());
		contentPane.add(getLblBmi());
		contentPane.add(getBmiField());
	}

	private JLabel getLblHeight() {
		if (lblHeight == null) {
			lblHeight = new JLabel("Height:");
			lblHeight.setBounds(35, 40, 46, 14);
		}
		return lblHeight;
	}

	private JLabel getLblWeight() {
		if (lblWeight == null) {
			lblWeight = new JLabel("Weight:");
			lblWeight.setBounds(35, 90, 46, 14);
		}
		return lblWeight;
	}

	private JTextField getHeightField() {
		if (heightField == null) {
			heightField = new JTextField();
			heightField.setBounds(123, 37, 136, 20);
			heightField.setColumns(10);
		}
		return heightField;
	}

	private JTextField getWeightField() {
		if (weightField == null) {
			weightField = new JTextField();
			weightField.setBounds(123, 87, 136, 20);
			weightField.setColumns(10);
		}
		return weightField;
	}

	private JButton getBtnIzracunajBmi() {
		if (btnCalculateBMI == null) {
			btnCalculateBMI = new JButton("Calculate BMI");
			btnCalculateBMI.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					double height = Double.parseDouble(heightField.getText());
					double weight = Double.parseDouble(weightField.getText());
					double bmi = bmiCalculator.calculateBMI(height, weight);
					bmiField.setText("" + bmi);
				}
			});
			btnCalculateBMI.setBounds(35, 142, 131, 23);
		}
		return btnCalculateBMI;
	}

	private JLabel getLblBmi() {
		if (lblBmi == null) {
			lblBmi = new JLabel("BMI:");
			lblBmi.setBounds(35, 205, 61, 14);
		}
		return lblBmi;
	}

	private JTextField getBmiField() {
		if (bmiField == null) {
			bmiField = new JTextField();
			bmiField.setBounds(123, 202, 136, 20);
			bmiField.setColumns(10);
		}
		return bmiField;
	}
}
