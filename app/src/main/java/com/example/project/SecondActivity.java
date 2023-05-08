package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SecondActivity extends AppCompatActivity {

    private Button goBack;

    private Button save;

    private EditText inputData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        goBack = (Button) findViewById(R.id.button2);

        inputData = (EditText) findViewById(R.id.data);

        final String sharedString = inputData.getText().toString();

        goBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SecondActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });

        save = (Button) findViewById(R.id.savebutton);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences saveFile = getSharedPreferences("sharekey", MODE_PRIVATE);
                SharedPreferences.Editor saveEditor = saveFile.edit();
                saveEditor.putString("sharekey",sharedString);
            }
        });
    }
}