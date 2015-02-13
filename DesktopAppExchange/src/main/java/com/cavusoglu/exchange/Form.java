package com.cavusoglu.exchange;

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

import javax.swing.border.TitledBorder;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Form extends JFrame {

	protected static final String Message = null;
	private JPanel contentPane;
	private JTextField amountTextField;
	private JTextField resultTextField;
	MoneyExchange mnyexc = new MoneyExchange();
	private JTextField addentCurrencyAmountTextField;
	private JTextField resultOfSumTextField;
	private JTextField operationTextField;
	/**
	 * Launch the application.
	 */

	private double sumResult = 0.0;
	private JButton calcButton;
	SumOfCurrencies sc = new SumOfCurrencies();

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
		operationTextField.setText(operationTextField.getText() + amount + " "
				+ currencyUnit + " + ");

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
		tabbedPane.setBounds(33, 11, 539, 346);
		contentPane.add(tabbedPane);

		JPanel panel = new JPanel();
		tabbedPane.addTab("Convert", null, panel, null);
		panel.setLayout(null);

		JLabel lblFrom = new JLabel("From");
		lblFrom.setBounds(183, 35, 47, 14);
		panel.add(lblFrom);

		final JComboBox fromComboBox = new JComboBox();
		fromComboBox.setName("fromComboBox");
		fromComboBox.setBounds(183, 60, 93, 20);
		panel.add(fromComboBox);
		fromComboBox.setModel(new DefaultComboBoxModel(new String[] { "EUR",
				"USD", "TL", "GBP" }));

		JLabel lblTo = new JLabel("To");
		lblTo.setBounds(302, 35, 66, 14);
		panel.add(lblTo);

		final JComboBox toComboBox = new JComboBox();
		toComboBox.setName("toComboBox");
		toComboBox.setBounds(302, 60, 93, 20);
		panel.add(toComboBox);
		toComboBox.setModel(new DefaultComboBoxModel(new String[] { "EUR",
				"USD", "TL", "GBP" }));

		JLabel lblAmount = new JLabel("Amount");
		lblAmount.setBounds(56, 35, 73, 14);
		panel.add(lblAmount);

		amountTextField = new JTextField();
		amountTextField.setName("amountTextField");
		amountTextField.setBounds(56, 60, 86, 20);
		panel.add(amountTextField);
		amountTextField.setColumns(10);

		JLabel lblResult = new JLabel("Result");
		lblResult.setBounds(183, 228, 52, 14);
		panel.add(lblResult);

		resultTextField = new JTextField();
		resultTextField.setName("resultTextField");
		resultTextField.setBounds(183, 253, 86, 20);
		panel.add(resultTextField);
		resultTextField.setColumns(10);

		calcButton = new JButton("Calculate!");
		calcButton.setName("calcButton");
		calcButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				double result = 0;
				try {
					resultTextField.setText("");
					result = mnyexc.calculate(fromComboBox.getSelectedItem()
							.toString(), toComboBox.getSelectedItem()
							.toString(), Double.parseDouble(amountTextField
							.getText()));
					resultTextField.setText(String.format("%.04f", result));
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null,
							"Please enter a valid value to amount field!",
							Message, JOptionPane.ERROR_MESSAGE);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null,
							"Please check the inputs that you've given!",
							Message, JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		calcButton.setBounds(187, 139, 89, 23);
		panel.add(calcButton);

		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Sum", null, panel_1, null);
		panel_1.setLayout(null);

		JPanel AddentPanel = new JPanel();
		AddentPanel.setBorder(new TitledBorder(null, "Addent Info",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		AddentPanel.setBounds(36, 67, 406, 87);
		panel_1.add(AddentPanel);
		AddentPanel.setLayout(null);

		JComboBox addentUnitComboBox = new JComboBox();
		addentUnitComboBox.setName("addentUnitComboBox");
		addentUnitComboBox.setBounds(10, 56, 96, 20);
		AddentPanel.add(addentUnitComboBox);
		addentUnitComboBox.setModel(new DefaultComboBoxModel(new String[] {
				"EUR", "USD", "TL", "GBP" }));

		JLabel lblNewLabel = new JLabel("Addent Currency Unit");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel.setBounds(10, 31, 106, 14);
		AddentPanel.add(lblNewLabel);

		JLabel lblAddentCurrecyAmount = new JLabel("Addent Currency Amount\r\n");
		lblAddentCurrecyAmount.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblAddentCurrecyAmount.setBounds(137, 31, 129, 14);
		AddentPanel.add(lblAddentCurrecyAmount);

		addentCurrencyAmountTextField = new JTextField();
		addentCurrencyAmountTextField.setName("addentCurrencyAmountTextField");
		addentCurrencyAmountTextField.setBounds(141, 56, 96, 20);
		AddentPanel.add(addentCurrencyAmountTextField);
		addentCurrencyAmountTextField.setColumns(10);

		JPanel ResultInfoPanel = new JPanel();
		ResultInfoPanel.setBorder(new TitledBorder(null, "Result Info",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		ResultInfoPanel.setBounds(36, 11, 406, 45);
		panel_1.add(ResultInfoPanel);
		ResultInfoPanel.setLayout(null);

		JComboBox resultUnitComboBox = new JComboBox();
		resultUnitComboBox.setName("resultUnitComboBox");
		resultUnitComboBox.setName("resultUnitComboBox");
		resultUnitComboBox.setBounds(169, 17, 86, 20);
		ResultInfoPanel.add(resultUnitComboBox);
		resultUnitComboBox.setModel(new DefaultComboBoxModel(new String[] {
				"EUR", "USD", "TL", "GBP" }));

		JLabel lblOutputCurrencyUnit = new JLabel("Output Currency Unit\r\n:");
		lblOutputCurrencyUnit.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblOutputCurrencyUnit.setBounds(10, 20, 112, 14);
		ResultInfoPanel.add(lblOutputCurrencyUnit);

		JPanel yourOperationPanel = new JPanel();
		yourOperationPanel.setBorder(new TitledBorder(null, "Your Operation",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		yourOperationPanel.setBounds(46, 165, 406, 135);
		panel_1.add(yourOperationPanel);
		yourOperationPanel.setLayout(null);

		resultOfSumTextField = new JTextField();
		resultOfSumTextField.setName("resultOfSumTextField");
		resultOfSumTextField.setBounds(107, 58, 120, 20);
		yourOperationPanel.add(resultOfSumTextField);
		resultOfSumTextField.setColumns(10);
		resultOfSumTextField.setText("0.0");

		operationTextField = new JTextField();
		operationTextField.setName("operationTextField");
		operationTextField.setEditable(false);
		operationTextField.setBounds(41, 27, 250, 20);
		yourOperationPanel.add(operationTextField);
		operationTextField.setColumns(10);

		JLabel lblResult_1 = new JLabel("Result");
		lblResult_1.setBounds(51, 61, 46, 14);
		yourOperationPanel.add(lblResult_1);

		JLabel CurrencyUnitLabel = new JLabel("");
		CurrencyUnitLabel.setBounds(234, 61, 46, 14);
		yourOperationPanel.add(CurrencyUnitLabel);

		JButton addButton = new JButton("Add");
		addButton.setName("addButton");

		addButton.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {

				try {
					resultOfSumTextField.setText(sc.addCurrencies(
							addentUnitComboBox.getSelectedItem().toString(),
							resultUnitComboBox.getSelectedItem().toString(),
							Double.parseDouble(addentCurrencyAmountTextField
									.getText()), Double
									.parseDouble(resultOfSumTextField.getText()
											.replace(",", "."))));
					operationTextField.setText(sc.writeTheOperation(
							operationTextField.getText(),
							addentCurrencyAmountTextField.getText(),
							addentUnitComboBox.getSelectedItem().toString()));
					resultUnitComboBox.disable();
					CurrencyUnitLabel.setText(resultUnitComboBox
							.getSelectedItem().toString());

				} catch (Exception e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null,
							"Please check you've given valid inputs!", Message,
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		addButton.setBounds(291, 55, 89, 23);
		AddentPanel.add(addButton);

		JButton resetButton = new JButton("RESET");
		resetButton.setName("resetButton");
		resetButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				resultUnitComboBox.enable();
				operationTextField.setText("");
				sumResult = 0.0;
				resultOfSumTextField.setText("");
				addentCurrencyAmountTextField.setText("");
				CurrencyUnitLabel.setText("");
				resultOfSumTextField.setText("0.0");
			}
		});
		resetButton.setFont(new Font("Tahoma", Font.PLAIN, 10));
		resetButton.setBounds(73, 89, 118, 23);
		yourOperationPanel.add(resetButton);
	}
}
