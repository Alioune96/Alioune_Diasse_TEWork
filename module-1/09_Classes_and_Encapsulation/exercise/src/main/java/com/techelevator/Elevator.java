package com.techelevator;

public class Elevator {
private int currentFloor;
private int numberOfFloors;
private boolean isDoorOpen;

    public Elevator(int numberOfLevels) {
        currentFloor = 1;
        this.numberOfFloors = numberOfLevels;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public boolean isDoorOpen() {
        return isDoorOpen;
    }

    public void openDoor(){
        this.isDoorOpen=true;
    }

    public void closeDoor(){
        this.isDoorOpen=false;
    }

    public void goUp(int desiredFloor) {

        if(desiredFloor<=numberOfFloors&&isDoorOpen==false && desiredFloor>currentFloor){
            this.currentFloor=desiredFloor;
        }

    }

    public void goDown(int desiredFloor){
        if(isDoorOpen==false && desiredFloor<numberOfFloors && desiredFloor<currentFloor && desiredFloor>0 ){
            this.currentFloor=desiredFloor;
        }
    }
}
