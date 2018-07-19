package com.example.shubhigupta.quizoidnew;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shubhigupta.quizoidnew.Database.DBHelper;

public class LoginMain extends AppCompatActivity {
    EditText usernameEt,passwordEt;
    TextView LoginBtn,RegisterNewOne,Cancel;
    DBHelper helper = new DBHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_main);
        usernameEt = (EditText) findViewById(R.id.username);
        passwordEt = (EditText) findViewById(R.id.password);

        LoginBtn = (TextView) findViewById(R.id.login);
        Cancel = (TextView) findViewById(R.id.cancel);
        RegisterNewOne = (TextView) findViewById(R.id.RegisterNew);

        //forgotPassword = 3

        LoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                usernameEt = (EditText) findViewById(R.id.username);
                String userstr = usernameEt.getText().toString();
                passwordEt = (EditText) findViewById(R.id.password);
                String passwordstr = passwordEt.getText().toString();
                String password = helper.searchPass(userstr);
                if(userstr.length()==0 || passwordstr.length()==0){
                    Toast.makeText(LoginMain.this, "Fill in details", Toast.LENGTH_SHORT).show();
                }
                else if(password.equals(passwordstr)){
                    Intent i1 = new Intent(LoginMain.this,questions_new.class);
                    Toast t = Toast.makeText(LoginMain.this, "Log In Successful", Toast.LENGTH_SHORT);
                    t.show();
                    i1.putExtra("name",userstr);
                    startActivity(i1);
                    finish();
                }
                else {
                    Toast t = Toast.makeText(LoginMain.this, "Invalid password or username. Please try again", Toast.LENGTH_SHORT);
                    t.show();
                    usernameEt.setText("");
                    passwordEt.setText("");
                }
            }
        });

        Cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        RegisterNewOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),Register_activity.class);
                startActivity(i);
                overridePendingTransition(R.anim.zoom_in, R.anim.zoom_out);
                finish();
            }
        });

    }
}
