package logic;

import utils.Time;

import javax.swing.JLabel;

public class TimerManager {
    private Thread threadTime;
    private final Timer timer;

    private final Object lock = new Object();

    public TimerManager(JLabel timeLabel) {
        Time time = new Time(0, 0, 0);
        timer = new Timer(time, timeLabel);
        threadTime = new Thread(timer, "TimeManager"); //Add timer as a task for the thread

        timeLabel.setText(Time.format(time));
    }

    //POSSIBLE MISTAKES

    public void start(){
        if (threadTime.isAlive()){
            System.out.print("is on the run\n");
            synchronized (lock) {
                notify();
                System.out.println("mmm");

            }
        }else {
            threadTime.start();
            System.out.print("it's started from zero\n");
        }

    }

    public void pause(){
        System.out.print("it's paused\n");

        //while (isPaused){
            try {
                synchronized (lock) {
                    System.out.println("mm");
                    threadTime.wait();
                }
            }catch (InterruptedException e) {
                throw new RuntimeException(e);
           }
    }

    public void restart() {

        threadTime.interrupt();
        threadTime = new Thread(timer);
    }

}




