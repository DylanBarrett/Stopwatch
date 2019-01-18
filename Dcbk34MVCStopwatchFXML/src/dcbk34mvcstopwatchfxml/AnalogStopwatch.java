/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dcbk34mvcstopwatchfxml;

/**
 *
 * @author DylanBarrett
 */
public class AnalogStopwatch extends Abstract {
    public AnalogStopwatch(){
        rotation = 0;
        minRotation = 0;
        angle = 0;
        recordNumber = 1;
    }
    
          public boolean isRunning(){
        if (timeline!=null){
            if (isRunning==true){
                return true;}}
        return false;
    }
          
    public double rotate(){
        secondsElapsed += tickTimeInSeconds;
        rotation = secondsElapsed * angleDeltaPerSecond;
        return rotation/100;
    }
    
    @Override
     public void updateClock(){
         double oldAngle = angle;
         angle = rotate();
         firePropertyChange("Analog", oldAngle, angle);
     } 
     public void reset(){
        recordCount = 1;
        totalSec = totalMin = totalHour = 0;
        recordSec = recordMin = 0;
        rotation = 0;
        minRotation = secondsElapsed = 0;
        recordCount = 1;
        totalSec = totalMin = totalHour = 0;
        recordSec = recordMin = recordHour = 0;
    }
}