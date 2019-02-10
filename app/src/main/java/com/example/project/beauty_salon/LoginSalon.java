package com.example.project.beauty_salon;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Path;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginSalon extends Activity {
Button breg,blogin;
EditText ed1,ed2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_salon);
        final DBHelper helper = new DBHelper(getBaseContext(), null, null, 1);
        breg=(Button)findViewById(R.id.btnreg);
        blogin=(Button)findViewById(R.id.btnlogin);
        ed1=(EditText)findViewById(R.id.etname);
        ed2=(EditText)findViewById(R.id.etpasslogin);
        breg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i=new Intent(LoginSalon.this,RegistrationSalon.class);
                startActivity(i);
            }
        });
     blogin.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             Toast.makeText(getApplicationContext(),"Username Password Matched",Toast.LENGTH_LONG).show();

             Cursor cur = helper.Selrec(ed1.getText().toString(),ed2.getText().toString());
             if(cur.getCount()!=0)
             {
                 Toast.makeText(getApplicationContext(),"Username Password Matched",Toast.LENGTH_LONG).show();
                 Intent i=new Intent(LoginSalon.this,Options.class);
                 startActivity(i);
             }
             else
             {
                 Toast.makeText(getApplicationContext(),"Username Password not matched",Toast.LENGTH_LONG).show();
             }
         }
     });
    }
}
