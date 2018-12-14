package com.adityasonel.verysweetalert;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.adityasonel.verysweetalertdialog.SweetAlertDialog;

public class SampleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample);

        TextView tv = findViewById(R.id.tv);
        tv.setOnClickListener(view -> {
            new SweetAlertDialog(getApplicationContext(), SweetAlertDialog.SUCCESS_TYPE)
                    .setConfirmText("OK")
                    .setCancelText("Cancel")
                    .setCancelClickListener(new SweetAlertDialog.OnSweetClickListener() {
                        @Override
                        public void onClick(SweetAlertDialog sweetAlertDialog) {

                        }
                    }).setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                @Override
                public void onClick(SweetAlertDialog sweetAlertDialog) {

                }
            });
        });
    }
}
