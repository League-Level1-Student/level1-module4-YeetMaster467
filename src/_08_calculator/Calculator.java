/*
 * © Eli Comix inc. 2022
 */

package _08_calculator;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculator implements ActionListener {
	
	// Initializing global variables
	
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JLabel output = new JLabel("0");
	JTextField input1 = new JTextField(10);
	JTextField input2 = new JTextField(10);
	JButton add = new JButton("+");
	JButton sub = new JButton("-");
	JButton mul = new JButton("x");
	JButton div = new JButton("÷");
	
	
	// Initializing frame variables, optimizing and showing the window.
	
	public void show() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel.setLayout(new GridLayout(5,2));
		output.setFont(output.getFont().deriveFont(28.0f));
		output.setHorizontalAlignment(JLabel.CENTER);
		panel.add(input1);
		panel.add(input2);
		frame.add(panel);
		frame.pack();
		panel.add(add);
		panel.add(sub);
		panel.add(mul);
		panel.add(div);
		panel.add(output);
		frame.add(panel);
		frame.add(panel);
		frame.pack();
		frame.setVisible(true);
		add.addActionListener(this);
		sub.addActionListener(this);
		mul.addActionListener(this);
		div.addActionListener(this);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton buttonPressed = (JButton) e.getSource();
		
		
		if(buttonPressed==add) {	// Takes the 2 inputs and adds them and outputs them by changing the label.
			
			String j = input1.getText();
			String k = input2.getText();
			
			try {
				double l = Double.parseDouble(j);
				double n = Double.parseDouble(k);
				output.setText("" + (l+n));
				
			} catch (Exception i) {
				JOptionPane.showMessageDialog(null, "Enter two numbers.");
				input1.setText("");
				input2.setText("");
			}
		}
		
		if(buttonPressed==sub) {	// Takes the 2 inputs and subtracts them and outputs them by changing the label.
			
			String j = input1.getText();
			String k = input2.getText();
			
			try {
				double l = Double.parseDouble(j);
				double n = Double.parseDouble(k);
				output.setText("" + (l-n));
				
			} catch (Exception i) {
				JOptionPane.showMessageDialog(null, "Enter two numbers.");
				input1.setText("");
				input2.setText("");
			}
		}
		
		if(buttonPressed==mul) {	// Takes the 2 inputs and multiplies them and outputs them by changing the label.
			
			String j = input1.getText();
			String k = input2.getText();
			
			try {
				double l = Double.parseDouble(j);
				double n = Double.parseDouble(k);
				output.setText("" + (l*n));
				
			} catch (Exception i) {
				JOptionPane.showMessageDialog(null, "Enter two numbers.");
				input1.setText("");
				input2.setText("");
			}
		}
		
		if(buttonPressed==div) {	// Takes the 2 inputs and divides them and outputs them by changing the label.
			
			String j = input1.getText();
			String k = input2.getText();
			
			try {
				double l = Double.parseDouble(j);
				double n = Double.parseDouble(k);
				output.setText("" + (l/n));
				
			} catch (Exception i) {
				JOptionPane.showMessageDialog(null, "Enter two numbers.");
				input1.setText("");
				input2.setText("");
			}
		}
		
		frame.pack();
	}
}
