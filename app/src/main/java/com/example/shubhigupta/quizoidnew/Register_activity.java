package com.example.shubhigupta.quizoidnew;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shubhigupta.quizoidnew.Database.DBHelper;
import com.example.shubhigupta.quizoidnew.Database.User;

public class Register_activity extends AppCompatActivity {
    DBHelper helper = new DBHelper(this);
    TextView register, cancel;
    EditText name,emailId,username,password,Confirmpassword,mobile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_activity);

        name = (EditText) findViewById(R.id.name);
        emailId = (EditText) findViewById(R.id.email);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.pass);
        Confirmpassword = (EditText) findViewById(R.id.pass2);
        //mobile = (EditText) findViewById(R.id.mobile);
        register = (TextView) findViewById(R.id.register);
        cancel = (TextView) findViewById(R.id.cancel);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String namestr = name.getText().toString();
                String emailIdstr = emailId.getText().toString();
                //String mobno = mobile.getText().toString();
                String usernamestr = username.getText().toString();
                String passstr = password.getText().toString();
                String confirmPass = Confirmpassword.getText().toString();
                if(namestr.length()==0 || emailIdstr.length()==0 || usernamestr.length()==0 || passstr.length()==0 || confirmPass.length()==0){
                    Toast.makeText(getApplicationContext(),"All fields are mandatory",Toast.LENGTH_SHORT).show();
                }
                //  **************************************************************************************
                // ek else if yaha hone chaiye check krne k liye ki username pehle se exist to nhi krta
                //  **************************************************************************************
                else if(!isEmail(emailIdstr)) {
                    Toast.makeText(getApplicationContext(),"Please enter valid email address",Toast.LENGTH_SHORT).show();
                    emailId.setText("");
                }
                /*else if(!isNumeric(mobno)) {
                    Toast.makeText(getApplicationContext(),"Please enter valid mobile number",Toast.LENGTH_SHORT).show();
                    mobile.setText("");
                }*/
                else if(!passstr.equals(confirmPass)){
                    Toast t = Toast.makeText(Register_activity.this,"Passwords don't match. Try again.",Toast.LENGTH_SHORT);
                    password.setText("");
                    Confirmpassword.setText("");
                    t.show();
                }
                else{
                    if(helper.searchPass(usernamestr) == ""){
                        User u = new User();
                        u.setName(namestr);
                        u.setEmailId(emailIdstr);
                        u.setUsername(usernamestr);
                        u.setPassword(passstr);
                        //u.setMobile(mobno);
                        helper.insertUser(u);
                        Toast t = Toast.makeText(Register_activity.this," Successfully registered ",Toast.LENGTH_SHORT);
                        t.show();
                        Intent intent = new Intent(getApplicationContext(), LoginMain.class);
                        startActivity(intent);
                        overridePendingTransition(R.anim.zoom_in, R.anim.zoom_out);
                        finish();
                    }
                    else{
                        Toast t  = Toast.makeText(Register_activity.this,"Username already exists",Toast.LENGTH_SHORT);
                        username.setText("");
                        password.setText("");
                        Confirmpassword.setText("");
                        t.show();

                    }
                }

            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LoginMain.class);
                startActivity(intent);
                startActivity(intent);
                overridePendingTransition(R.anim.zoom_in, R.anim.zoom_out);
                finish();
            }
        });

    }
    private boolean isNumeric(String str)
    {
        for (char c : str.toCharArray())
        {
            if (!Character.isDigit(c)) return false;
        }
        return true;
    }
    private boolean isEmail(String str)
    {
        for (char c : str.toCharArray())
        {
            if (c=='@') return true;
        }
        return false;
    }
}
