package com.dotplays.adapterandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Spinner spinner;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = findViewById(R.id.spinner);
        listView = findViewById(R.id.lvList);
        // khai bao du lieu fake
        final String[] cities = {"Sai Gon", "Bac Ninh", "Ha Noi", "Vu Han", "Italy",
                "Phap"};
        ArrayAdapter<String> adapter =
                new ArrayAdapter<>(MainActivity.this,
                        android.R.layout.simple_spinner_dropdown_item, cities);

        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String itemSelected = cities[i];
                Toast.makeText(MainActivity.this,
                        itemSelected, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        final List<Student> students = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            Student student = new Student();
            student.setId(String.valueOf(i));
            student.setName("Huy Nguyen " + i);
            student.setNumber(new Random().nextInt() + "");

            // them sinh vien vao mang
            students.add(student);
        }

        final StudentAdapter studentAdapter = new
                StudentAdapter(students);

        listView.setAdapter(studentAdapter);


//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView,
//                                    View view, int i, long l) {
//
//                String name = students.get(i).getName();
//                Toast.makeText(MainActivity.this, name,
//                        Toast.LENGTH_SHORT).show();
//
//            }
//        });


    }


}
