package _01_chuckle_clicker;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ChuckleClicker implements ActionListener{
	
	JButton trick = new JButton("Trick");
	JButton treat = new JButton("Treat");
	
	public void showWindow() {
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		panel.add(trick);
		panel.add(treat);
		frame.add(panel);
		frame.pack();
		frame.setVisible(true);
		trick.addActionListener(this);
		treat.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton buttonPressed = (JButton) e.getSource();
		
		if(buttonPressed.equals(treat)) {
			showPictureFromTheInternet("https://i.pinimg.com/564x/7f/26/e7/7f26e71b2c84e6b16d4f6d3fd8a58bca.jpg");
		} else {
			showPictureFromTheInternet("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTMzeGukXOsppZpN35rJWRMpM-GK6ptiGxtMA&usqp=CAU");
		}
		
	}
	
	private void showPictureFromTheInternet(String imageUrl) {
	    try {
	        URL url = new URL(imageUrl);
	        Icon icon = new ImageIcon(url);
	        JLabel imageLabel = new JLabel(icon);
	        JFrame frame = new JFrame();
	        frame.add(imageLabel);
	        frame.setVisible(true);
	        frame.pack();
	    } catch (MalformedURLException e) {
	        e.printStackTrace();
	    }
	}
}
