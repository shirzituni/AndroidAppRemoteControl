package com.example.myapplication100.viewmodel;

import com.example.myapplication100.model.Model;

import java.io.PrintWriter;

public class ViewModel {
    private Model myModel = new Model();;

    public void sendConnectCommand(String ip4,String port4){
        myModel.connect(ip4, port4);
    }
    public void sendModelGoystickCommand(String new_X,String new_Y){
        myModel.ModelAilerons = String.valueOf(new_X); //X
        myModel.needModelAilerons = true;
        myModel.ModelElevators = String.valueOf(new_Y);//Y
        myModel.needModelElevators = true;
    }
    public void sendModelsb1Command(double seekBarValuesd1){
        myModel.ModelThrottle = String.valueOf(seekBarValuesd1);
        myModel.needModelThrottle = true;
    }
    public void sendModelsb3Command(double seekBarValuesd3){
        myModel.ModelRudder = String.valueOf(seekBarValuesd3);
        myModel.needModelRudder = true;
    }



}
