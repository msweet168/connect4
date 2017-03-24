/**
*@author Mitchell Sweet
*@version 1.0
*Menu Listener Class
*This class handles most of the functions of the menu bar buttons 
*in the connect 4 game. 
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class MenuListener implements ActionListener {
   
   //Create a JFrame object and JButton array object. 
   JFrame gameFrame = new JFrame();
   JButton[] buttonArr2 = new JButton[42];
   
   
   //Paramitized Constructor for the class. 
   public MenuListener(JFrame frame, JButton[] buttons) {
      //Initalizes the JFrame and the button array from the parameters.  
      gameFrame = frame;
      buttonArr2 = buttons;
   }
   
   
   //Action performed method called when a menu button is pressed. 
   public void actionPerformed(ActionEvent e) {
      if(e.getActionCommand().equals("New Game")) {
         //Calls restart method if the new game button is pressed. 
         restartGame();
      }
      else if (e.getActionCommand().equals("About the Team")) {
         //Calls show about method if the about button is pressed. 
         showAbout();
      }
      else if (e.getActionCommand().equals("How to Play")) {
         //Calls the help method if the how to play button is pressed. 
         showHow();
      }
      else if (e.getActionCommand().equals("Exit Game")) {
         //Exits the program if the exit button is pressed. 
         System.exit(0);
      }

   }
   
   /**
   *@author Mitchell Sweet
   *The restart method restarts the game and clears the board and score. 
   */
   public void restartGame() {
      gameFrame.setTitle("Connect 4, \"Ready to Play\"");
      for (int i = 0; i < 42; i++) {
         buttonArr2[i].setIcon(null);
      }
   }
   
   /**
   *@author Mitchell Sweet
   *The About method shows a message dialog which shows the authors of the game.
   */
   public void showAbout() {
      JOptionPane.showMessageDialog( null,"Connect 4 \nCreated" 
      +" by Mitchell Sweet and Scott Tinker\nISTE 121.");
   }
   
   /**
   *@author Mitchell Sweet
   *The Show How method shows a message dialog which explains how to play the game. 
   */
   public void showHow() {
      JOptionPane.showMessageDialog( null,"How to play Connect 4 \nIt's Simple!" +
      " Click the top of a column to drop a piece.\nIf you can get 4 of your " +
      "pieces in a row (diagnoal or straight)\nthen you win!");

   }
   

}