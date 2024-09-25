package com.fpt.khangpq.styleandthemesse1729;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private Button btnExplicit;
    private Button btnImplicit;
    private EditText edtData;
    private ActivityResultLauncher<Intent> startActivity2ForResult;

    private void bindingView() {
        btnExplicit = findViewById(R.id.btnExplicit);
        btnImplicit = findViewById(R.id.btnImplicit);
        edtData = findViewById(R.id.edtData);
    }

    private void bindingAction() {
        btnExplicit.setOnClickListener(this::onBtnExplicitClick);
        btnImplicit.setOnClickListener(this::onBtnImplicitClick);
        startActivity2ForResult = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(), this::onActivityResult1
        );
    }

    private void onActivityResult1(ActivityResult activityResult) {
        if (activityResult.getResultCode() == Constant.RESULT_CODE_OK) {
            Intent i = activityResult.getData();
            String newData = i.getStringExtra("newData");
            edtData.setText(newData);
        } else {
            Toast.makeText(this, "LOI ROI", Toast.LENGTH_SHORT).show();
        }
    }

    private void onBtnImplicitClick(View view) {
        String url = edtData.getText().toString();
        Uri uri = Uri.parse("tel:" + url);
        Intent i = new Intent(Intent.ACTION_CALL, uri);
        startActivity(i);
    }

    private static final int REQUEST_CODE_DO_SOMETHING = 20;

    private void onBtnExplicitClick(View view) {
        Intent i = new Intent(this, MainActivity2.class);
        String data = edtData.getText().toString();
        i.putExtra("data", data);
        i.putExtra("age", 18);
//        startActivity(i);
//        startActivityForResult(i, REQUEST_CODE_DO_SOMETHING);
        startActivity2ForResult.launch(i);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case REQUEST_CODE_DO_SOMETHING:
                if (resultCode == Constant.RESULT_CODE_OK) {
                    String newData = data.getStringExtra("newData");
                    edtData.setText(newData);
                } else {
                    Toast.makeText(this, "LOI ROI", Toast.LENGTH_SHORT).show();
                }
                break;

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
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
        String data = i.getStringExtra("newData");
        edtData.setText(data);
    }
}