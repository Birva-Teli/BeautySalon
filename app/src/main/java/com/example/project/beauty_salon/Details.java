package com.example.project.beauty_salon;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Details extends Activity {
    Button btn1, btn2,adddet;
    EditText edsalonname,edadd;
    TextView tvot,tvct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        btn1=(Button)findViewById(R.id.btot);
        btn2=(Button)findViewById(R.id.btct);
        edsalonname=(EditText)findViewById(R.id.nameofsalon);
        edadd=(EditText)findViewById(R.id.edadd);
        tvot=(TextView)findViewById(R.id.tvot);
        tvct=(TextView)findViewById(R.id.tvct);
        adddet=(Button)findViewById(R.id.adddetails);
        final DBHelper helper = new DBHelper(getBaseContext(), null, null, 1);
        adddet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Details.this, "DtaSaved", Toast.LENGTH_SHORT).show();
                Intent i=new Intent(Details.this,ViewDetails.class);
                startActivity(i);            }
        });
    }
}
