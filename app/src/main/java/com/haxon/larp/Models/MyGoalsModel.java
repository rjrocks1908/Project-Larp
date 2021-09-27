package com.haxon.larp.Models;

public class MyGoalsModel {

    String goal, goalNotes, id, dates;

    public MyGoalsModel(String goal, String goalNotes) {
        this.goal = goal;
        this.goalNotes = goalNotes;
    }

    public MyGoalsModel(String goal, String goalNotes, String id, String dates) {
        this.goal = goal;
        this.goalNotes = goalNotes;
        this.id = id;
        this.dates = dates;
    }

    public MyGoalsModel() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDates() {
        return dates;
    }

    public void setDates(String dates) {
        this.dates = dates;
    }

    public String getGoal() {
        return goal;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }

    public String getGoalNotes() {
        return goalNotes;
    }

    public void setGoalNotes(String goalNotes) {
        this.goalNotes = goalNotes;
    }
}
