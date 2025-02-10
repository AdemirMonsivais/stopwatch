package logic;

import utils.Time;

import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class Timer implements Runnable{
    private final Time time;
    private final JLabel timeLabel;

    private final TimerManager timerManager;


    public Timer(Time time, JLabel timeLabel, TimerManager timerManager){
        this.time = time;
        this.timeLabel = timeLabel;
        this.timerManager = timerManager;
    }

    @Override
    public void run() {
        int iterations = 0;
        while(!Thread.currentThread().isInterrupted()){
            synchronized (timerManager.getLock()) {
                while (timerManager.isPaused()) {
                    try {
                        timerManager.getLock().wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                }
            }

            iterations++;
            if (iterations >= 10){
                increment();
                updateLabel();
                iterations = 0;
            }

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }


        }
    }

    public void increment(){

        time.setSeconds(time.getSeconds()+1);
    }
    public void reset(){
        time.setTime(0,0,0);
    }



    public void updateLabel(){
        SwingUtilities.invokeLater(()->{
            timeLabel.setText(Time.format(time));

            timeLabel.revalidate();
            timeLabel.repaint();
        });
    }


}
