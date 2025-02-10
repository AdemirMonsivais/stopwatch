package logic;

import utils.Time;

import javax.swing.JLabel;

public class TimerManager {
    private Thread threadTime;
    private final Timer timer;

    private final Object lock = new Object();

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

    public Object getLock() {
        return lock;
    }
    //POSSIBLE MISTAKES

    public void start(){
        if (threadTime.isAlive()){
            System.out.println(isPaused);
            synchronized (lock) {
                if (isPaused) {
                    isPaused = false;
                    System.out.println("It's on the run");
                    lock.notify();
                }
            }
        }else {
            System.out.println("It just started");
            threadTime.start();
        }
    }

    public void pause(){
        synchronized (lock) {
            isPaused = true;
            System.out.println("It just paused");
        }
    }

    public void restart() {
        if (threadTime != null && threadTime.isAlive()) {
            threadTime.interrupt();

            timer.reset();
            timer.updateLabel();

            threadTime = new Thread(timer, "TimeManager");

            System.out.println("It's reset");
            if (!isPaused) { //if the thread is reset while the thread is not paused, the thread continue...
                threadTime.start();
            }
        }
    }


}
