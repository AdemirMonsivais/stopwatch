package utils;

public class Time {
    private int hours;
    private int minutes;
    private int seconds;

    public Time(int hours, int minutes, int seconds){
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public Time(){
        hours = 0;
        minutes = 0;
        seconds = 0;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public int getSeconds() {
        return seconds;
    }

    public static String format(Time time){
        if(time.seconds > 60){
            time.minutes++;
            time.seconds = 0;
        }

        if(time.minutes > 60){
            time.hours++;
            time.minutes = 0;
        }

        String hoursFormatted = (time.getHours() <= 9) ? "0" + time.getHours() : String.valueOf(time.getHours());
        String minutesFormatted = (time.getMinutes() <= 9) ? "0" + time.getMinutes() : String.valueOf(time.getMinutes());
        String secondsFormatted = (time.getSeconds() <= 9) ? "0" + time.getSeconds(): String.valueOf(time.getSeconds());
        return hoursFormatted + ":" + minutesFormatted + ":" + secondsFormatted;
    }

    public void setTime(int hours, int minutes, int seconds){
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

}
