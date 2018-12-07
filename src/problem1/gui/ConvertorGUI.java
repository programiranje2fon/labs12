package problem1.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import problem1.poslovna_logika.Convertor;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConvertorGUI {

	private JFrame frmCurrencyConvertor;
	private JTextField dinField;
	private JTextField eurField;
	private Convertor convertor = new Convertor();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConvertorGUI window = new ConvertorGUI();
					window.frmCurrencyConvertor.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ConvertorGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCurrencyConvertor = new JFrame();
		frmCurrencyConvertor.setTitle("Currency convertor");
		frmCurrencyConvertor.setBounds(100, 100, 450, 300);
		frmCurrencyConvertor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCurrencyConvertor.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("RSD amount");
		lblNewLabel.setBounds(43, 51, 86, 14);
		frmCurrencyConvertor.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("EUR amount");
		lblNewLabel_1.setBounds(206, 51, 94, 14);
		frmCurrencyConvertor.getContentPane().add(lblNewLabel_1);
		
		dinField = new JTextField();
		dinField.setBounds(43, 86, 111, 20);
		frmCurrencyConvertor.getContentPane().add(dinField);
		dinField.setColumns(10);
		
		eurField = new JTextField();
		eurField.setBounds(206, 86, 111, 20);
		frmCurrencyConvertor.getContentPane().add(eurField);
		eurField.setColumns(10);
		
		JButton btnConvertDIE = new JButton("Convert DIE");
		btnConvertDIE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				double dinars = Double.parseDouble(dinField.getText());
				double euros = convertor.convertDIE(dinars);
				eurField.setText(""+euros);				
			}
		});
		btnConvertDIE.setBounds(43, 133, 111, 23);
		frmCurrencyConvertor.getContentPane().add(btnConvertDIE);
		
		JButton btnConvertEID = new JButton("Konvertuj EID");
		btnConvertEID.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double euros = Double.parseDouble(eurField.getText());
				double dinars = convertor.convertEID(euros);
				dinField.setText(""+dinars);
				
			}
		});
		btnConvertEID.setBounds(206, 133, 125, 23);
		frmCurrencyConvertor.getContentPane().add(btnConvertEID);
	}
}
