package com.example.assignment260924;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity
{
    private TextView tvNameValue;
    private Button btnClose;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        bindingViews();
        bindingActions();
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        String name = getIntent().getStringExtra("name");
        tvNameValue.setText(name);
    }

    private void bindingViews()
    {
        tvNameValue = findViewById(R.id.tvNameValue);
        btnClose = findViewById(R.id.btnClose);
    }

    private void bindingActions(){
        btnClose.setOnClickListener(v -> {finishAffinity();});
    }

}
