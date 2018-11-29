package com.example.club.clubfactory;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class result extends AppCompatActivity {

    private TextView UserName;
    private EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        UserName = (TextView)findViewById(R.id.username);
        password = (EditText)findViewById(R.id.passwordtextview);

        UserName.setText((CharSequence) password);


    }
}
