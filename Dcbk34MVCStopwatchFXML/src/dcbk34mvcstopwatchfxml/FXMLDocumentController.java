/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dcbk34mvcstopwatchfxml;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

/**
 *
 * @author DylanBarrett
 */
public class FXMLDocumentController implements Initializable, PropertyChangeListener {  
  
    public int recordCount = 1;
    public int recordCountPrint = 1;
    AnalogStopwatch stopwatch;
    DigitalStopwatch digital;
    
    @FXML
    private ImageView dial;    
    @FXML
    private Label display;    
    @FXML
    private Label record1;    
    @FXML
    private Label record2;    
    @FXML
    private Label record3;    
    @FXML
    private Button start;    
    @FXML
    private Button record;
    
     @Override
    public void initialize(URL url, ResourceBundle rb) {
        stopwatch = new AnalogStopwatch();
        digital = new DigitalStopwatch();
        display.setText("00:00:00:00");
        stopwatch.setupTimeline();
        digital.setupTimeline();
        stopwatch.addPropertyChangeListener(this);
        digital.addPropertyChangeListener(this);
        dial.setRotate(0);
    }  
    
    @FXML
    private void startButton(ActionEvent event){
     if(!(stopwatch.isRunning())){
         start.setText("Stop");
          start.setStyle("-fx-text-fill: #ff0000");
          stopwatch.start();
          digital.start();
          record.setText("Record");
          record.setStyle("-fx-text-fill: #3c00ff");
     } else {
          start.setText("Start");
          start.setStyle("-fx-text-fill: #009100");
          stopwatch.stop();
          digital.stop();
          record.setText("Reset");
          record.setStyle("-fx-text-fill: #ff0000");
      }
  }
    @FXML
    private void recordButton(ActionEvent event){
        if(stopwatch.isRunning()){
          switch(recordCount){
              case 1: 
                  record1.setText(String.format(digital.fetchRecord()));
                  recordCount++;
                  break;
              
              case 2:
                  record2.setText(String.format(digital.fetchRecord()));
                  recordCount++;
                  break;
              
              case 3:
                  record3.setText(String.format(digital.fetchRecord()));
                  recordCount = 1;
                  break;  
          }
      } else{
        display.setText("00:00:00:00");
        record1.setText("Record 1: --:--:--:--");
        record2.setText("Record 2: --:--:--:--");
        record3.setText("Record 3: --:--:--:--");
        record.setText("Record");
        record.setStyle("-fx-text-fill: #3c00ff");
        recordCount = 1;
        dial.setRotate(0);
        stopwatch.reset();
      }
    }
   
        @Override
        public void propertyChange(PropertyChangeEvent evt) {
        if(evt.getPropertyName().equals("Analog")){
            dial.setRotate((double) evt.getNewValue());
        } else if(evt.getPropertyName().equals("Digital")){
            display.setText(evt.getNewValue().toString());
        } else{
            System.out.println("Error, unknown name/id");
        }
    }   
}