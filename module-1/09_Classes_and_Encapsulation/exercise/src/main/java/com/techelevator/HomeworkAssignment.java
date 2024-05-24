package com.techelevator;

public class HomeworkAssignment {
    private int earnedMarks ;
    private int possibleMarks;

    private String submitterName;

    public HomeworkAssignment(int possibleMarks, String submitterName){
        this.possibleMarks = possibleMarks;
        this.submitterName = submitterName;

    }

    public String getLetterGrade() {
        double Average = (double) earnedMarks / possibleMarks;
        if (Average >= 0.90) {
            return "A";
        }
    else if(Average >= 0.80){
        return "B";
        }
    else if (Average >= 0.70) {
            return "C";
        }
        else if (Average >= 0.60) {
            return "D";
        }
    else{
        return "F";
        }
    }

    public void setEarnedMarks(int earnedMarks) {
        this.earnedMarks = earnedMarks;
    }

    public int getEarnedMarks() {
        return earnedMarks;
    }

    public int getPossibleMarks() {
        return possibleMarks;
    }

    public String getSubmitterName() {
        return submitterName;
    }
}
