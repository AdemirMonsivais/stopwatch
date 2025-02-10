package ui;

import javax.swing.JButton;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

public class StartPauseButton extends JButton{
    private boolean isPaused = false;

    public StartPauseButton(){
        setText("\u2023");
        setFont(new Font("Digital / LCD Style Fonts", Font.PLAIN, 30));
        setFocusPainted(false);
        setBackground(Color.decode("#e9824e"));
        setPreferredSize(new Dimension(70,50));

        addActionListener(e-> {
            isPaused = !isPaused;

            if(isPaused){
                setText("\u23F8");

            }else{
                setText("\u2023");
            }
        });

    }

    public boolean isPaused() {
        return isPaused;
    }
}
