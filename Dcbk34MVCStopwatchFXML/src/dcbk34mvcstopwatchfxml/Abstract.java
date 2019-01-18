/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dcbk34mvcstopwatchfxml;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
/**
 *
 * @author DylanBarrett
 */
public abstract class Abstract {
        protected PropertyChangeSupport propertyChangeSupport;
        protected Timeline timeline;
        protected String clockTime;
        protected boolean isRunning;
        protected double totalSec = 0,recordSec=0, totalMs=0,secondsElapsed = 0, tickTimeInSeconds = 1, angleDeltaPerSecond = 6, rotation, minRotation, angle;;
        protected int recordHour = 0, totalMin=0, totalHour=0, recordCount = 1, recordMin=0, recordNumber;

         public void setupTimeline(){
          timeline = new Timeline(new KeyFrame(Duration.millis(10), (ActionEvent) -> {
          updateClock();
        }));
        timeline.setCycleCount(Animation.INDEFINITE);
     }
        public abstract void updateClock();
         
        public Abstract(){
            propertyChangeSupport = new PropertyChangeSupport(this);
        }
        public void start(){
            timeline.play();
            isRunning = true;
        }
        public void stop(){
            timeline.pause();
            isRunning = false;
        }
        public String updateTotalTime(){
            totalSec++;
        if(totalSec == 6000){
            totalSec=0;
            totalMin++;
        } 
        if(totalMin == 60){
            totalMin =0;
            totalHour++;
        }
        
        recordSec++;
        if(recordSec == 6000){
            recordSec=0;
            recordMin++;
        } 
        if(recordMin == 60){
            recordMin = 0;
            recordHour++;
        }
       return clockTime = String.format("%02d:%02d:%05.02f",totalHour,totalMin,totalSec/100);
    }
    
    public void addPropertyChangeListener(PropertyChangeListener listener) {
    propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }

    protected void firePropertyChange(String propertyName, Object oldValue, Object newValue) {
        propertyChangeSupport.firePropertyChange(propertyName, oldValue, newValue);
    }
}
