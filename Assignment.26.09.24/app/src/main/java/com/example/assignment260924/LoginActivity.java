package com.example.assignment260924;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    private EditText edtName;
    private Button btnSubmit;
    private static final String NAME_KEY = "name";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        bindingViews();
        bindingActions();
    }

//    @Override
//    protected void onPause() {
//        edtName.setText("");
//        super.onPause();
//    }

    @Override
    protected void onResume() {
        edtName.setText("");
        super.onResume();
    }

    private void bindingViews() {
        edtName = findViewById(R.id.edtName);
        btnSubmit = findViewById(R.id.btnSubmit);
    }

    private void bindingActions(){
        btnSubmit.setOnClickListener(this:: onBtnSubmitExplicitClick);
    }

    private void onBtnSubmitExplicitClick(View view){
        String name = edtName.getText().toString();
        Intent i = new Intent(this, HomeActivity.class);
        i.putExtra("name", name);
        startActivity(i);
    }
}
