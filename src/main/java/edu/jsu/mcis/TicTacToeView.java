package edu.jsu.mcis;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author HollyWeatherbee
 */
public class TicTacToeView extends JPanel{

    JButton[][] buttons = new JButton[3][3];
    int mvcounter;
    int symbol = 0;  //int needed to determine X (even) or O (odd)
    String Winner;
    JLabel Label = new JLabel("PLAYER: X");
    TicTacToeModel viewModel;

    public TicTacToeView(TicTacToeModel model) {
        JFrame window = new JFrame("Tic Tac Toe");
        viewModel = model;
        window.add(this);
        window.setBackground(Color.yellow);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setBounds(300, 200, 300, 300);
        window.setVisible(true);
        //System.out.println("You suck");
        //viewModel = new TicTacToeModel();
        setLayout(new GridLayout(0, 3));
        initBoard();
        Label.setName("ResultLabel");
        this.add(Label);
    }

    public void initBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j] = new JButton();
                buttons[i][j].setText("");
                buttons[i][j].addActionListener(new buttonListener());
                buttons[i][j].setName("Location" + i + "" + j);
                System.out.println(buttons[i][j].getName());
                add(buttons[i][j]);
            }
        }

    }

    private class buttonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {

            JButton buttonClicked = (JButton) event.getSource();

            // if(buttons.getText(.length()==0)
            // if(xTurn) {button.setText("X");
            if (viewModel.xTurn) {
                buttonClicked.setText("X");
                buttonClicked.setFont(new Font("Helvetica", Font.BOLD, 16));
                //Label.setText("PLAYER: O");
            } else {
                buttonClicked.setText("O");
                buttonClicked.setFont(new Font("Helvetica", Font.BOLD, 16));
                //Label.setText("PLAYER: X");
            }
            
            viewModel.setMark(
                Integer.parseInt(buttonClicked.getName().substring(8, 9))
                , Integer.parseInt(buttonClicked.getName().substring(9)));

            symbol++;
        }
    }
}
