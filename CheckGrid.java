import java.awt.*;
import javax.swing.*;

public class CheckGrid{
   
   private JButton[][] array;
   private Icon check;
   
   public CheckGrid(JButton[][] _array){
      array = _array;
   }
   
   
   
   public boolean scan(){
   
      for(int i = 0; i<6;i++){
         for(int j = 0; j<7;j++){
            
            //gets button's icon at [i][j]
            check = array[i][j].getIcon();
            
            //check out of bounds
            if((i+3)<=5){
         
               //check down
               if(array[i][j] == check){
                  if(array[i++][j]==check){
                     if(array[i+2][j]==check){
                        if(array[i+3][j]==check){
                           return true;
                        }
                     }
                  }
               }
            }
            
            //check out of bounds
            if((i-3)>=0||(j+3)<=6){   
         
            //check diagonal up to the right
               if(array[i][j]==check){
                  if(array[i--][j++]==check){
                     if(array[i-2][j+2]==check){
                        if(array[i-3][j+3]==check){
                           return true;
                        }
                     }
                  }
               }
            }
               
            //check out of bounds   
               
            if(j+3<=6){
            //check right
               if(array[i][j]==check){
                  if(array[i][j++]==check){
                     if(array[i][j+2]==check){
                        if(array[i][j+3]==check){
                           return true;
                        }
                     }
                  }
               }
            }
               
            //check if it will go out of bounds
            if((i+3)<=5||(j+3)<=6){
            //check diagonal down to the right
               if(array[i][j]==check){
                  if(array[i++][j++]==check){
                     if(array[i+2][j+2]==check){
                        if(array[i+3][j+3]==check){
                           return true;
                        }
                     }
                  }
               }      
            }
         }
      }
      
      //only occurs if no matches found
      return false;  
   }
}