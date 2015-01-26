import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class Form extends JFrame {

	private JPanel contentPane;
	private JTextField amountTextField;
	private JTextField resultTextField;
	MoneyExchange mnyexc=new MoneyExchange();
	/**
	 * Launch the application.
	 */
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

	/**
	 * Create the frame.
	 */
	public Form() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		final JComboBox fromComboBox = new JComboBox();
		fromComboBox.setModel(new DefaultComboBoxModel(new String[] {"EUR", "USD", "TL", "GBP"}));
		fromComboBox.setBounds(141, 50, 106, 20);
		contentPane.add(fromComboBox);
		
		final JComboBox toComboBox = new JComboBox();
		toComboBox.setModel(new DefaultComboBoxModel(new String[] {"EUR", "USD", "TL", "GBP"}));
		toComboBox.setBounds(285, 50, 99, 20);
		contentPane.add(toComboBox);
		
		amountTextField = new JTextField();
		amountTextField.setBounds(10, 50, 86, 20);
		contentPane.add(amountTextField);
		amountTextField.setColumns(10);
		
		JLabel lblAmount = new JLabel("Amount");
		lblAmount.setBounds(10, 29, 46, 14);
		contentPane.add(lblAmount);
		
		JLabel lblFrom = new JLabel("From");
		lblFrom.setBounds(141, 29, 46, 14);
		contentPane.add(lblFrom);
		
		JLabel lblTo = new JLabel("To");
		lblTo.setBounds(288, 29, 46, 14);
		contentPane.add(lblTo);
		
		JButton btnCalculate = new JButton("CALCULATE!");

		
		btnCalculate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

			double result=	mnyexc.calculate(fromComboBox.getSelectedItem().toString(), toComboBox.getSelectedItem().toString(), Double.parseDouble(amountTextField.getText()));	
	         
			resultTextField.setText(String.format("%.02f", result));			
			}
		});
		btnCalculate.setBounds(141, 112, 106, 23);
		contentPane.add(btnCalculate);
		
		resultTextField = new JTextField();
		resultTextField.setBounds(149, 179, 98, 20);
		contentPane.add(resultTextField);
		resultTextField.setColumns(10);
		
		JLabel lblResult = new JLabel("Result");
		lblResult.setBounds(149, 162, 46, 14);
		contentPane.add(lblResult);
	}
}
