package com.fpt.khangpq.styleandthemesse1729;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {

    private EditText edtShowdata;
    private Button btnSave;

    private void bindingView() {
        edtShowdata = findViewById(R.id.edtShowData);
        btnSave = findViewById(R.id.btnSave);
    }

    private void bindingAction() {
        btnSave.setOnClickListener(this::onBtnSaveClick);
    }

    private void onBtnSaveClick(View view) {
        String newData = edtShowdata.getText().toString();
        Intent i = new Intent();
        i.putExtra("newData", newData);
        setResult(Constant.RESULT_CODE_OK, i);
//        setResult(Constant.RESULT_CODE_ERROR);
        finish();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        bindingView();
        bindingAction();
        onReceiveIntent();
    }

    private void onReceiveIntent() {
        Intent i = getIntent();
        String data = i.getStringExtra("data");
        int age = i.getIntExtra("age", 0);
        Log.d("Khangpq.debug", "data: " + data + " age: " + age);
        edtShowdata.setText("data: " + data + "--- age: " + age);
    }

}