package com.example.armen.monitoring;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_maps)
    void clickBtnMap() {
        startActivity(new Intent(MainActivity.this, MapsActivity.class));
    }

    @OnClick(R.id.btn_shops)
    void clickBtnShops() {
        startActivity(new Intent(MainActivity.this, ShopsActivity.class));
//        startActivity(new Intent(MainActivity.this, PriceActivity.class));
    }

    @Override
    public void onBackPressed() {
//        super.onBackPressed();
//        System.exit(0);

        Intent a = new Intent(Intent.ACTION_MAIN);
        a.addCategory(Intent.CATEGORY_HOME);
        a.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(a);
    }
}
