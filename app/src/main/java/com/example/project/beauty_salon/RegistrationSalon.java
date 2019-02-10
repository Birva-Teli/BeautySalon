package com.example.project.beauty_salon;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegistrationSalon extends Activity {
Button btreg,btreset;
EditText ed1,ed2,ed3,ed4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_salon);
        btreg=(Button)findViewById(R.id.btnsalonreg);
        btreset=(Button)findViewById(R.id.btnsalonreset);
        ed1=(EditText)findViewById(R.id.etusername);
        ed2=(EditText)findViewById(R.id.etuserpass);
        ed3=(EditText)findViewById(R.id.etuseremail);
        ed4=(EditText)findViewById(R.id.etuserphn);
        final DBHelper helper = new DBHelper(getBaseContext(), null, null, 1);

        btreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(ed1.getText().length()>0 && ed2.getText().length()>0)
                {
                    helper.inrecords(ed1.getText().toString(), ed2.getText().toString(),ed3.getText().toString(), ed4.getText().toString());
                }
                Toast.makeText(RegistrationSalon.this, "DtaSaved", Toast.LENGTH_SHORT).show();
                Intent in=new Intent(RegistrationSalon.this,LoginSalon.class);
                startActivity(in);

            }
        });
        btreset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ed1.setText("");
                ed2.setText("");
                ed3.setText("");
                ed3.setText("");
                ed4.setText("");

            }
        });
    }
}
