package logic;

import utils.Time;

import javax.swing.*;

public class Timer implements Runnable{
    private Time time;
    private JLabel timeLabel;

    private boolean isRunning = true;
    private boolean isPaused = false;

    public Timer(Time time, JLabel timeLabel){
        this.time = time;
        this.timeLabel = timeLabel;
    }

    @Override
    public void run() {
        while(true){

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                /*
                System.out.println(Thread.currentThread().isInterrupted());
                if(Thread.currentThread().isInterrupted()){ //why doesn't change the internal flag status
                    System.err.println(Thread.currentThread().getName());
                    System.out.println(Thread.currentThread().isInterrupted());
                    Thread.currentThread().interrupt();
                }
                Thread.interrupted();
                 */
                time.setTime(0,0,0);
                timeLabel.setText(Time.format(time));
                timeLabel.revalidate();
                timeLabel.repaint();

                throw new RuntimeException();
            }

            time.setSeconds(time.getSeconds()+1);
            timeLabel.setText(Time.format(time));

            timeLabel.revalidate();
            timeLabel.repaint();
        }




    }
/*
    public void pause() throws InterruptedException{
            Thread.currentThread().wait();
    }*/
}
