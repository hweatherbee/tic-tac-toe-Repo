package edu.jsu.mcis;

import org.junit.*;
import static org.junit.Assert.*;

public class TicTacToeTest {
    
    @Test
	public void testInitialBoardIsEmpty() {
                    TicTacToeModel model = new TicTacToeModel();
                    
                    for(int row = 0; row < 3; row++) {
                        for(int col = 0; col < 3; col++) {
                    TicTacToeModel.Mark m = model.getMark(row, col);
                    assertEquals(TicTacToeModel.Mark.EMPTY, m);
            }
        }
	}
	
	@Test
	public void testMarkXInUpperRightCorner() {
                      TicTacToeModel model = new TicTacToeModel();
                      model.setMark(0, 2);
                      TicTacToeModel.Mark m = model.getMark(0, 2);                      
                      assertEquals(TicTacToeModel.Mark.XMARK, m);
	}
	
	@Test
	public void testMarkOInBottomLeftCorner() {
            
                      TicTacToeModel model =new TicTacToeModel();
                      model.setMark(1,0);
                      model.setMark(2,0);
                      TicTacToeModel.Mark m= model.getMark(2,0);
                      
                      assertEquals(TicTacToeModel.Mark.OMARK, m);
                     
	}
	
	@Test
	public void testUnableToMarkOverExistingMark() {
                      TicTacToeModel model = new TicTacToeModel();
                      model.setMark(0, 0);                                         
                      TicTacToeModel.Mark unableMark= model.getMark(0, 0);
                      model.setMark(0, 0);
                      assertEquals(unableMark, model.getMark(0, 0));                
                    
                             
                      
               }
	
	@Test
	public void testGameIsNotOverAfterTheFirstMark() {
                      TicTacToeModel model = new TicTacToeModel();
                      model.setMark(0, 0); 
                      model.setMark(0, 1);
                      assertEquals(TicTacToeModel.GameState.CONTINUE,model.status);
            
           
	}
	
             
    
	@Test
	public void testGameIsWonByXHorizontallyAcrossTopRow() {
                     TicTacToeModel model = new TicTacToeModel();
                                model.setMark(0,0); //X moves
		model.setMark(1,1);  //0 moves
		model.setMark(0,1); //x
		model.setMark(1,2); //o
		model.setMark(0,2);//x
                
                TicTacToeModel.Mark  b = model.getMark(0, 0);
                TicTacToeModel.Mark  c=  model.getMark(0, 1);
                TicTacToeModel.Mark  d = model.getMark(0, 2);
                 if (b==c){
                     if(c==b){
                         assertEquals(TicTacToeModel.Mark.XMARK, b);
                     }
                 }
                        
	       
	}
	
	@Test
	public void testGameIsOverByTieIfAllLocationsAreFilled() {
                      TicTacToeModel model = new TicTacToeModel();                      
                        model.setMark(0,0); //X
                        model.setMark(0,2); //O
                        model.setMark(0,1);  //X
                        model.setMark(1,0); //O
	        model.setMark(1,1); //X
                        model.setMark(2,1); //O
                        model.setMark(1,2); //X
                        model.setMark(2,2); //O
                        model.setMark(2,0); //X
                        
                
    
                     
                
	        assertEquals(  TicTacToeModel.GameState.TIE,model.status);
	}
    
}
