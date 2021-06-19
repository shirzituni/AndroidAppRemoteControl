package com.example.myapplication100.model;

import android.widget.Toast;

import com.example.myapplication100.MainActivity;

import java.io.DataOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class Model {

    private String ip1;
    private int port1;
    private PrintWriter out;
    public String ModelThrottle = "0"; //SeekBar
    public Boolean needModelThrottle = false;
    public String ModelRudder = "0"; //SeekBar
    public Boolean needModelRudder = false;
    public String ModelElevators = "0"; //Y
    public Boolean needModelElevators = false;
    public String ModelAilerons = "0"; //X
    public Boolean needModelAilerons = false;

    //192.168.1.21
    public class ConnectServer extends Thread {

        public void run(){
            System.out.println("MyThread running");
            // connection establishment
            try {
                Socket socket = new Socket(ip1, port1);
                System.out.println("success!");
                PrintWriter printWriter = new PrintWriter(socket.getOutputStream(),true);
                out = printWriter;
                // get the output stream from the socket.
                OutputStream outputStream = socket.getOutputStream();
                // create a data output stream from the output stream so we can send data through it
                DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
                System.out.println("Sending string to the ServerSocket");

                while (true) {
                    if (needModelAilerons) { //ModelAilerons - X
                        out.print("set controls/flight/aileron " + ModelAilerons + "\r\n");
                        out.flush();
                        needModelAilerons = false;
                    }
                    if (needModelElevators) {  //ModelElevators - Y
                        out.print("set controls/flight/elevator " + ModelElevators + "\r\n");
                        out.flush();
                        needModelElevators = false;
                    }
                    if (needModelRudder) {
                        out.print("set controls/flight/rudder " + ModelRudder + "\r\n");
                        out.flush();
                        needModelRudder = false;

                    }
                    if (needModelThrottle) {
                        out.print("set controls/engines/current-engine/throttle " + ModelThrottle + "\r\n");
                        out.flush();
                        needModelThrottle = false;
                    }
                }

            } catch (Exception e) {
                System.out.println(e.fillInStackTrace());
                //Toast.makeText(getApplicationContext(),"Connection Failed!",Toast.LENGTH_SHORT);
                System.out.println("failed!");
            }
        }
    }

    public void connect(String ip4,String port4){
        // open connection thread
        ip1 = ip4;
        port1 = Integer.parseInt(port4);
        ConnectServer myThread = new ConnectServer();
        myThread.start();
    }



}

