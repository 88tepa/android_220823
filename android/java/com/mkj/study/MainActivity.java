package com.mkj.study;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.MotionEvent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // 변수선언
    EditText etName;
    TextView tvName;

    Button btnGet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main8);
        // id연동
        etName = (EditText)findViewById(R.id.etName);
        tvName = (TextView)findViewById(R.id.tvName);
        findViewById(R.id.btnGet).setOnClickListener(mClickListener);
        findViewById(R.id.btnOut).setOnClickListener(mClickListener);
        findViewById(R.id.btnLog).setOnClickListener(mClickListener);

        // Log.d("태그명","메세지조합해서 찍기);
        btnGet = (Button)findViewById(R.id.btnGet);
        btnGet.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent motionEvent) {

                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    btnGet.setBackgroundColor(Color.TRANSPARENT);
                } else if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    btnGet.setBackgroundColor(Color.LTGRAY);
                }

                // sRGB
                // Color opaqueRed = Color.valueOf(0xffff0000); // from a color int
                // Color translucentRed = Color.valueOf(1.0f, 0.0f, 0.0f, 0.5f);

                return false;
            }
        });
    }
    // 버튼이벤트정의
    Button.OnClickListener mClickListener = new Button.OnClickListener() {
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btnGet: // 수행하고자 할 것들 기술
                    String name = etName.getText().toString();
                    tvName.setText(name);
                    Toast.makeText(MainActivity.this,"가져오기클릭!",Toast.LENGTH_SHORT).show();
                    Log.d("로그","가져오기 클릭 됨!"+name);

                    break;
            }
            switch (v.getId()) {
                case R.id.btnOut: // 수행하고자 할 것들 기술
                    Toast.makeText(MainActivity.this,"출력하기클릭!",Toast.LENGTH_SHORT).show();
                    Log.d("로그","출력하기 클릭 됨!");
                    break;
            }
            switch (v.getId()) {
                case R.id.btnLog: // 수행하고자 할 것들 기술
                    Toast.makeText(MainActivity.this,"로그찍기클릭!",Toast.LENGTH_SHORT).show();
                    Log.d("로그","로그찍기 클릭 됨!");
                    break;
            }


        }
    };

}