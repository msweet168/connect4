import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

/**
*@author Mitchell Sweet
*@version 1.0
*Mitchell Sweet, Scott Tinker
*ISTE 121
*Mini Project 1
*
*Connect 4 class. This is the main class for the project. It sets up the GUI and 
*handles gameplay. 
*/
public class connect4 extends JFrame implements ActionListener {
   
   //Creates array of buttons and 2D array to hold board state. 
   private JButton[] buttonArr = new JButton[42];
   private int[][] gameBoardArr = new int[6][7];
   
   //GUI objects. 
   private JMenuBar mainMenu;
   private JMenu gameMenu;
   private JMenuItem newGame;
   private JMenuItem enterNames;
   private JMenu aboutMenu;
   private JMenuItem howToPlay;
   private JMenuItem aboutUs;
   private JMenuItem exit;
   private JMenu quitMenu;
   
   //Attributes
   private int turn;
   private int scanNumber;
   private String player1;
   private String player2;
   private int turnCounter;
   
   //The main method calls the class constructor. 
   public static void main(String[] args) {
      new connect4();
   }
   
   /**
   *Constructor for Connect 4 creates the GUI and handles most of the gameplay logic. 
   */
   public connect4() {
   
      //Initalize the GUI objects and add them to the jframe. 
      mainMenu = new JMenuBar();
      gameMenu = new JMenu("Game");
      aboutMenu = new JMenu("Help");
      quitMenu = new JMenu("Quit");
      exit = new JMenuItem("Exit Game");
      newGame = new JMenuItem("New Game");
      enterNames = new JMenuItem("Enter Player Names");
      howToPlay = new JMenuItem("How to Play");
      aboutUs = new JMenuItem("About the Team");
      gameMenu.add(newGame);
      gameMenu.addSeparator();
      gameMenu.add(enterNames);
      aboutMenu.add(howToPlay);
      aboutMenu.addSeparator();
      aboutMenu.add(aboutUs);
      quitMenu.add(exit);
      mainMenu.add(gameMenu);
      mainMenu.add(aboutMenu);
      mainMenu.add(quitMenu);
      
      //Variables to hold the value of whos turn it is. 
      turn = 1;
      player1 = "Player 1";
      player2 = "Player 2";
      
      //Set the menu bar. 
      this.setJMenuBar(mainMenu);
      //create JPanel for game board. 
      JPanel gameBoard = new JPanel();  
      //Set the layout as a grid layout for the game board. 
      gameBoard.setLayout(new GridLayout(0, 7));
    
      //For loop which initalizes each button. 
      for (int i = 0; i < 42; i++) {
         buttonArr[i] = new JButton("" + (i));
         gameBoard.add(buttonArr[i]);
         if (Integer.parseInt(buttonArr[i].getText()) > 6) {
            buttonArr[i].setText("");
         }
         else {
            buttonArr[i].addActionListener(this);
         }
      }
      
      //Set the attributes of the view and set it to visable. 
      this.add(gameBoard, BorderLayout.CENTER);
      this.setTitle("Connect 4, \"Ready to Play\"");
      this.setSize(800, 550);
      this.setLocation(400, 100);
      this.setMinimumSize(new Dimension(800,550));
      this.setMaximumSize(new Dimension(800,550));
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
      this.setVisible(true);
      
      //Create a new instance of the MenuListener class. 
      MenuListener menuListen = new MenuListener(this,buttonArr);
      
      //Add the MenuListener as an action handler for the menu buttons. 
      howToPlay.addActionListener(menuListen);
      exit.addActionListener(menuListen);
      newGame.addActionListener(menuListen);
      newGame.addActionListener(this);
      enterNames.addActionListener(this);
      aboutUs.addActionListener(menuListen);
     
   }
   
   /**
   *Action Performed method handles when each button on the game board is clicked. 
   */
   public void actionPerformed(ActionEvent e) {
   
      if(e.getActionCommand().equals("0")) {
         playCol(0);
      }
      else if (e.getActionCommand().equals("1")) {
         playCol(1);
      }
      else if (e.getActionCommand().equals("2")) {
         playCol(2);
      }
      else if (e.getActionCommand().equals("3")) {
         playCol(3);
      }
      else if (e.getActionCommand().equals("4")) {
         playCol(4);
      }
      else if (e.getActionCommand().equals("5")) {
         playCol(5);
      }
      else if (e.getActionCommand().equals("6")) {
         playCol(6);
      }
      else if (e.getActionCommand().equals("New Game")) {
         gameBoardArr = new int[6][7];
         turn = 1;
         turnCounter = 0;
      }
      else if (e.getActionCommand().equals("Enter Player Names")) {
         player1 = JOptionPane.showInputDialog("Player 1, enter your name: ");
         player2 = JOptionPane.showInputDialog("Player 2, enter your name: ");
      }
      
     }
     
     /**
     *The playCol method is called each time a piece is placed. It sets the correct 
     *color for the next piece in the coloumn choosen and also sets the current turn. 
     */
     public void playCol(int num) {
         for (int i = 5; i >= 0; i--) {
            if (gameBoardArr[i][num] == 0) {
               gameBoardArr[i][num] = turn;
               int arrayNum = (7*i)+num;
               changeColor(arrayNum);
               break;
            }
         }
     }
      
      /**
      *The change color method changes the color of the button based on whose turn 
      *it is and then runs the scan method. 
      */ 
      public void changeColor(int index) {
         //Set correct color if it was player 2s turn. 
         if (turn == 1) {
            turn = 2;
            scanNumber = 1;
            this.setTitle(player2 + "'s turn");
            buttonArr[index].setIcon(new javax.swing.ImageIcon("redSquare.png"));
            
         }
         //Set correct color if it was player 1s turn. 
         else if (turn == 2) {
            turn = 1;
            scanNumber = 2;
            this.setTitle(player1 + "'s turn");
            buttonArr[index].setIcon(new javax.swing.ImageIcon("blueSquare.png"));
         }
         
         //Print the current state of the game board to an array. 
         for (int i = 0; i < gameBoardArr.length; i++) {
            for (int j = 0; j < gameBoardArr[i].length; j++) {
             System.out.print(gameBoardArr[i][j] + " ");
         }
             System.out.println();
         }
         //Run the scan method. 
         scanBoard();
      }
      
      /**
      *The scan board method runs the grid scanner class to check if there is a winner on the
      *board. If there is, it ends the game and prints a winner. 
      */
      public void scanBoard() {
         CheckGrid gridScanner = new CheckGrid(gameBoardArr);
         boolean isWinner = gridScanner.scan(scanNumber);
         turnCounter++;
         
         if (isWinner) {
            if (turn == 2) {
               //Player 1 win
               System.out.println("Player 1 wins.");
               JOptionPane.showMessageDialog( null,"" + player1 + " Wins!");
               
            
            }
            else {
               //Player 2 win
               System.out.println("Player 2 wins.");
               JOptionPane.showMessageDialog( null,"" + player2 + " Wins!");

            }
            
            gameBoardArr = new int[6][7];
            turn = 1;
            MenuListener menuClass = new MenuListener(this, buttonArr);
            menuClass.restartGame();
            turnCounter = 0;
         }
         else {
            System.out.println("No Win");
            
            if (turnCounter == 42) {
               System.out.println("Tie");
               JOptionPane.showMessageDialog( null,"Tie");
               
               gameBoardArr = new int[6][7];
               turn = 1;
               MenuListener menuClass = new MenuListener(this, buttonArr);
               menuClass.restartGame();
               turnCounter = 0;
            }
         }
         
      }
      
      

}