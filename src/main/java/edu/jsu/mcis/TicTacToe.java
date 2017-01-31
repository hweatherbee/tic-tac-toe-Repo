package edu.jsu.mcis;

import java.awt.Color;
import javax.swing.JFrame;

public class TicTacToe{
    
    
    public static void main (String [] args) {
        
        new TicTacToeView() {};
        
        JFrame window = new JFrame("Tic Tac Toe");
        TicTacToeView newGame;
        newGame= new TicTacToeView();
        window.add(newGame);
        window.setBackground(Color.yellow);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setBounds(300,200,300,300);
        window.setVisible(true);
    }
}