package com.openknowl.helloandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView textView;
    ImageView imageView;
    Button testButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // findViewById는 setContentView 에서 가져온 레이아웃에 있는 아이디를 통해서
        // 각 위젯의 인스턴스를 가져올 수 있도록 해준다.
        // 안드로이드에서 시각화된 것들은 View를 상속하여 구현되어있다.
        // 따라서 findViewById 는 View를 리턴해주고
        // 그 리턴된 인스턴스를 xml에 있는 타입에 맞게 다운캐스팅하여 사용한다.
        textView = (TextView) findViewById(R.id.textView);
        imageView = (ImageView) findViewById(R.id.imageView);
        testButton = (Button) findViewById(R.id.testButton);

        // 각 뷰에 이벤트 리스너를 달 수 있다.
        // 이벤트리스너는 다양한 종류가 있지만 대표적으로 onClickListener 를 많이 사용.
        // 익명 클래스로 사용할 수 있다.
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Toast 메세지는 안드로이드 기기 하단에 잠시 나왔다가 사라지는 메시지를 말한다.
                Toast.makeText(MainActivity.this, "textView!", Toast.LENGTH_SHORT).show();
                textView.setText("클릭되었음!");
            }
        });

        imageView.setOnClickListener(this);
        testButton.setOnClickListener(this);
    }

    // 인터페이스를 구현해서도 사용이 가능하다.
    @Override
    public void onClick(View view) {
        Toast.makeText(MainActivity.this, "인터페이스를 구현해서도 사용할 수 있다.\nview = " + view.getId(), Toast.LENGTH_SHORT).show();

        // 다른 화면으로 넘어가는 것은 인텐트를 이용한다.
        Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
        startActivity(intent);

        // 액티비티를 제거한다.
        finish();
    }
}
