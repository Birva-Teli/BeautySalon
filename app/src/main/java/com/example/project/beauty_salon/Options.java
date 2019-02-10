package com.example.project.beauty_salon;

import android.app.Activity;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class Options extends Activity {
Button b1,b2,b3,b4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);
        b1=(Button)findViewById(R.id.fav);
        b2=(Button)findViewById(R.id.allshop);
        b3=(Button)findViewById(R.id.booking);
        b4=(Button)findViewById(R.id.booknow);
        final DBHelper helper = new DBHelper(getBaseContext(), null, null, 1);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Options.this,SalonList.class);
                startActivity(i);
            }
        });
    }


}
