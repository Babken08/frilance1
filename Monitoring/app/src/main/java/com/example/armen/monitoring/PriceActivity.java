package com.example.armen.monitoring;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.annotation.UiThread;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.armen.monitoring.db.DBHelper;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PriceActivity extends AppCompatActivity {

    @BindView(R.id.tv_price_text)
    TextView textView;
    @BindView(R.id.btn_one)
    Button btn1;
    @BindView(R.id.btn_2)
    Button btn2;
    @BindView(R.id.btn_3)
    Button btn3;
    @BindView(R.id.btn_4)
    Button btn4;
    @BindView(R.id.btn_5)
    Button btn5;
    @BindView(R.id.btn_6)
    Button btn6;
    @BindView(R.id.btn_7)
    Button btn7;
    @BindView(R.id.btn_8)
    Button btn8;
    @BindView(R.id.btn_9)
    Button btn9;
    @BindView(R.id.btn_0)
    Button btn0;
    @BindView(R.id.btn_delete)
    Button btnDelete;

    @BindView(R.id.btn_dot)
    Button btnDot;

    private String resultText = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_price);
        ButterKnife.bind(this);
    }
//
    @OnClick(R.id.btn_one)
    void clickBtn1() {
        colorButtons(btn1);
       clickButtons("1");
    }
    @OnClick(R.id.btn_2)
    void clickBtn2() {
        colorButtons(btn2);
        clickButtons("2");
    }
    @OnClick(R.id.btn_3)
    void clickBtn3() {
        colorButtons(btn3);
        clickButtons("3");

    }
    @OnClick(R.id.btn_4)
    void clickBtn4() {
        colorButtons(btn4);
        clickButtons("4");

    }
    @OnClick(R.id.btn_5)
    void clickBtn5() {
        colorButtons(btn5);
        clickButtons("5");

    }
    @OnClick(R.id.btn_6)
    void clickBtn6() {
        colorButtons(btn6);
        clickButtons("6");

    }
    @OnClick(R.id.btn_7)
    void clickBtn7() {
        colorButtons(btn7);
        clickButtons("7");

    }
    @OnClick(R.id.btn_8)
    void clickBtn8() {
        colorButtons(btn8);
        clickButtons("8");

    }
    @OnClick(R.id.btn_9)
    void clickBtn9() {
        colorButtons(btn9);
        clickButtons("9");

    }
    @OnClick(R.id.btn_0)
    void clickBtn0() {
        colorButtonsWhite(btn0);
        clickButtons("0");
    }
    @OnClick(R.id.btn_dot)
    void clickBtnDot() {
        colorButtonsWhite(btnDot);
        clickButtons(".");
    }
    @OnClick(R.id.btn_delete)
    void clickBtnDelete() {
        colorButtonsWhite(btnDelete);
        if(resultText.length()>0) {
            resultText = resultText.substring(0, resultText.length()-1);
            textView.setText(resultText);
        }
    }

    @OnClick(R.id.img_back)
    void clickImgBack() {
        onBackPressed();
    }
    @SuppressLint("SetTextI18n")
    private void clickButtons(String number) {
        resultText = resultText + number;
        textView.setText(resultText+"p");
    }

    @OnClick(R.id.btn_next)
    void clickNext() {
        startActivity(new Intent(PriceActivity.this, NoteActivity.class));
    }

    private void colorButtons(final Button button) {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        button.setBackgroundResource(R.drawable.round);
                        try {
                            Thread.sleep(200);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }
                });
            }
        });

        t.start();
        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        button.setBackgroundResource(R.drawable.round_orang);
    }

    private void colorButtonsWhite(final Button button) {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        button.setBackgroundResource(R.drawable.round_white);
                        try {
                            Thread.sleep(200);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }
                });
            }
        });

        t.start();
        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        button.setBackgroundResource(R.drawable.round_orang);
    }
}
