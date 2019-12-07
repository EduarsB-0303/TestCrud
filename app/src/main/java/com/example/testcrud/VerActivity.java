package com.example.testcrud;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class VerActivity extends AppCompatActivity {
    private TextView txtVer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver);

        this.txtVer = (TextView) findViewById(R.id.txtVer);
    }
}
