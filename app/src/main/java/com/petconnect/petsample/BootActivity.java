package com.petconnect.petsample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class BootActivity extends AppCompatActivity {

    public static final String BOOT_TYPE = "boot_type";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boot);
    }

    public void onStatic(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra(BOOT_TYPE, true);
        startActivity(intent);
    }

    public void onDynamic(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra(BOOT_TYPE, false);
        startActivity(intent);
    }
}
