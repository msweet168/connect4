import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class MenuListener implements ActionListener {

   JFrame gameFrame = new JFrame();
   JButton[] buttonArr2 = new JButton[42];
   
   
   public MenuListener(JFrame frame, JButton[] buttons) {
      gameFrame = frame;
      buttonArr2 = buttons;
   }
   
   
   public void actionPerformed(ActionEvent e) {
      if(e.getActionCommand().equals("New Game")) {
         restartGame();
      }
      else if (e.getActionCommand().equals("About the Team")) {
         showAbout();
      }
      else if (e.getActionCommand().equals("How to Play")) {
         showHow();
      }
      else if (e.getActionCommand().equals("Exit Game")) {
         System.exit(0);
      }

   }
   
   public void restartGame() {
      gameFrame.setTitle("Connect 4, \"Ready to Play\"");
      for (int i = 0; i < 42; i++) {
         buttonArr2[i].setIcon(null);
      }
   }
   
   public void showAbout() {
      JOptionPane.showMessageDialog( null,"Connect 4 \nCreated" 
      +"by Mitchell Sweet and Scott Tinker\nISTE 121.");
   }
   
   public void showHow() {
      JOptionPane.showMessageDialog( null,"How to play Connect 4 \nIt's Simple!" +
      " Click the top of a column to drop a piece.\nIf you can get 4 of your " +
      "pieces in a row (diagnoal or straight)\nthen you win!");

   }
   

}