package com.prm392.hongvietbui.myapplication;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class PhoneActivity extends AppCompatActivity {
    private Button btnCall;
    private EditText edtPhoneNumber;

    private void bindingView(){
        btnCall = findViewById(R.id.btnCall);
        edtPhoneNumber = findViewById(R.id.edtPhoneNumber);
    }

    private void bindingAction(){
        btnCall.setOnClickListener(this::onBtnCallClick);
    }

    private void onBtnCallClick(View view){
        String phoneNumber = edtPhoneNumber.getText().toString();
        //Check if the permission is granted
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
            call(phoneNumber);
        } else {
            requestPhoneCallPermission();
        }
    }

    private void requestPhoneCallPermission(){
        //Check if the permission is denied
        if(ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.CALL_PHONE)){
            new AlertDialog.Builder(this)
                .setTitle("Permission needed")
                .setMessage("This permission is needed to make a phone call")
                .setPositiveButton("OK", (dialog, which) -> ActivityCompat.requestPermissions(PhoneActivity.this, new String[]{Manifest.permission.CALL_PHONE}, 123))
                .create().show();
        }else{
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, 123);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 123) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                String phoneNumber = edtPhoneNumber.getText().toString();
                call(phoneNumber);
            } else {
                Toast.makeText(this, "Permission denied", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void call(String phoneNumber){
        Toast.makeText(this, phoneNumber, Toast.LENGTH_SHORT).show();
        Intent i = new Intent(Intent.ACTION_CALL);
        i.setData(Uri.parse("tel:" + phoneNumber));
        startActivity(i);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_phone);
        bindingView();
        bindingAction();
    }
}
