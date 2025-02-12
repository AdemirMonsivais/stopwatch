package ui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Font;

public class App extends JFrame{

    public App(){
        setTitle("Stopwatch");
        setSize(400,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(new BorderLayout());

        //--------------TimeManager------------
        JLabel timeLabel = new JLabel();

        //----------------

        //-------------TimePanel-------------------
        JPanel timePanel = new JPanel();
        timePanel.setBackground(Color.decode("#404d4d"));
        timePanel.setLayout(new GridBagLayout());

        GridBagConstraints c = new GridBagConstraints();
        c.anchor = GridBagConstraints.CENTER;

        timeLabel.setFont(new Font("Digital / LCD Style Fonts", Font.BOLD, 80));
        timeLabel.setForeground(Color.WHITE);

        timePanel.add(timeLabel, c);

        //--------------------------------

        //-------------MenuPanel---------------
        MenuPanel menuPanel = new MenuPanel(timeLabel);
        //-------------------------
        add(timePanel, BorderLayout.CENTER);
        add(menuPanel, BorderLayout.PAGE_END);


        setVisible(true);
    }
}
