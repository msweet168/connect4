import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class connect4 extends JFrame implements ActionListener {

   private JButton[] buttonArr = new JButton[42];
   private int[][] gameBoardArr = new int[6][7];
   
   private JMenuBar mainMenu;
   private JMenu gameMenu;
   private JMenuItem newGame;
   private JMenuItem enterNames;
   private JMenu aboutMenu;
   private JMenuItem howToPlay;
   private JMenuItem aboutUs;
   private JMenuItem exit;
   private JMenu quitMenu;
   
   private int turn;
   private int scanNumber;
   private String player1;
   private String player2;

   public static void main(String[] args) {
      new connect4();
   }
   
   public connect4() {
   
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
      
      turn = 1;
      player1 = "Player 1";
      player2 = "Player 2";
      
      this.setJMenuBar(mainMenu);
      
      JPanel gameBoard = new JPanel();  
      
      gameBoard.setLayout(new GridLayout(0, 7));
    
      for (int i = 0; i < 42; i++) {
         buttonArr[i] = new JButton("" + (i));
         gameBoard.add(buttonArr[i]);
         if (Integer.parseInt(buttonArr[i].getText()) > 6) {
            //buttonArr[i].setEnabled(false);
            buttonArr[i].setText("");
         }
         else {
            buttonArr[i].addActionListener(this);
         }
      }
      
      
      this.add(gameBoard, BorderLayout.CENTER);
      this.setTitle("Connect 4, \"Ready to Play\"");
      this.setSize(800, 550);
      this.setLocation(400, 100);
      this.setMinimumSize(new Dimension(800,550));
      this.setMaximumSize(new Dimension(800,550));
      this.setVisible(true);
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
      
      MenuListener menuListen = new MenuListener(this,buttonArr);
      
      howToPlay.addActionListener(menuListen);
      exit.addActionListener(menuListen);
      newGame.addActionListener(menuListen);
      newGame.addActionListener(this);
      enterNames.addActionListener(this);
      aboutUs.addActionListener(menuListen);
     
   }
   
   
   public void actionPerformed(ActionEvent e) {
   
      if(e.getActionCommand().equals("0")) {
         playCol1();
      }
      else if (e.getActionCommand().equals("1")) {
         playCol2();
      }
      else if (e.getActionCommand().equals("2")) {
         playCol3();
      }
      else if (e.getActionCommand().equals("3")) {
         playCol4();
      }
      else if (e.getActionCommand().equals("4")) {
         playCol5();
      }
      else if (e.getActionCommand().equals("5")) {
         playCol6();
      }
      else if (e.getActionCommand().equals("6")) {
         playCol7();
      }
      else if (e.getActionCommand().equals("New Game")) {
         gameBoardArr = new int[6][7];
         turn = 1;
      }
      else if (e.getActionCommand().equals("Enter Player Names")) {
         player1 = JOptionPane.showInputDialog("Player 1, enter your name: ");
         player2 = JOptionPane.showInputDialog("Player 2, enter your name: ");
      }
      
     }
      
      
      public void playCol1(){
         
         for (int i = 5; i >= 0; i--) {
            if (gameBoardArr[i][0] == 0) {
               gameBoardArr[i][0] = turn;
               int arrayNum = (7*i);
               changeColor(arrayNum);
               break;
            }
         }
         
      }
      
      public void playCol2() {
         for (int i = 5; i >= 0; i--) {
            if (gameBoardArr[i][1] == 0) {
               gameBoardArr[i][1] = turn;
               int arrayNum = (7*i)+1;
               changeColor(arrayNum);
               break;
            }
         }         
      }
      
      public void playCol3() {
         for (int i = 5; i >= 0; i--) {
            if (gameBoardArr[i][2] == 0) {
               gameBoardArr[i][2] = turn;
               int arrayNum = (7*i)+2;
               changeColor(arrayNum);
               break;
            }
         }

      }
      
      public void playCol4() {
         for (int i = 5; i >= 0; i--) {
            if (gameBoardArr[i][3] == 0) {
               gameBoardArr[i][3] = turn;
               int arrayNum = (7*i)+3;
               changeColor(arrayNum);
               break;
            }
         }

      }

      public void playCol5() {
         for (int i = 5; i >= 0; i--) {
            if (gameBoardArr[i][4] == 0) {
               gameBoardArr[i][4] = turn;
               int arrayNum = (7*i)+4;
               changeColor(arrayNum);
               break;
            }
         }

      }
      
      public void playCol6() {
         for (int i = 5; i >= 0; i--) {
            if (gameBoardArr[i][5] == 0) {
               gameBoardArr[i][5] = turn;
               int arrayNum = (7*i)+5;
               changeColor(arrayNum);
               break;
            }
         }

      }
      
      public void playCol7() {
         for (int i = 5; i >= 0; i--) {
            if (gameBoardArr[i][6] == 0) {
               gameBoardArr[i][6] = turn;
               int arrayNum = (7*i)+6;
               changeColor(arrayNum);
               break;
            }
         }

      }
      
      public void changeColor(int index) {
         if (turn == 1) {
            turn = 2;
            scanNumber = 1;
            this.setTitle(player2 + "'s turn");
            buttonArr[index].setIcon(new javax.swing.ImageIcon("redSquare.png"));
            
            //System.out.println(buttonArr[index].getIcon());
            
            //if(buttonArr[index].getIcon().equals("redSquare.png")) {
               //System.out.println("yay");
            //}
            
         }
         else if (turn == 2) {
            turn = 1;
            scanNumber = 2;
            this.setTitle(player1 + "'s turn");
            buttonArr[index].setIcon(new javax.swing.ImageIcon("blueSquare.png"));
         }
         
         for (int i = 0; i < gameBoardArr.length; i++) {
            for (int j = 0; j < gameBoardArr[i].length; j++) {
             System.out.print(gameBoardArr[i][j] + " ");
         }
             System.out.println();
         }
         
         scanBoard();
      }
      
      public void scanBoard() {
         CheckGrid gridScanner = new CheckGrid(gameBoardArr);
         boolean isWinner = gridScanner.scan(scanNumber);
         
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
         }
         else {
            System.out.println("No Win");
         }
         
      }
      
      

}