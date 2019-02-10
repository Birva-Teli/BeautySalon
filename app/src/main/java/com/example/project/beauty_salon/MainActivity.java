package com.example.project.beauty_salon;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
Button buser,bsalon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buser=(Button)findViewById(R.id.user);
        bsalon=(Button)findViewById(R.id.salon);
        buser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent i=new Intent(MainActivity.this,LoginSalon.class);
                startActivity(i);
            }
        });
        bsalon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity.this,LoginSalon.class);
                startActivity(i);
            }
        });
    }
}
