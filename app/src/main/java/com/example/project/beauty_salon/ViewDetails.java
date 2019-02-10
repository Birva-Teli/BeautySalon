package com.example.project.beauty_salon;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ViewDetails extends Activity {
TextView salname,saladd;
Button ok;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_details);
        salname=(TextView)findViewById(R.id.santv);
        saladd=(TextView)findViewById(R.id.adtv);
        ok=(Button)findViewById(R.id.ok);
        final DBHelper helper = new DBHelper(getBaseContext(), null, null, 1);
       // Cursor cur=helper.getalldetails();
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(ViewDetails.this,SalonList.class);
                startActivity(i);
            }
        });
    }
}
