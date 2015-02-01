package com.cavusoglu.exchange;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTabbedPane;

import java.awt.FlowLayout;

import javax.swing.border.TitledBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;

import java.awt.Color;

import javax.swing.border.MatteBorder;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Form extends JFrame {

	protected static final String Message = null;
	private JPanel contentPane;
	private JTextField amountTextField;
	private JTextField resultTextField;
	MoneyExchange mnyexc=new MoneyExchange();
	private JTextField addentCurrencyAmountTextField;
	private JTextField resultOfSumTextField;
	private JTextField OperationTextField;
	/**
	 * Launch the application.
	 */
	
	private double sumResult=0.0;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Form frame = new Form();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private void writeTheOperation(String amount, String currencyUnit) {
		// TODO Auto-generated method stub
		OperationTextField.setText(OperationTextField.getText()+amount+" "+currencyUnit+" + ");
		

	}

	/**
	 * Create the frame.
	 */
	public Form() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 645, 406);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(29, 11, 539, 346);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Convert", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblFrom = new JLabel("From");
		lblFrom.setBounds(183, 35, 47, 14);
		panel.add(lblFrom);
		
		final JComboBox fromComboBox = new JComboBox();
		fromComboBox.setBounds(183, 60, 93, 20);
		panel.add(fromComboBox);
		fromComboBox.setModel(new DefaultComboBoxModel(new String[] {"EUR", "USD", "TL", "GBP"}));
		
		JLabel lblTo = new JLabel("To");
		lblTo.setBounds(302, 35, 66, 14);
		panel.add(lblTo);
		
		final JComboBox toComboBox = new JComboBox();
		toComboBox.setBounds(302, 60, 93, 20);
		panel.add(toComboBox);
		toComboBox.setModel(new DefaultComboBoxModel(new String[] {"EUR", "USD", "TL", "GBP"}));
		
		JLabel lblAmount = new JLabel("Amount");
		lblAmount.setBounds(56, 35, 73, 14);
		panel.add(lblAmount);
		
		amountTextField = new JTextField();
		amountTextField.setBounds(56, 60, 86, 20);
		panel.add(amountTextField);
		amountTextField.setColumns(10);
		
		JLabel lblResult = new JLabel("Result");
		lblResult.setBounds(183, 228, 52, 14);
		panel.add(lblResult);
		
		JButton btnCalculate = new JButton("CALCULATE!");
		btnCalculate.setBounds(184, 146, 93, 23);
		panel.add(btnCalculate);
		
		resultTextField = new JTextField();
		resultTextField.setBounds(183, 253, 86, 20);
		panel.add(resultTextField);
		resultTextField.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Sum", null, panel_1, null);
		panel_1.setLayout(null);
		
		JPanel AddentPanel = new JPanel();
		AddentPanel.setBorder(new TitledBorder(null, "Addent Info", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		AddentPanel.setBounds(36, 67, 406, 87);
		panel_1.add(AddentPanel);
		AddentPanel.setLayout(null);
		
		JComboBox addentUnitComboBox = new JComboBox();
		addentUnitComboBox.setBounds(10, 56, 96, 20);
		AddentPanel.add(addentUnitComboBox);
		addentUnitComboBox.setModel(new DefaultComboBoxModel(new String[] {"EUR", "USD", "TL", "GBP"}));
		
		JLabel lblNewLabel = new JLabel("Addent Currency Unit");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel.setBounds(10, 31, 106, 14);
		AddentPanel.add(lblNewLabel);
		
		JLabel lblAddentCurrecyAmount = new JLabel("Addent Currency Amount\r\n");
		lblAddentCurrecyAmount.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblAddentCurrecyAmount.setBounds(137, 31, 129, 14);
		AddentPanel.add(lblAddentCurrecyAmount);
		
		addentCurrencyAmountTextField = new JTextField();
		addentCurrencyAmountTextField.setBounds(141, 56, 96, 20);
		AddentPanel.add(addentCurrencyAmountTextField);
		addentCurrencyAmountTextField.setColumns(10);
		
		
		
		JPanel ResultInfoPanel = new JPanel();
		ResultInfoPanel.setBorder(new TitledBorder(null, "Result Info", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		ResultInfoPanel.setBounds(36, 11, 406, 45);
		panel_1.add(ResultInfoPanel);
		ResultInfoPanel.setLayout(null);
		
		JComboBox resultUnitComboBox = new JComboBox();
		resultUnitComboBox.setBounds(169, 17, 86, 20);
		ResultInfoPanel.add(resultUnitComboBox);
		resultUnitComboBox.setModel(new DefaultComboBoxModel(new String[] {"EUR", "USD", "TL", "GBP"}));
		
		JLabel lblOutputCurrencyUnit = new JLabel("Output Currency Unit\r\n:");
		lblOutputCurrencyUnit.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblOutputCurrencyUnit.setBounds(10, 20, 112, 14);
		ResultInfoPanel.add(lblOutputCurrencyUnit);
		
		JPanel yourOperationPanel = new JPanel();
		yourOperationPanel.setBorder(new TitledBorder(null, "Your Operation", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		yourOperationPanel.setBounds(46, 165, 406, 135);
		panel_1.add(yourOperationPanel);
		yourOperationPanel.setLayout(null);
		
		resultOfSumTextField = new JTextField();
		resultOfSumTextField.setBounds(107, 58, 120, 20);
		yourOperationPanel.add(resultOfSumTextField);
		resultOfSumTextField.setColumns(10);
		
		OperationTextField = new JTextField();
		OperationTextField.setEditable(false);
		OperationTextField.setBounds(41, 27, 250, 20);
		yourOperationPanel.add(OperationTextField);
		OperationTextField.setColumns(10);
		
		JLabel lblResult_1 = new JLabel("Result");
		lblResult_1.setBounds(51, 61, 46, 14);
		yourOperationPanel.add(lblResult_1);
		
		
		
		
		
		
		
	
		
		JLabel CurrencyUnitLabel = new JLabel("");
		CurrencyUnitLabel.setBounds(234, 61, 46, 14);
		yourOperationPanel.add(CurrencyUnitLabel);
		
		
		JButton AddButton = new JButton("Add");
		AddButton.addMouseListener(new MouseAdapter() {
			

			@Override
			public void mouseClicked(MouseEvent e) {
		
				try {
					sumResult += mnyexc.calculate(addentUnitComboBox.getSelectedItem().toString(),resultUnitComboBox.getSelectedItem().toString(), Double.parseDouble(addentCurrencyAmountTextField.getText()));
				    resultOfSumTextField.setText(String.format("%.02f", sumResult));
					writeTheOperation(addentCurrencyAmountTextField.getText(), addentUnitComboBox.getSelectedItem().toString());
					resultUnitComboBox.disable();
					CurrencyUnitLabel.setText(resultUnitComboBox.getSelectedItem().toString());
					
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "Please check you've given valid inputs!", Message, JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		AddButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		AddButton.setBounds(291, 55, 89, 23);
		AddentPanel.add(AddButton);
		
		
		
		
		
		JButton ResetButton = new JButton("RESET");
		ResetButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			   resultUnitComboBox.enable();
			   OperationTextField.setText("");
			   sumResult=0.0;
			   resultOfSumTextField.setText("");
			   addentCurrencyAmountTextField.setText("");
			   CurrencyUnitLabel.setText("");
			}
		});
		ResetButton.setFont(new Font("Tahoma", Font.PLAIN, 10));
		ResetButton.setBounds(73, 89, 118, 23);
		yourOperationPanel.add(ResetButton);
		
				
				btnCalculate.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
		
					double result = 0;
					try {
						resultTextField.setText("");
						result = mnyexc.calculate(fromComboBox.getSelectedItem().toString(), toComboBox.getSelectedItem().toString(), Double.parseDouble(amountTextField.getText()));
						resultTextField.setText(String.format("%.02f", result));			
					} catch (NumberFormatException e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, "Please enter a valid value to amount field!", Message, JOptionPane.ERROR_MESSAGE);
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "Please check the inputs that you've given!", Message, JOptionPane.ERROR_MESSAGE);
					}	
			         
					}
				});
	}
}