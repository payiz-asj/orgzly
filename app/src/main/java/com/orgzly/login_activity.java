package com.orgzly;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class login_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_activity);
    }

    /*
     * Called when the user taps the Send button
     */
    public void login(View view) {
        // Do something in response to button
        Intent intent;
        intent = new Intent(this, guide_page.class);
        EditText editText = (EditText) findViewById(R.id.editText);
        EditText editText2 = (EditText) findViewById(R.id.editText2);
        String zh = editText.getText().toString();
        String mima = editText2.getText().toString();
        if((zh.equals("161220001")) && (mima.equals("161220001"))) {
            //intent.putExtra(EXTRA_MESSAGE, zh);
            startActivity(intent);
        }
    }

    public int f_test(int x,int y) {
        return x*y;
    }
}
