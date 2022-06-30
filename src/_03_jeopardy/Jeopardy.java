package _03_jeopardy;


/*
 *    Copyright (c) The League of Amazing Programmers 2013-2019
 *    Level 1
 */


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


/* Check out the Jeopardy Handout to see what the end result should look like: http://bit.ly/1bvnvd4 */

public class Jeopardy implements ActionListener {
	private JButton firstButton;
	private JButton secondButton;
	private JButton thirdButton, fourthButton, fithButton;
	private JPanel quizPanel;
	private int score = 0;
	private JLabel scoreBox = new JLabel("0");
	private int buttonCount = 0;
	private Clip jeopardyThemeClip;



	public void run() {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		quizPanel = new JPanel();
		frame.setLayout(new BorderLayout());

		// 1. Make the frame show up
		frame.setVisible(true);
		// 2. Give your frame a title
		frame.setTitle("Jeopardy");
		// 3. Create a JPanel variable to hold the header using the createHeader method
		JPanel header1 = createHeader("History");
		// 4. Add the header component to the quizPanel
		quizPanel.add(header1);
		// 5. Add the quizPanel to the frame
		frame.add(quizPanel);
		// 6. Use the createButton method to set the value of firstButton
		firstButton = createButton("$200");
		// 7. Add the firstButton to the quizPanel
		quizPanel.add(firstButton);
		// 8. Write the code to complete the createButton() method below. Check that your
		// game looks like Figure 1 in the Jeopardy Handout - http://bit.ly/1bvnvd4.
		
		// 9. Use the secondButton variable to hold a button using the createButton
		// method
		secondButton = createButton("$400");
		// 10. Add the secondButton to the quizPanel
		quizPanel.add(secondButton);
		// 11. Add action listeners to the buttons (2 lines of code)
		firstButton.addActionListener(this);
		secondButton.addActionListener(this);
		// 12. Write the code to complete the actionPerformed() method below
		
		// 13. Add buttons so that you have $200, $400, $600, $800 and $1000 questions
		thirdButton = createButton("$600");
		thirdButton.addActionListener(this);
		
		fourthButton = createButton("$800");
		fourthButton.addActionListener(this);
		
		fithButton = createButton("$1000");
		fithButton.addActionListener(this);
		 /*
		 * [optional] Use the showImage or playSound methods when the user answers a
		 * question
		 */		
		
		frame.pack();
		quizPanel.setLayout(new GridLayout(buttonCount + 1, 3));
		frame.add(makeScorePanel(), BorderLayout.NORTH);
		frame.setSize(Toolkit.getDefaultToolkit().getScreenSize().height,
				Toolkit.getDefaultToolkit().getScreenSize().width);
	}


	private JButton createButton(String dollarAmount) {
		
		// Create a new JButton
		JButton button = new JButton();
		// Set the text of the button to the dollarAmount
		button.setText(dollarAmount);
		// Increment the buttonCount (this should make the layout vertical)
		buttonCount++;
		// Return your new button instead of the temporary button

		return button;
	}

	public void actionPerformed(ActionEvent e) {
		
		// Remove this temporary message after testing:
		
		
		JButton buttonPressed = (JButton) e.getSource();
		// If the buttonPressed was the firstButton
		if(buttonPressed.equals(firstButton)) {
			askQuestion("This man was responsible for the assasination of Abraham Lincoln.","Who is John Wilkes Booth?" , 200);
		}
			// Call the askQuestion() method
 
		// Complete the code in the askQuestion() method. When you play the game, the score should change.
		if(buttonPressed.equals(secondButton)) {
			askQuestion("Hitler did this before joining the Nazi party.", "What is applied to art school?", 400);
		}
		// If the buttonPressed was the secondButton

			// Call the askQuestion() method with a harder question

		// Clear the text on the button that was pressed (set the button text to nothing)
		if(buttonPressed.equals(thirdButton)) {
			askQuestion("In this state, and in this city, John F. Kennedy was assasinated.", "Where is Dallas Teaxas?", 600);
		}
		if(buttonPressed.equals(fourthButton)) {
			askQuestion("Britan and France were fighting over this territory in the Seven Years War.", "Where is Ohio?", 800);
		}
		
		if(buttonPressed.equals(fithButton)) {
			askQuestion("")
		}
		
		buttonPressed.setText("");
	}

	private void askQuestion(String question, String correctAnswer, int prizeMoney) {
		
		// Use the playJeopardyTheme() method to play music while the use thinks of an answer
		playJeopardyTheme();
		// Remove this temporary message and replace it with a pop-up that asks the user the question
		String input = JOptionPane.showInputDialog(question);
		
		// Stop the theme music when they have entered their response. 
		stopJeopardyTheme();
		// If the answer is correct

		if(input.equalsIgnoreCase(correctAnswer)) {
			// Increase the score by the prizeMoney
			score += prizeMoney;
			// Pop up a message to tell the user they were correct
			JOptionPane.showMessageDialog(quizPanel, "You are correct.");
		// Otherwise
		} else {
			// Decrement the score by the prizeMoney
			score -= prizeMoney;
			// Pop up a message to tell the user they were wrong and give them the correct answer
			JOptionPane.showMessageDialog(quizPanel, "That is incorrect. The correct answer is, \"" + correctAnswer + "\"");
		}
		// Call the updateScore() method
		updateScore();
	}

	public void playJeopardyTheme() {
		String fileName = "src/_03_jeopardy/jeopardy.wav";
		// Note: use .wav files
		try {
			jeopardyThemeClip = AudioSystem.getClip();
			AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File(fileName));
			jeopardyThemeClip.open(inputStream);
			jeopardyThemeClip.start();
		} catch (Exception e) {
			System.out.println("play sound error: " + e.getMessage() + " for " + fileName);
		}
	}

	public void stopJeopardyTheme() {
		jeopardyThemeClip.stop();

	}

	private Component makeScorePanel() {
		JPanel panel = new JPanel();
		panel.add(new JLabel("score:"));
		panel.add(scoreBox);
		panel.setBackground(Color.CYAN);
		return panel;
	}

	private void updateScore() {
		scoreBox.setText("" + score);
	}

	private JPanel createHeader(String topicName) {
		JPanel panelj = new JPanel();
		panelj.setLayout(new BoxLayout(panelj, BoxLayout.PAGE_AXIS));
		JLabel l1 = new JLabel(topicName);
		l1.setAlignmentX(Component.CENTER_ALIGNMENT);
		panelj.add(l1);
		return panelj;
	}

	void showCorrectImage() {
		showImage("correct.jpg");
	}

	void showIncorrectImage() {
		showImage("incorrect.jpg");
	}

	private void showImage(String fileName) {
		JFrame frame = new JFrame();
		URL imageURL = getClass().getResource(fileName);
		Icon icon = new ImageIcon(imageURL);
		JLabel image = new JLabel(icon);
		frame.add(image);
		frame.setVisible(true);
		frame.pack();
	}
}
