package com.example.myapplication100;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.myapplication100.model.Model;
import com.example.myapplication100.viewmodel.ViewModel;


public class MainActivity2 extends AppCompatActivity {
    public String ip1;
    public int port1;
    private ViewGroup mainLayout;
    private ImageView image;
    private int xDelta;
    private int yDelta;
    private TextView showX;
    private TextView showY;
    private double new_X;
    private double new_Y;
    private ViewModel myViewModel;
    private TextView showThrottle;
    private TextView showRudder;
    public String Ailerons11;
    public Boolean needModelAilerons = false;
    public String Elevators11;
    public Boolean needModelElevators = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
       // myModel = new Model();
         myViewModel = new ViewModel();

        ip1 = getIntent().getStringExtra("ip1");
        String port1 = getIntent().getStringExtra("port1");


        mainLayout = (ViewGroup) findViewById(R.id.MainActivity2);
        image = (ImageView) findViewById(R.id.image);
        showX = (TextView) findViewById(R.id.showX);
        showY = (TextView) findViewById(R.id.showY);

        showThrottle = (TextView) findViewById(R.id.showThrottle);
        showRudder = (TextView) findViewById(R.id.showRudder);

        SeekBar sb1 = (SeekBar) findViewById(R.id.sb1); // initiate the Seek bar
        SeekBar sb3 = (SeekBar) findViewById(R.id.sb3); // initiate the Seek bar
        sb3.setProgress(100);
        myViewModel.sendConnectCommand(ip1, port1);

        image.setOnTouchListener(onTouchListener());

        sb1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar sb1, int progress, boolean fromUser) {
                double seekBarValuesd1 = sb1.getProgress();
                seekBarValuesd1 = seekBarValuesd1 / 100;
                showThrottle.setText("Throttle  " + seekBarValuesd1);
                mainLayout.invalidate();
                myViewModel.sendModelsb1Command(seekBarValuesd1);
            }

            @Override
            public void onStartTrackingTouch(SeekBar sb1) {
                double seekBarValuesd1 = sb1.getProgress();
                seekBarValuesd1 = seekBarValuesd1 / 100;
                showThrottle.setText("Throttle  " + seekBarValuesd1);
                mainLayout.invalidate();
                myViewModel.sendModelsb1Command(seekBarValuesd1);

            }

            @Override
            public void onStopTrackingTouch(SeekBar sb1) {
                double seekBarValuesd1 = sb1.getProgress();
                seekBarValuesd1 = seekBarValuesd1 / 100;
                showThrottle.setText("Throttle  " + seekBarValuesd1);
                mainLayout.invalidate();
                myViewModel.sendModelsb1Command(seekBarValuesd1);

            }
        });

        //Rudder - SeekBar
        sb3.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar sb3, int progress, boolean fromUser) {
                // progressBar.setProgress(progress);
                double seekBarValuesd3 = sb3.getProgress();
                seekBarValuesd3 = seekBarValuesd3 / 100;
                if (seekBarValuesd3 < 1) {
                    seekBarValuesd3 = seekBarValuesd3 - 1;
                }
                if (seekBarValuesd3 >= 1) {
                    seekBarValuesd3 = seekBarValuesd3 - 1;
                }
                showRudder.setText("Rudder  " + seekBarValuesd3);
                mainLayout.invalidate();
                myViewModel.sendModelsb3Command(seekBarValuesd3);

            }
            //Throttle - SeekBar
            @Override
            public void onStartTrackingTouch(SeekBar sb1) {
                double seekBarValuesd3 = sb3.getProgress();
                seekBarValuesd3 = seekBarValuesd3 / 100;
                if (seekBarValuesd3 < 1) {
                    seekBarValuesd3 = seekBarValuesd3 - 1;
                }
                if (seekBarValuesd3 >= 1) {
                    seekBarValuesd3 = seekBarValuesd3 - 1;
                }
                showRudder.setText("Rudder  " + seekBarValuesd3);
                mainLayout.invalidate();
                myViewModel.sendModelsb3Command(seekBarValuesd3);

            }

            @Override
            public void onStopTrackingTouch(SeekBar sb1) {
                double seekBarValuesd3 = sb3.getProgress();
                seekBarValuesd3 = seekBarValuesd3 / 100;
                if (seekBarValuesd3 < 1) {
                    seekBarValuesd3 = seekBarValuesd3 - 1;
                }
                if (seekBarValuesd3 >= 1) {
                    seekBarValuesd3 = seekBarValuesd3 - 1;
                }
                showRudder.setText("Rudder  " + seekBarValuesd3);
                mainLayout.invalidate();
                myViewModel.sendModelsb3Command(seekBarValuesd3);
            }
        });
    }

    public View.OnTouchListener onTouchListener() {
        return new View.OnTouchListener() {
            @SuppressLint("ClickableViewAccessibility")
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                final int x = (int) event.getRawX();
                final int y = (int) event.getRawY();
                switch (event.getAction() & MotionEvent.ACTION_MASK) {

                    case MotionEvent.ACTION_DOWN:
                        RelativeLayout.LayoutParams lParams = (RelativeLayout.LayoutParams)
                                view.getLayoutParams();

                        xDelta = x - lParams.leftMargin;
                        yDelta = y - lParams.topMargin;
                        break;
                    case MotionEvent.ACTION_MOVE:
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view
                                .getLayoutParams();
                        //Goystick border
                        if(x < 220){
                            break;
                        }
                        if(y < 580){
                            break;
                        }
                        if(y > 1999){
                            break;
                        }
                        layoutParams.leftMargin = x - xDelta;
                        layoutParams.topMargin = y - yDelta;
                        layoutParams.rightMargin = 0;
                        layoutParams.bottomMargin = 150;

                        view.setLayoutParams(layoutParams);
                        break;
                }
                //x  between -1 to 1 (x original 0 - 1000)
                if (x == 0) {
                    new_X = -1;
                }
                //middle
                else if (x == 500) {
                    new_X = 0;
                } else if (x < 500) {
                    new_X = ((double) x / 1000 * 2) - 1;
                } else if (x > 999) {
                    new_X = 1;
                } else {
                    new_X = (((double) x / 50) % 10) / 10;
                }
                //y  between -1 to 1 (y original 0 - 2000)
                if (y < 0.9999999999) {
                    new_Y = -1;
                }
                //middle
                else if (y == 1000) {
                    new_Y = 0;
                } else if (y < 1000) {
                    new_Y = ((double) y / 2000 * 2) - 1;
                } else if (y > 1999) {
                    new_Y = 1;
                } else {
                    new_Y = (((double) y / 100) % 10) / 10;
                }
                showX.setText("Ailerons  " + new_X);
                showY.setText("Elevators  " + new_Y);
                mainLayout.invalidate();

                Ailerons11 = Double.toString(new_X);
                Elevators11  = Double.toString(new_Y);
                String new_XS= String.valueOf(new_X);
                String new_YS = String.valueOf(new_Y);
                myViewModel.sendModelGoystickCommand(new_XS,new_YS);

                return true;
            }
        };
    }

}


