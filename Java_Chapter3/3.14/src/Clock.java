public class Clock {
    private int hour;
    private int minute;
    private int second;
    
    public Clock() {}

    private int hourCheck(int hour) {
        if (hour > 23) {
            return 0;
        }
        return hour;
    }

    private int minute_and_second_check(int input) {
        if (input > 59) {
            return 0;
        }
        return input;
    }

    public Clock(int hour, int minute, int second) {
        this.hour = hourCheck(hour);
        this.minute = minute_and_second_check(minute);
        this.second = minute_and_second_check(second);
    }

    public void setHour(int hour) {
        this.hour = hourCheck(hour);
    }

    public void setMinute(int minute) {
        this.minute = minute_and_second_check(minute);
    }

    public void setSecond(int second) {
        this.second = minute_and_second_check(second);
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public int getSecond() {
        return second;
    }

    private String time_displaying_edit(int input) {
        if (input < 10) {
            return "0" + Integer.toString(input);
        }
        return Integer.toString(input);
    }
    public void displayTime() {
        String hourPart = time_displaying_edit(hour);
        String minutePart = time_displaying_edit(minute);
        String secondPart = time_displaying_edit(second);
        System.out.print(hourPart + ":" + minutePart + ":" + secondPart + "\n");
    }
}