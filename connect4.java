import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class connect4 extends JFrame {

   private JButton[] buttonArr = new JButton[42];
   
   private JMenuBar mainMenu;
   private JMenu gameMenu;
   private JMenuItem newGame;
   private JMenu aboutMenu;
   private JMenuItem howToPlay;
   private JMenuItem aboutUs;
   private JMenuItem exit;
   private JMenu quitMenu;

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
      howToPlay = new JMenuItem("How to Play");
      aboutUs = new JMenuItem("About the Team");
      gameMenu.add(newGame);
      aboutMenu.add(howToPlay);
      aboutMenu.addSeparator();
      aboutMenu.add(aboutUs);
      quitMenu.add(exit);
      mainMenu.add(gameMenu);
      mainMenu.add(aboutMenu);
      mainMenu.add(quitMenu);
      
      this.setJMenuBar(mainMenu);
      
      JPanel gameBoard = new JPanel();  
      
      gameBoard.setLayout(new GridLayout(0, 7));
    
      for (int i = 0; i < 42; i++) {
         buttonArr[i] = new JButton("" + i);
         gameBoard.add(buttonArr[i]);
         if (Integer.parseInt(buttonArr[i].getText()) > 6) {
            buttonArr[i].setEnabled(false);
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
      
      MenuListener menuListen = new MenuListener(this);
      
      howToPlay.addActionListener(menuListen);
      exit.addActionListener(menuListen);
      newGame.addActionListener(menuListen);
      aboutUs.addActionListener(menuListen);
     
   }
   

}