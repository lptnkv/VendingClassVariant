package com.example.vendingclassvariant;

import android.os.Bundle;

import com.example.vendingclassvariant.Models.Automat;
import com.example.vendingclassvariant.Models.Student;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private MainActivity instance;
    public TextView autoName1;
    public TextView autoName2;
    public TextView autoName3;
    public TextView autoName4;

    public TextView autoStatus1;
    public TextView autoStatus2;
    public TextView autoStatus3;
    public TextView autoStatus4;

    public TextView clientId1;
    public TextView clientId2;
    public TextView clientId3;
    public TextView clientId4;

    public TextView autoCart1;
    public TextView autoCart2;
    public TextView autoCart3;
    public TextView autoCart4;

    public TextView autoQueue11;
    public TextView autoQueue12;

    public TextView autoQueue21;
    public TextView autoQueue22;

    public TextView autoQueue31;
    public TextView autoQueue32;

    public TextView autoQueue41;
    public TextView autoQueue42;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        instance = this;
        autoCart1 = findViewById(R.id.autoCart1);
        autoCart2 = findViewById(R.id.autoCart2);
        autoCart3 = findViewById(R.id.autoCart3);
        autoCart4 = findViewById(R.id.autoCart4);

        autoName1 = findViewById(R.id.autoName1);
        autoName2 = findViewById(R.id.autoName2);
        autoName3 = findViewById(R.id.autoName3);
        autoName4 = findViewById(R.id.autoName4);

        autoStatus1 = findViewById(R.id.autoStatus1);
        autoStatus2 = findViewById(R.id.autoStatus2);
        autoStatus3 = findViewById(R.id.autoStatus3);
        autoStatus4 = findViewById(R.id.autoStatus4);

        clientId1 = findViewById(R.id.clientId1);
        clientId2 = findViewById(R.id.clientId2);
        clientId3 = findViewById(R.id.clientId3);
        clientId4 = findViewById(R.id.clientId4);

        autoQueue11 = findViewById(R.id.autoQueue11);
        autoQueue12 = findViewById(R.id.autoQueue12);

        autoQueue21 = findViewById(R.id.autoQueue21);
        autoQueue22 = findViewById(R.id.autoQueue22);

        autoQueue31 = findViewById(R.id.autoQueue31);
        autoQueue32 = findViewById(R.id.autoQueue32);

        autoQueue41 = findViewById(R.id.autoQueue41);
        autoQueue42 = findViewById(R.id.autoQueue42);
    }

    public void updateData(Automat automat, Student student){
        switch (automat.getName()){
            case 1:
                autoStatus1.setText(automat.getStatus().toString());
                clientId1.setText(student.getName());
                autoCart1.setText(student.getCart().toString());
                break;
            case 2:
                autoStatus2.setText(automat.getStatus().toString());
                clientId2.setText(student.getName());
                autoCart2.setText(student.getCart().toString());
                break;
            case 3:
                clientId3.setText(student.getName());
                autoStatus3.setText(automat.getStatus().toString());
                autoCart3.setText(student.getCart().toString());
                break;
            case 4:
                clientId4.setText(student.getName());
                autoStatus4.setText(automat.getStatus().toString());
                autoCart4.setText(student.getCart().toString());
                break;
        }
    }

    public static MainActivity getInstance() {
        return instance;
    }
}