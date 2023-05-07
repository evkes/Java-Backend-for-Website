package cpsc4620;

import java.sql.Time;

public class Schedule {
    private int schedId;
    private String startPlace;
    private String endPlace;
    private Time startTime;
    private Time endTime;
    private String dayOfWeek;
    private int personId;

    public Schedule(int schedId, String startPlace, String endPlace, Time startTime, Time endTime, String dayOfWeek, int personId) {
        this.schedId = schedId;
        this.startPlace = startPlace;
        this.endPlace = endPlace;
        this.startTime = startTime;
        this.endTime = endTime;
        this.dayOfWeek = dayOfWeek;
        this.personId = personId;
    }

    // Getters and setters
    public int getSchedId() {
        return schedId;
    }

    public void setSchedId(int schedId) {
        this.schedId = schedId;
    }

    public String getStartPlace() {
        return startPlace;
    }

    public void setStartPlace(String startPlace) {
        this.startPlace = startPlace;
    }

    public String getEndPlace() {
        return endPlace;
    }

    public void setEndPlace(String endPlace) {
        this.endPlace = endPlace;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    @Override
    public String toString() {
        String tableHeader = String.format("%-10s %-20s %-20s %-10s %-10s", "Day", "Start Location", "End Location", "Start Time", "End Time");
        String tableRow = String.format("%-10s %-20s %-20s %-10s %-10s", dayOfWeek, startPlace, endPlace, startTime, endTime);
        return String.format("\n%s\n%s", tableHeader, tableRow);
    }
}

