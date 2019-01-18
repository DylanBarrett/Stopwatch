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
public class DigitalStopwatch extends Abstract {
        String clockString;
    
        @Override
     public void updateClock(){
         String oldString = clockString;
         clockString = updateTotalTime();
         firePropertyChange("Digital", oldString, clockString);
     }
    
     public String fetchRecord(){
         return String.format("Record " + recordCount++ + ": %02d:%02d:%05.02f",recordHour, recordMin,recordSec/100);   
    }
     
}
