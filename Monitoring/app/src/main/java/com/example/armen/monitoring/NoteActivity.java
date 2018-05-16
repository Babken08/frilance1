package com.example.armen.monitoring;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class NoteActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);
        ButterKnife.bind(this);
    }

//    @OnClick(R.id.btn_next)
//    void clickBtnNext() {
//        startActivity(new Intent(NoteActivity.this, PhotoActivity.class));
//    }

    @OnClick(R.id.img_back)
    void clickImgBack() {
        onBackPressed();
    }


    @OnClick(R.id.finish)
    void btnFinsh() {
        startActivity(new Intent(NoteActivity.this, MainActivity.class));
    }
}
