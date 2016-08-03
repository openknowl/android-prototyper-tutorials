package com.openknowl.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListViewActivity extends AppCompatActivity {
    ListView mainListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        setTitle("리스트뷰");
        mainListView = (ListView) findViewById(R.id.mainListView);

        String[] arrayList = {"설정하기", "이용약관", "개인정보수집방침", "개발자", "로그아웃"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arrayList);
        mainListView.setAdapter(adapter);
    }
}
