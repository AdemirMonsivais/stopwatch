package ui;

import logic.TimerManager;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;


import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuPanel extends JPanel implements ActionListener{
    private StartPauseButton startPauseButton;
    private JButton restartButton;

    private TimerManager timerManager;
    private JLabel timeLabel;

    public MenuPanel(JLabel timeLabel){
        timerManager = new TimerManager(timeLabel);

        setBackground(Color.decode("#404d4d"));
        setLayout(new FlowLayout());

        restartButton = new JButton("\u21ba");
        restartButton.setFont(new Font("Digital / LCD Style Fonts", Font.PLAIN, 30));
        restartButton.setFocusPainted(false);
        restartButton.setBackground(Color.decode("#e9824e"));
        restartButton.setPreferredSize(new Dimension(70,50));
        restartButton.addActionListener(this);

        //--------StartPauseBUtton---------"
        startPauseButton = new StartPauseButton();
        startPauseButton.addActionListener(this);
        //-------------------------

        add(restartButton);
        add(startPauseButton);
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource() == restartButton){
            timerManager.restart();
        }

        if(e.getSource() == startPauseButton){
            if(startPauseButton.isPaused()){
                timerManager.pause();
            }else{
                timerManager.start();
            }
        }

    }


}
