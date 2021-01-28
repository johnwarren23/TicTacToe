import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class TicTacToe implements ActionListener
{
	JFrame frame = new JFrame();
	JPanel titlePanel = new JPanel();
	JPanel buttonPanel = new JPanel();
	JLabel textField = new JLabel();
	JButton[] buttons = new JButton[9];
	JButton button = new JButton();
	boolean player1_turn;
	
	TicTacToe()
	{
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 800);
		frame.getContentPane().setBackground(new Color(50, 50, 50));
		frame.setLayout(new BorderLayout());
		//frame.setUndecorated(true); //removes the borders of the frame
		frame.setVisible(true); //displays the frame
		//frame.setExtendedState(JFrame.MAXIMIZED_BOTH); //makes the program appear in full screen mode
		

		
		textField.setBackground(new Color(25, 25, 25)); //sets the background color to black
		textField.setForeground(new Color(25, 255, 0)); //sets the color of the text to green
		textField.setFont(new Font("Ink Free", Font.BOLD, 75));
		textField.setText("Tic-Tac-Toe");
		textField.setHorizontalAlignment(JLabel.CENTER);
		textField.setOpaque(true);
		
		titlePanel.setLayout(new BorderLayout());
		//titlePanel.setBounds(0, 0, 800, 100);
		titlePanel.add(textField);
		frame.add(titlePanel, BorderLayout.NORTH);
		
		
		buttonPanel.setLayout(new GridLayout(3,3));
		buttonPanel.setBackground(new Color(150, 150, 150));
		frame.add(buttonPanel);
		
		//Button to reset the game
		
		frame.add(button, BorderLayout.SOUTH);
		button.setPreferredSize(new Dimension(40, 40));
		button.setText("Reset");
		button.setFont(new Font("Ariel", Font.BOLD, 25));
		button.setFocusable(false);
		button.addActionListener(this);
		//button.setActionCommand("button");
		
		
		for(int i = 0; i < 9; i++)
		{
			buttons[i] = new JButton();
			buttonPanel.add(buttons[i]);
			buttons[i].setFont(new Font("MV Boli", Font.BOLD, 120));
			buttons[i].setFocusable(false);
			buttons[i].addActionListener(this);
		}
		
	
		
		
		firstTurn(); //calls the method to determine who will go first by random
		
	}
	

	
	public void firstTurn()
	{
		
		Random random = new Random();
		
		try {
			Thread.sleep(2000); //measured in milliseconds (2 seconds)
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		if(random.nextInt(2) == 0) //if the random number is 0, then it is player one's turn
		{
			player1_turn = true;
			textField.setText("X turn"); //player ones turn
		}
		else //if the random number is 1, then it is player two's turn
		{
			player1_turn = false;
			textField.setText("O turn"); //player two's turn
		}
		
	}
	
	public void actionPerformed(ActionEvent e)
	{
		for(int i = 0; i < 9; i++)
		{
			if(e.getSource() == buttons[i]) //checks if a button is clicked on / activated
			{
				if(player1_turn) //if player one is true then then print "X" on the panel
				{
					if(buttons[i].getText() == "") //checks if the clicked-on button is empty
					{
						buttons[i].setForeground(new Color(255, 0, 0));
						buttons[i].setText("X");
						player1_turn = false; //changes to the other players turn
						textField.setText("O turn");
						check();
					}
				}
				else if(!player1_turn) //if player one is false then it is player two's turn and "O" will be printed on the panel
				{
					if(buttons[i].getText() == "")
					{
						buttons[i].setForeground(new Color(0, 0, 255));
						buttons[i].setText("O");
						player1_turn = true;
						textField.setText("X turn");
						check();
					
				}
					
				
					 
			}
				if(e.getSource() == button) //clears the game board
				{
					if(buttons[i].getText() != "")
					{
						buttons[i].setText(null);
					}
				}
		}
	}
}
	

		
	
	
	
	
	public void check()
	{
		//check X winning conditions
		if(
				(buttons[0].getText() == "X") &&
				(buttons[1].getText() == "X") &&
				(buttons[2].getText() == "X")
				)
		{
			xWins(0, 1, 2); //passing in the same winning numbers used one the game board
		}
		if(
				(buttons[3].getText() == "X") &&
				(buttons[4].getText() == "X") &&
				(buttons[5].getText() == "X")
				)
			{
				xWins(3, 4, 5);
			}
		if(
				(buttons[6].getText() == "X") &&
				(buttons[7].getText() == "X") &&
				(buttons[8].getText() == "X")
				)
			{
				xWins(6, 7, 8);
			}
		if(
				(buttons[0].getText() == "X") &&
				(buttons[3].getText() == "X") &&
				(buttons[6].getText() == "X")
				)
			{
				xWins(0, 3, 6);
			}
		if(
				(buttons[1].getText() == "X") &&
				(buttons[4].getText() == "X") &&
				(buttons[7].getText() == "X")
				)
			{
				xWins(1, 4, 7);
			}
		if(
				(buttons[2].getText() == "X") &&
				(buttons[5].getText() == "X") &&
				(buttons[8].getText() == "X")
				)
			{
				xWins(2, 5, 8);
			}
		if(
				(buttons[0].getText() == "X") &&
				(buttons[4].getText() == "X") &&
				(buttons[8].getText() == "X")
				)
			{
				xWins(0, 4, 8);
			}
		if(
				(buttons[2].getText() == "X") &&
				(buttons[4].getText() == "X") &&
				(buttons[6].getText() == "X")
				)
			{
				oWins(2, 4, 6);
			}
		
		//check O winning conditions
		if(
				(buttons[0].getText() == "O") &&
				(buttons[1].getText() == "O") &&
				(buttons[2].getText() == "O")
				)
			{
				oWins(0, 1, 2); //passing in the same winning numbers used one the game board
			}
			if(
					(buttons[3].getText() == "O") &&
					(buttons[4].getText() == "O") &&
					(buttons[5].getText() == "O")
					)
				{
					oWins(3, 4, 5);
				}
			if(
					(buttons[6].getText() == "O") &&
					(buttons[7].getText() == "O") &&
					(buttons[8].getText() == "O")
					)
				{
					oWins(6, 7, 8);
				}
			if(
					(buttons[0].getText() == "O") &&
					(buttons[3].getText() == "O") &&
					(buttons[6].getText() == "O")
					)
				{
					oWins(0, 3, 6);
				}
			if(
					(buttons[0].getText() == "O") &&
					(buttons[4].getText() == "O") &&
					(buttons[8].getText() == "O")
					)
				{
					oWins(0, 4, 8);
				}
			if(
					(buttons[2].getText() == "O") &&
					(buttons[5].getText() == "O") &&
					(buttons[8].getText() == "O")
					)
				{
					oWins(2, 5, 8);
				}
			if(
					(buttons[1].getText() == "O") &&
					(buttons[4].getText() == "O") &&
					(buttons[7].getText() == "O")
					)
				{
					oWins(1, 4, 7);
				}
			if(
					(buttons[2].getText() == "O") &&
					(buttons[4].getText() == "O") &&
					(buttons[6].getText() == "O")
					)
				{
					oWins(2, 4, 6);
				}
			
			//checks to see if there is a draw
			if(
					(buttons[0].getText() != "") &&
					(buttons[1].getText() != "") &&
					(buttons[2].getText() != "") &&
					(buttons[3].getText() != "") &&
					(buttons[4].getText() != "") &&
					(buttons[5].getText() != "") &&
					(buttons[6].getText() != "") &&
					(buttons[7].getText() != "") &&
					(buttons[8].getText() != "")
					)
			{
				draw();
			}
			
					
					
				
				
			
		
		
			
		
}
		
	
	
	public void xWins(int a, int b, int c)
	{
		buttons[a].setBackground(Color.GREEN);
		buttons[b].setBackground(Color.GREEN);
		buttons[c].setBackground(Color.GREEN);
		
		for(int i = 0; i < 9; i ++)
		{
			buttons[i].setEnabled(false); //disables the game board
		}
		textField.setText("X Wins");
		
	}
	
	public void oWins(int a, int b, int c)
	{
		buttons[a].setBackground(Color.GREEN);
		buttons[b].setBackground(Color.GREEN);
		buttons[c].setBackground(Color.GREEN);
		
		for(int i = 0; i < 9; i ++)
		{
			buttons[i].setEnabled(false); //disables the game board
		}
		textField.setText("O Wins");
		
	}
	
	public void draw()
	{
		for(int i = 0; i < 9; i++)
		{
		//buttons[i].setBackground(Color.RED);
		
		buttons[i].setEnabled(false);
		//buttons[i].setText(null);
		
		}
		textField.setText("It's a draw");
	
	

	}
}
