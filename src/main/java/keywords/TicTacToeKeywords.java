
package keywords;
import edu.jsu.mcis.*;

public class TicTacToeKeywords {
	
    
private TicTacToeModel model;

public void startNewGame() {
    model = new TicTacToeModel();
}

public void MarkLocation(int row, int col) {
    
    model.setMark(row, col);
}

public String getMark(int row, int col) {
    
    TicTacToeModel.Mark temp = model.getMark(row,col);
    
    if(temp==TicTacToeModel.Mark.XMARK){
        return "X";
    }
    
    if(temp==TicTacToeModel.Mark.OMARK){
        return "O";
    }
    if(temp==TicTacToeModel.Mark.EMPTY){
        return "EMPTY";
    }
    return""; 
}

public String getWinner() {
    
    String winner = "";
    
    model.getStatus();
    
    if (model.status == TicTacToeModel.GameState.XWINS) {
        winner = "X";
    }
    
    if (model.status == TicTacToeModel.GameState.OWINS) {
        winner = "O";
    }
    if (model.status == TicTacToeModel.GameState.TIE) {
        winner = "TIE";
    }
    return winner;  
}
}
