package com.PRM392.hongvietbui.assignment;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {
    private TextView tv_detail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        tv_detail = findViewById(R.id.tv_detail);
        Intent intent = getIntent();
        String value = intent.getStringExtra("CATEGORY_ID");
        if(value!=null)
            tv_detail.setText(value);
    }
}
