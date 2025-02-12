package logic;

import utils.Time;

import javax.swing.JLabel;

public class TimerManager {
    private Thread threadTime;
    private final Timer timer;

    public final Object lock = new Object();

    private boolean isPaused;

    public TimerManager(JLabel timeLabel) {
        Time time = new Time(0, 0, 0);
        timer = new Timer(time, timeLabel, this);
        threadTime = new Thread(timer, "TimeManager"); //Add timer as a task for the thread

        timeLabel.setText(Time.format(time));
    }

    public boolean isPaused() {
        return isPaused;
    }

    //POSSIBLE MISTAKES

    public void start(){
        if (threadTime.isAlive()){
            synchronized (lock) {
                if (isPaused) {
                    isPaused = false;
                    lock.notify();
                }
            }
        }else {
            threadTime.start();
            isPaused = false;
        }
    }

    public void pause(){
        synchronized (lock) {
            isPaused = true;
        }
    }

    public void restart() {
        if (threadTime != null && threadTime.isAlive()) {
            threadTime.interrupt();

            timer.reset();
            timer.updateLabel();


            threadTime = new Thread(timer, "TimeManager");

            if (!isPaused) { //if the thread is reset while the thread is not paused, the thread continue...
                threadTime.start();
            }
        }
    }


}
