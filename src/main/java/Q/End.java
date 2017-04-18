package Q;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static Q.Quiz.correctAnsCounter;

/**
 * Created by Saif Hassan on 4/10/2017.
 * Email: saiftheboss7@gmail.com
 * ID: 16-31182-1
 */

public class End extends JFrame implements ActionListener {
    JLabel score; //taking two objects of Jlabel
    JButton btnPlayAgain;

    public End(){
        Container contentPane = getContentPane();
        contentPane.setLayout(new GridLayout(0,1));


        score = new JLabel("Your Score is " +correctAnsCounter,SwingConstants.CENTER); //Initializing num1Label
        score.setFont(score.getFont().deriveFont(32f));
        contentPane.add(score);
        //score.setBounds(20,20,100,100);

        this.btnPlayAgain = new JButton ("Play Again");
        //btnPlayAgain.setBounds(10, 90, 100, 30);
        contentPane.add(btnPlayAgain);
        btnPlayAgain.addActionListener(this);

        this.setBounds(20,20,500,300); //this sets window's heightwidth and from the coordinate it starts
        this.setVisible(true); //turns visibility on for the Window itself
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);}

    public void actionPerformed(ActionEvent e){
        setVisible(false);
        new Quiz();
    }


}
