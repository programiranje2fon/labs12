package problem1.gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import problem1.business_logic.Converter;

public class ConverterGUI extends JFrame {

	private static final long serialVersionUID = 1L;

	private Converter converter = new Converter();

	private JPanel contentPane;
	private JLabel lblAmountRSD;
	private JLabel lblAmountEUR;
	private JTextField rsdField;
	private JTextField eurField;
	private JButton btnConvertDiE;
	private JButton btnConvertEiD;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConverterGUI frame = new ConverterGUI();
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
	public ConverterGUI() {
		setTitle("Money converter");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblAmountRSD());
		contentPane.add(getLblAmountEUR());
		contentPane.add(getRSDField());
		contentPane.add(getEURField());
		contentPane.add(getBtnConvertDIE());
		contentPane.add(getBtnKonvertujEud());
	}

	private JLabel getLblAmountRSD() {
		if (lblAmountRSD == null) {
			lblAmountRSD = new JLabel("Amount RSD");
			lblAmountRSD.setBounds(66, 82, 78, 14);
		}
		return lblAmountRSD;
	}

	private JLabel getLblAmountEUR() {
		if (lblAmountEUR == null) {
			lblAmountEUR = new JLabel("Amount EUR");
			lblAmountEUR.setBounds(217, 82, 91, 14);
		}
		return lblAmountEUR;
	}

	private JTextField getRSDField() {
		if (rsdField == null) {
			rsdField = new JTextField();
			rsdField.setBounds(66, 109, 103, 20);
			rsdField.setColumns(10);
		}
		return rsdField;
	}

	private JTextField getEURField() {
		if (eurField == null) {
			eurField = new JTextField();
			eurField.setBounds(217, 109, 113, 20);
			eurField.setColumns(10);
		}
		return eurField;
	}

	private JButton getBtnConvertDIE() {
		if (btnConvertDiE == null) {
			btnConvertDiE = new JButton("Convert RSD to Euros");
			btnConvertDiE.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					double rsd = Double.parseDouble(rsdField.getText());
					double eur = converter.convertDIE(rsd);
					eurField.setText("" + eur);
				}
			});
			btnConvertDiE.setBounds(66, 159, 103, 23);
		}
		return btnConvertDiE;
	}

	private JButton getBtnKonvertujEud() {
		if (btnConvertEiD == null) {
			btnConvertEiD = new JButton("Convert Euros to RSD");
			btnConvertEiD.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					double euros = Double.parseDouble(eurField.getText());
					double rsd = converter.convertEID(euros);
					rsdField.setText("" + rsd);
				}
			});
			btnConvertEiD.setBounds(217, 159, 113, 23);
		}
		return btnConvertEiD;
	}
}
