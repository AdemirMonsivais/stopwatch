package ui;

import javax.swing.JButton;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

public class StartPauseButton extends JButton{
    private boolean isPaused = false;

    public StartPauseButton(){
        setText("‣");
        setFont(new Font("Digital / LCD Style Fonts", Font.PLAIN, 30));
        setFocusPainted(false);
        setBackground(Color.decode("#e9824e"));
        setPreferredSize(new Dimension(70,50));

        addActionListener(_ -> {
            isPaused = !isPaused;

            if(isPaused){
                setText("⏸");

            }else{
                setText("‣");
            }
        });

    }

    public boolean isPaused() {
        return isPaused;
    }
}
