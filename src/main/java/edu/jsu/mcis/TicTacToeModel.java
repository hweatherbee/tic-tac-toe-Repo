package edu.jsu.mcis;


public class TicTacToeModel {
    public enum Mark { XMARK, OMARK, EMPTY };
    private Mark[][] board;
    public boolean xTurn = true;
    public enum GameState {XWINS, OWINS, TIE, CONTINUE };
    public GameState status = GameState.CONTINUE;
    public int mvcount; 
    private int GameOver; 
    private TicTacToeModel model;
    
    
    public TicTacToeModel() {
        
        board = new Mark[3][3];
        
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                board[i][j] = Mark.EMPTY;
            }
        }
        mvcount=0;
        status =GameState.CONTINUE;
        xTurn = true;
    }
    
    public Mark getMark(int row, int col) {
        return board[row][col];
    }
    
    public void setMark(int row, int col) {
        Mark m= Mark.EMPTY;
        
        if(board[row][col] == Mark.EMPTY) {
            if(xTurn){
                m=Mark.XMARK;
                board[row][col] = m;
            }
            else {
                m=Mark.OMARK;
                board[row][col] = m;
            }
            
            mvcount++;
                  
           }
        
        switch   (CheckForWin()) {
           case 0:
               status = GameState.TIE;
               break;
           case 1:
               if (xTurn) {
                   status = GameState.XWINS;
               } else  {
                   status = GameState.OWINS;
               }
               break;
           case 2:
               status = GameState.CONTINUE;
               break;
       }
       xTurn = !xTurn;
    }
    
    public boolean CheckHorizontal(){
        
        Mark  x,y, z;
        
        for(int k=0; k<3; k++ ){
            x= board[k][0];
            y= board [k][1];
            z= board [k][2];
            
            if ((x== Mark.OMARK) && (y==Mark.OMARK) && (z==Mark.OMARK)){
                return true;
            } 
            else if ((x== Mark.XMARK) && (y==Mark.XMARK) && (z==Mark.XMARK)){
                return true;
            }
        }
       return false;
    }
    
    public boolean CheckVertical(){
        
        Mark  x, y, z;
        
        for(int i=0; i<3; i++ ){
            x= board[0][i];
            y= board [1][i];
            z= board [2][i];
            
            if ((x== Mark.OMARK) && (y==Mark.OMARK) && (z==Mark.OMARK)){
                return true;
            } 
            else if ((x== Mark.XMARK) && (y==Mark.XMARK) && (z==Mark.XMARK)){
                return true;
            }
        }
              return false;
    }    
    
    public boolean CheckDiag1(){
            Mark  x, y, z;
        
            x= board[0][0];
            y= board [1][1];
            z= board [2][2];
            
            if ((x== Mark.OMARK) && (y==Mark.OMARK) && (z==Mark.OMARK)){
                return true;
            } 
            else if ((x== Mark.XMARK) && (y==Mark.XMARK) && (z==Mark.XMARK)){
                return true;
            }
    
              return false;
    }
    
    private boolean CheckDiag2() {
        Mark x, y, z;

        x = board[2][0];
        y = board[1][1];
        z = board[0][2];

        if ((x == Mark.OMARK) && (y == Mark.OMARK) && (z == Mark.OMARK)) {
            return true;
        } 
        else if ((x == Mark.XMARK) && (y == Mark.XMARK) && (z == Mark.XMARK)) {
            return true;
        }
        return false;
        }
    
    public boolean CheckForTie(){
        
        for (int i =0; i< 3; i++) {
            for (int j=0; j<3; j++){
                if(board[i][j].equals(Mark.EMPTY)) {
                    return false;
                }
            }
        }
        return true;
    }
        
    public int CheckForWin(){

         if (CheckHorizontal()) {
            return 1;
        }
        if (CheckVertical()) {
            return 1;
        }
        if (CheckDiag1()) {
            return 1;
        }
        if (CheckDiag2()) {
            return 1;
        }
        if (CheckForTie()) {
            return 0;
        }
        return 2;
    }
    
    public String Winner(){
        
        GameState temp = model.status;
        
        if(temp ==TicTacToeModel.GameState.XWINS){
            return "X";
        }
        
        if(temp ==TicTacToeModel.GameState.OWINS){
            return "O";
        }
        
        else {
            if (temp ==TicTacToeModel.GameState.TIE)
                return "TIE";
        }
        
        return null;
    
    }
    
    public GameState getStatus(){
        return status;
    }
}                       
        
	
    
   

    
    
   