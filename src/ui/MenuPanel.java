package ui;

import logic.TimerManager;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuPanel extends JPanel implements ActionListener{
    private final StartPauseButton startPauseButton;
    private final JButton restartButton;

    private final TimerManager timerManager;

    public MenuPanel(JLabel timeLabel){
        timerManager = new TimerManager(timeLabel);

        setBackground(Color.decode("#404d4d"));
        setLayout(new FlowLayout());

        restartButton = new JButton("↺");
        restartButton.setFont(new Font("Digital / LCD Style Fonts", Font.PLAIN, 30));
        restartButton.setFocusPainted(false);
        restartButton.setBackground(Color.decode("#e9824e"));
        restartButton.setPreferredSize(new Dimension(70,50));
        restartButton.addActionListener(this);

        //--------StartPauseButton---------"
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
