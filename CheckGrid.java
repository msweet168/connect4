import java.awt.*;
import javax.swing.*;

public class CheckGrid{
   
   private int[][] array;
   //private Icon check;
   private int check;
   
   public CheckGrid(int[][] _array){
      array = _array;
   }
   
   
   
   public boolean scan(int player){
   
      for(int i = 0; i<array.length;i++){
         for(int j = 0; j<array[i].length;j++){
            
            //gets button's icon at [i][j]
            //check = array[i][j].getIcon();
            //check = array[i][j];
            check = player;
            
            
            
            //check out of bounds
            if((i+3)<=5){
         
               //check down
               if(array[i][j] == check){
                  if(array[i+1][j]==check){
                     if(array[i+2][j]==check){
                        if(array[i+3][j]==check){
                           return true;
                        }
                     }
                  }
               }
            }
            
            //check out of bounds
            if((i-3)>=6||(j+3)<=7){   
         
            //check diagonal up to the right
               if(array[i][j]==check){
                  if(array[i-1][j+1]==check){
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
                  if(array[i][j+1]==check){
                     if(array[i][j+2]==check){
                        if(array[i][j+3]==check){
                           return true;
                        }
                     }
                  }
               }
            }
               
           //  //check if it will go out of bounds
//             if((i+3)<=5||(j+3)<=6){
//             //check diagonal down to the right
//                if(array[i][j]==check){
//                   if(array[i+1][j+1]==check){
//                      if(array[i+2][j+2]==check){
//                         if(array[i+3][j+3]==check){
//                            return true;
//                         }
//                      }
//                   }
//                }      
//             }
         }
      }
      
      //only occurs if no matches found
      return false;  
   }
}