package com.example.club.clubfactory;

import android.app.ActionBar;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ImageView facebook;
    private ImageView gmail;
    private ProgressDialog progress;
    final int totalProgressTime = 200;

//    private ProgressBar progressBar;
//    private Handler hdlr = new Handler();
//    private Thread thread;
//    private int i = 0;
//    private int j = 40;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        facebook = (ImageView)findViewById(R.id.facebooklogin);
        gmail = (ImageView)findViewById(R.id.gmaillogin);
        progress = new ProgressDialog(MainActivity.this);
        progress.setMessage("Loading");
        //progress.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progress.setIndeterminate(true);
        progress.setProgress(0);




        getSupportActionBar().setBackgroundDrawable(
                new ColorDrawable(Color.parseColor("#ffffff")));

        getSupportActionBar().setTitle(Html.fromHtml("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color='#000000'>Club Factory</font>"));




        facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progress.show();
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        int jumpTime = 0;
                        while(jumpTime < totalProgressTime)
                        {
                            try {
                                Thread.sleep(200);
                                jumpTime += 5;
                                progress.setProgress(jumpTime);
                                if(jumpTime == 200)
                                {
                                    progress.dismiss();
                                    Intent intent = new Intent(MainActivity.this,FacebookLogin.class);
                                    startActivity(intent);
                                }

                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }

                        }
                    }
                }).start();

            }
        });

        gmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"Currently Google sign is not avaliable",Toast.LENGTH_LONG).show();
            }
        });

//        progressBar = (ProgressBar) findViewById(R.id.progrssbarload);
//
//        new Thread(new Runnable() {
//            public void run() {
//                while (i < 100) {
//                    i += 1;
//                    // Update the progress bar and display the current value in text view
//                    hdlr.post(new Runnable() {
//                        public void run() {
//                            progressBar.setProgress(i);
//                            if(i>j)
//                            {
//                                Intent intent = new Intent(MainActivity.this,FacebookLogin.class);
//                                startActivity(intent);
//                                Toast.makeText(MainActivity.this,"First Login with facebook",Toast.LENGTH_SHORT).show();
//
//                            }
//                            if(i>100)
//                            {
//                                thread.stop();
//                            }
//                        }
//                    });
//                    try {
//                        // Sleep for 100 milliseconds to show the progress slowly.
//                        Thread.sleep(100);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        }).start();
    }

}