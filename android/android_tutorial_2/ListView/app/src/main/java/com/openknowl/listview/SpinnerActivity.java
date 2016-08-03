package com.openknowl.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class SpinnerActivity extends AppCompatActivity {
    Spinner mainSpinner;
    Spinner subSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);

        mainSpinner = (Spinner) findViewById(R.id.mainSpinner);
        subSpinner = (Spinner) findViewById(R.id.subSpinner);

        String[] arrayList = {"설정하기", "이용약관", "개인정보수집방침", "개발자", "로그아웃"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arrayList);
        ArrayAdapter<String> subAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arrayList);

        mainSpinner.setAdapter(adapter);
        subSpinner.setAdapter(subAdapter);
    }
}
