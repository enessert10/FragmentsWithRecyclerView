package com.example.fragmentswithrecyclerview;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements PersonAdapter.ItemClicked {

    TextView tvName,tvTel;
    EditText etTel;
    Button btnAdd;
    ListFrag listFrag;
    FragmentManager fragmentManager;

    AutoCompleteTextView etNameAuto;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvName = findViewById(R.id.tvName);
        tvTel= findViewById(R.id.tvTel);
        etTel= findViewById(R.id.etTel);
        btnAdd= findViewById(R.id.btnAdd);
        etNameAuto = (AutoCompleteTextView) findViewById(R.id.etName);


       fragmentManager = this.getSupportFragmentManager();
        listFrag = (ListFrag) fragmentManager.findFragmentById(R.id.listFrag);
        //Auto complete codes
        String [] names ={"Ahmet","Anıl","Akın","Ayşe"};

        ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(this,R.layout.auto_complete,names);

        etNameAuto.setThreshold(1);
        etNameAuto.setAdapter(adapter);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(etNameAuto.getText().toString().isEmpty() || etTel.getText().toString().isEmpty())
                {
                    Toast.makeText(MainActivity.this, "Please enter all fields!", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    ApplicationClass.people.add(new Person(etNameAuto.getText().toString().trim(),etTel.getText().toString().trim()));
                    Toast.makeText(MainActivity.this, "Person successfully added!", Toast.LENGTH_SHORT).show();
                    etNameAuto.setText(null);
                    etTel.setText(null);
                    listFrag.NotifyDataChanged();
                }

            }
        });

        OnItemClicked(0);
    }

    @Override
    public void OnItemClicked(int index) {

        tvName.setText(ApplicationClass.people.get(index).getName());
        tvTel.setText(ApplicationClass.people.get(index).getTel());

    }
}
