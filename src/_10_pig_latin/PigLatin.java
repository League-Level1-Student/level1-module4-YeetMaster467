package _10_pig_latin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class PigLatin implements ActionListener{
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JTextField input1 = new JTextField(20);
	JButton button1 = new JButton(">>");
	JButton button2 = new JButton("<<");
	JTextField input2 = new JTextField(20);
	JButton speak = new JButton("speak");
	
	public void showWindow() {
		panel.add(input1);
		panel.add(button1);
		panel.add(button2);
		panel.add(input2);
		panel.add(speak);
		frame.add(panel);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(3);
		frame.pack();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton buttonPressed = (JButton) e.getSource();
		
		if(buttonPressed.equals(button1)) {
			String input = input2.getText();
			
		}
	}
	
}
