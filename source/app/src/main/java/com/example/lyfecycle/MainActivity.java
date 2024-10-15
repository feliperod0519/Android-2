package com.example.lyfecycle;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Button btnToSecond = findViewById(R.id.buttonGoToSecond);
        btnToSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToSecondActivity();
            }
        });

        Button btnGoToGoogle = findViewById(R.id.goToGoogle);
        btnGoToGoogle.setOnClickListener(new View.OnClickListener(){

                                             @Override
                                             public void onClick(View v) {
                                                 goToGoogle();
                                             }
                                         });


        Toast.makeText(this, "OnCreate called", Toast.LENGTH_SHORT).show();
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "OnStart called", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "OnResume called", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "onPause called", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "onStop called", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this, "onRestart called", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "onDestroy called", Toast.LENGTH_SHORT).show();
    }

    public void goToSecondActivity(){
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }

    public void goToGoogle(){
        Uri webPage= Uri.parse("https://www.google.ca");
        Intent intent = new Intent(Intent.ACTION_VIEW,webPage);
        startActivity(intent);
    }
}