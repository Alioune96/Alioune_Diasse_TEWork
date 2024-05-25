package com.techelevator;

public class Television {
private boolean isOn;
private int currentChannel;
private int currentVolume;

    public Television() {
        isOn=false;
        currentChannel=3;
        currentVolume=2;
    }

    public boolean isOn() {
        return isOn;
    }

    public int getCurrentChannel() {
        return currentChannel;
    }

    public int getCurrentVolume() {
        return currentVolume;
    }

    public void turnOff(){
        this.isOn=false;
    }

    public void turnOn(){
        this.isOn=true;
        this.currentChannel=3;
        this.currentVolume=2;
    }

    public void changeChannel(int newChannel){
        if(isOn==true && (newChannel>=3 && newChannel<=18)){
            this.currentChannel=newChannel;
        }
    }

    public void channelUp(){
        if(isOn==true && currentChannel<18){
            this.currentChannel=currentChannel+1;
        }else{
            this.currentChannel=3;
        }
    }

    public void channelDown(){
        if(isOn==true && currentChannel<18){
            this.currentChannel=currentChannel-1;
            if(this.currentChannel<3){
                this.currentChannel=18;
            }
        }
    }

    public  void raiseVolume(){
        if(isOn==true && currentVolume<10){
            this.currentVolume=currentVolume+1;
        }
    }

    public void lowerVolume(){
        if(isOn==true && currentVolume>0){
            this.currentVolume=currentVolume-1;
        }
    }



}
