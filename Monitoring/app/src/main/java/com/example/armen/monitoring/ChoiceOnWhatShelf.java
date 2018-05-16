package com.example.armen.monitoring;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.armen.monitoring.db.DBHelper;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ChoiceOnWhatShelf extends AppCompatActivity {
    private DBHelper dbHelper;
    private String qrCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choic_on_what_shelf);
        ButterKnife.bind(this);
        dbHelper = DBHelper.newInstance(this);
        qrCode = getIntent().getStringExtra("qrcode");
        if(qrCode == null || qrCode.equals("")){
            Log.i("ssssssssssssssss", "qrCode" + null);
        }else {
            Log.i("ssssssssssssssss", "qrCode" + qrCode);
        }
    }

    @OnClick(R.id.btn_brim_hat)
    void clickBrimHat() {
        clickToButtons("шляпа край<");
    }
    @OnClick(R.id.btn_brim_eyes)
    void clickBrimEyes() {
        clickToButtons("глаза край<");
    }
    @OnClick(R.id.btn_brim_hand)
    void clickBrimHand() {
        clickToButtons("руки край<");
    }
    @OnClick(R.id.btn_brim_belt)
    void clickBrimBelt() {
        clickToButtons("пояс край<");
    }
    @OnClick(R.id.btn_brim_knees)
    void clickBrimKnees() {
        clickToButtons("колени край<");
    }
    @OnClick(R.id.btn_brim_foot)
    void clickBrimFoot() {
        clickToButtons("ноги край<");
    }




    @OnClick(R.id.btn_left_hat)
    void clickLeftHat() {
        clickToButtons("шляпа левее");
    }
    @OnClick(R.id.btn_left_eyes)
    void clickLeftEyes() {
        clickToButtons("глаза левее");
    }
    @OnClick(R.id.btn_left_hand)
    void clickLeftHand() {
        clickToButtons("руки левее");
    }
    @OnClick(R.id.btn_left_belt)
    void clickLeftBelt() {
        clickToButtons("пояс левее");
    }
    @OnClick(R.id.btn_left_knees)
    void clickLeftKnees() {
        clickToButtons("колени левее");
    }
    @OnClick(R.id.btn_left_foot)
    void clickLeftFoot() {
        clickToButtons("ноги левее");
    }


    @OnClick(R.id.btn_centre_hat)
    void clickCentreHat() {
        clickToButtons("шляпа центр");
    }
    @OnClick(R.id.btn_centre_eyes)
    void clickCentreEyes() {
        clickToButtons("глаза центр");
    }
    @OnClick(R.id.btn_centre_hand)
    void clickCentreHand() {
        clickToButtons("руки центр");
    }
    @OnClick(R.id.btn_centre_belt)
    void clickCentreBelt() {
        clickToButtons("пояс центр");
    }
    @OnClick(R.id.btn_centre_knees)
    void clickCentreKness() {
        clickToButtons("колени центр");
    }
    @OnClick(R.id.btn_centre_foot)
    void clickCentreFoot() {
        clickToButtons("ноги центр");
    }




    @OnClick(R.id.btn_right_hat)
    void clickRightHat() {
        clickToButtons("шляпа правее");
    }
    @OnClick(R.id.btn_right_eyes)
    void clickRightEyes() {
        clickToButtons("глаза правее");
    }
    @OnClick(R.id.btn_right_hand)
    void clickRightHand() {
        clickToButtons("руки правее");
    }
    @OnClick(R.id.btn_right_belt)
    void clickRightBelt() {
        clickToButtons("пояс правее");
    }
    @OnClick(R.id.btn_right_knees)
    void clickRightKnees() {
        clickToButtons("колени правее");
    }
    @OnClick(R.id.btn_right_foot)
    void clickRightFoot() {
        clickToButtons("ноги правее");
    }



    @OnClick(R.id.btn_end_hat)
    void clickEndHat() {
        clickToButtons("шляпа край >");
    }
    @OnClick(R.id.btn_end_eyes)
    void clickEndEyes() {
        clickToButtons("глаза край >");
    }
    @OnClick(R.id.btn_end_hand)
    void clickEndHand() {
        clickToButtons("руки край >");
    }
    @OnClick(R.id.btn_end_belt)
    void clickEndBelt() {
        clickToButtons("пояс край >");
    }
    @OnClick(R.id.btn_end_knees)
    void clickEndKnees() {
        clickToButtons("колени край >");
    }
    @OnClick(R.id.btn_end_foot)
    void clickEndFoot() {
        clickToButtons("ноги край >");
    }

    private void colorButton(RelativeLayout layout) {
        layout.setBackgroundResource(R.color.colorPrimaryDark);
    }



    private void clickToButtons(String position) {
        dbHelper.addQRCode("штрих код товарa: "  +qrCode +  ": находится " + position);
        Intent intent = new Intent(ChoiceOnWhatShelf.this, PhotoActivity.class);
        startActivity(intent);
//        finish();
    }
}
