package com.adityasonel.verysweetalert;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.adityasonel.verysweetalertdialog.VerySweetAlertDialog;

public class SampleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample);

        TextView tv = findViewById(R.id.tv);
        tv.setOnClickListener(view -> {
            new VerySweetAlertDialog(SampleActivity.this, VerySweetAlertDialog.WARNING_TYPE)
                    .setConfirmText("Yeah Sure")
                    .setCancelText("Cancel")
                    .setCancelClickListener(VerySweetAlertDialog::dismissWithAnimation).setConfirmClickListener(VerySweetAlertDialog::dismissWithAnimation).show();
        });
    }
}
