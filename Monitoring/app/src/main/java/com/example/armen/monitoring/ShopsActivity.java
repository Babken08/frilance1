package com.example.armen.monitoring;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ShopsActivity extends AppCompatActivity {

    @BindView(R.id.recycler_shops)
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shops);
        ButterKnife.bind(this);

        List<String> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add("Адрес: г. Москва, Мичуринский проспект, д. 9, корп. 3");
        }
        ShopsAdapter adapter = new ShopsAdapter(this, list);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }


    @OnClick(R.id.btn_maps)
    void clickbtnmap() {
        startActivity(new Intent(ShopsActivity.this, MapsActivity.class));
    }
}
