package com.example.a20210320;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText et1 , et2, et3;
    Button bt1, bt2;
    TextView tv1, tv2;
    int a = 0;
    int b = 0;
    int c = 0;
    int strike;
    int ball;
    int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1=findViewById(R.id.et1);
        et2=findViewById(R.id.et2);
        et3=findViewById(R.id.et3);
        bt1=findViewById(R.id.bt1);
        bt2=findViewById(R.id.bt2);
        tv1=findViewById(R.id.tv1);
        tv2=findViewById(R.id.tv2);

        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count = 1;
                tv1.setText(null);
                tv2.setText(null);
                a = (int)(Math.random() * 9) + 1;
                b = (int)(Math.random() * 9) + 1;
                c = (int)(Math.random() * 9) + 1;

                while (a == b){
                    b = (int)(Math.random() * 9) + 1;
                }
                while (b == c || c == a){
                    c = (int)(Math.random() * 9) + 1;
                }

                Toast.makeText(getApplicationContext(),"숫자가 생성되었습니다." , Toast.LENGTH_SHORT).show();
            }

        });
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
                if(et1.getText().toString().equals("") || et2.getText().toString().equals("") || et3.getText().toString().equals("")){
                    tv1.setText("숫자를 입력하여 주세요");
                }

                else if(a == 0 || b == 0 || c == 0){
                    et1.setText(null);
                    et2.setText(null);
                    et3.setText(null);
                    tv1.setText("시작하기를 눌러주세요");
                }

                else {
                    int d = Integer.parseInt(et1.getText().toString());
                    int e = Integer.parseInt(et2.getText().toString());
                    int f = Integer.parseInt(et3.getText().toString());

                    tv1.setText(null);
                    strike = 0;
                    ball = 0;

                    if (d == a && e == b && f == c) {
                        tv2.setText(null);
                        tv1.setTextSize(25);
                        tv1.setGravity(Gravity.TOP);
                        tv2.setTextSize(25);
                        tv1.setText("\n" + count + "  번의 시도 끝에 \n  맞추었습니다");
                        tv2.setText("\n" + "다시 시작하려면 \n시작하기를 \n눌러주세요");

                    } else {
                        if (d == a) {
                            strike++;
                        } else if (d == b || d == c) {
                            ball++;
                        }

                        if (e == b) {
                            strike++;
                        } else if (e == a || e == c) {
                            ball++;
                        }

                        if (f == c) {
                            strike++;
                        } else if (f == a || f == b) {
                            ball++;
                        }

                        if (strike == 0 && ball == 0) {
                            tv1.setText("답이 없다");
                        } else {
                            tv1.setText("스트라이크 :  " + strike + "\n" + "볼 :  " + ball);
                        }
                        tv2.append("\n" + count + "번째     " + "입력숫자 :  " + d + e + f + "    " + "스트라이크 :  " + strike + "    " + "볼 : " + ball);
                        count++;
                    }
                }
            }
        });
    }
}