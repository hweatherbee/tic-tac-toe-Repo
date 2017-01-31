package edu.jsu.mcis;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author HollyWeatherbee
 */
    
public  class TicTacToeView extends JPanel implements ActionListener{
    
    JButton[][] buttons= new JButton[3][3];
    int mvcounter;
    int symbol = 0;  //int needed to determine X (even) or O (odd)
    String Winner;
    JLabel Label= new JLabel("PLAYER: X");
    TicTacToeModel viewModel;
    
    
    
    public TicTacToeView() {
        System.out.println("You suck");
        viewModel = new TicTacToeModel();
        setLayout(new GridLayout(4,3));
        initBoard();
        Label.setName("ResultLabel");
        this.add(Label);
    }
    
    public void initBoard(){
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
            buttons[i][j] = new JButton();
            buttons[i][j].setText("");
            buttons[i][j].addActionListener(new TicTacToeView.buttonListener());
            buttons[i][j].setName("Location" + i + "" + j);
            System.out.println(buttons[i][j].getName());
            add(buttons[i][j]); 
            }
    }
    

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private class buttonListener implements ActionListener{
       
        @Override
        public void actionPerformed(ActionEvent event) 
        {
            
            JButton buttonClicked = (JButton)event.getSource();
            
           // if(buttons.getText(.length()==0)
               // if(xTurn) {button.setText("X");
            if(symbol%2 == 0){
                buttonClicked.setText("X");
                buttonClicked.setFont(new Font("Helvetica", Font.BOLD, 16));
                Label.setText("PLAYER: O");
                }
            else{
                buttonClicked.setText("O");
                buttonClicked.setFont(new Font("Helvetica", Font.BOLD, 16));
                Label.setText("PLAYER: X");
            }
            
            symbol++;
        }
    }     
}        

   