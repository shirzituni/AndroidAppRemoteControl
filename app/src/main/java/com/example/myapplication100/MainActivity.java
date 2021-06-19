package com.example.myapplication100;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.myapplication100.MainActivity2;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button mButton =  (Button) findViewById(R.id.ConnectB);
        mButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public  void onClick(View v){
                mButton.setEnabled(false);
                EditText ip4 = (EditText) findViewById(R.id.ip4);
                String ip14 = ip4.getText().toString();
                Toast.makeText(MainActivity.this,"Try to connect to the serve...",Toast.LENGTH_SHORT).show();

                Toast.makeText(MainActivity.this,"Connected Successfully into the Server!",Toast.LENGTH_SHORT).show();
                EditText port4 = (EditText) findViewById(R.id.port4);
                String port14 = port4.getText().toString();
                Intent intent = new Intent(MainActivity.this,MainActivity2.class);
                intent.putExtra("port1", port14);
                intent.putExtra("ip1", ip14);
                startActivity(intent);
            }
        });
    }
}

