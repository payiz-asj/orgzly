package com.orgzly;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.orgzly.android.ui.MainActivity;



public class guide_page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide_page);
    }

    public void beiwang(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }

    public void calendar(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, calendar.class);
        startActivity(intent);
    }

    public void fanqie(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, fanqie.class);
        startActivity(intent);
    }

    public void course(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, course.class);
        startActivity(intent);
    }

    public void zhangben(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, zhangben.class);
        startActivity(intent);
    }




}
