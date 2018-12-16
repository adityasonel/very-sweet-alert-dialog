package com.adityasonel.verysweetalert;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.TextView;

import com.adityasonel.verysweetalertdialog.VerySweetAlertDialog;

import androidx.appcompat.app.AppCompatActivity;

public class SampleActivity extends AppCompatActivity implements View.OnClickListener {

    private int i = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample);
        TextView logoTv = findViewById(R.id.logo_tv);
        logoTv.setText("Very SweetAlert\nDialog");

        findViewById(R.id.basic_test).setOnClickListener(this);
        findViewById(R.id.under_text_test).setOnClickListener(this);
        findViewById(R.id.error_text_test).setOnClickListener(this);
        findViewById(R.id.success_text_test).setOnClickListener(this);
        findViewById(R.id.warning_confirm_test).setOnClickListener(this);
        findViewById(R.id.warning_cancel_test).setOnClickListener(this);
        findViewById(R.id.custom_img_test).setOnClickListener(this);
        findViewById(R.id.progress_dialog).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.basic_test:
                // default title "Here's a message!"
                VerySweetAlertDialog sd = new VerySweetAlertDialog(this);
                sd.setCancelable(true);
                sd.setCanceledOnTouchOutside(true);
                sd.show();
                break;
            case R.id.under_text_test:
                new VerySweetAlertDialog(this)
                        .setContentText("It's pretty, isn't it?")
                        .show();
                break;
            case R.id.error_text_test:
                new VerySweetAlertDialog(this, VerySweetAlertDialog.ERROR_TYPE)
                        .setTitleText("Oops...")
                        .setContentText("Something went wrong!")
                        .show();
                break;
            case R.id.success_text_test:
                new VerySweetAlertDialog(this, VerySweetAlertDialog.SUCCESS_TYPE)
                        .setTitleText("Good job!")
                        .setContentText("You clicked the button!")
                        .show();
                break;
            case R.id.warning_confirm_test:
                new VerySweetAlertDialog(this, VerySweetAlertDialog.WARNING_TYPE)
                        .setTitleText("Are you sure?")
                        .setContentText("Won't be able to recover this file!")
                        .setConfirmText("Yes,delete it!")
                        .setConfirmClickListener(sDialog -> {
                            // reuse previous dialog instance
                            sDialog.setTitleText("Deleted!")
                                    .setContentText("Your imaginary file has been deleted!")
                                    .setConfirmText("OK")
                                    .setConfirmClickListener(null)
                                    .changeAlertType(VerySweetAlertDialog.SUCCESS_TYPE);
                        })
                        .show();
                break;
            case R.id.warning_cancel_test:
                new VerySweetAlertDialog(this, VerySweetAlertDialog.WARNING_TYPE)
                        .setTitleText("Are you sure?")
                        .setContentText("Won't be able to recover this file!")
                        .setCancelText("No,cancel plx!")
                        .setConfirmText("Yes,delete it!")
                        .showCancelButton(true)
                        .setCancelClickListener(sDialog -> {
                            // reuse previous dialog instance, keep widget user state, reset them if you need
                            sDialog.setTitleText("Cancelled!")
                                    .setContentText("Your imaginary file is safe :)")
                                    .setConfirmText("OK")
                                    .showCancelButton(false)
                                    .setCancelClickListener(null)
                                    .setConfirmClickListener(null)
                                    .changeAlertType(VerySweetAlertDialog.ERROR_TYPE);

                            // or you can new a VerySweetAlertDialog to show
                           /* sDialog.dismiss();
                            new VerySweetAlertDialog(SampleActivity.this, VerySweetAlertDialog.ERROR_TYPE)
                                    .setTitleText("Cancelled!")
                                    .setContentText("Your imaginary file is safe :)")
                                    .setConfirmText("OK")
                                    .show();*/
                        })
                        .setConfirmClickListener(sDialog -> sDialog.setTitleText("Deleted!")
                                .setContentText("Your imaginary file has been deleted!")
                                .setConfirmText("OK")
                                .showCancelButton(false)
                                .setCancelClickListener(null)
                                .setConfirmClickListener(null)
                                .changeAlertType(VerySweetAlertDialog.SUCCESS_TYPE))
                        .show();
                break;
            case R.id.custom_img_test:
                new VerySweetAlertDialog(this, VerySweetAlertDialog.CUSTOM_IMAGE_TYPE)
                        .setTitleText("Sweet!")
                        .setContentText("Here's a custom image.")
                        .setCustomImage(R.drawable.fox)
                        .show();
                break;
            case R.id.progress_dialog:
                final VerySweetAlertDialog pDialog = new VerySweetAlertDialog(this, VerySweetAlertDialog.PROGRESS_TYPE)
                        .setTitleText("Loading");
                pDialog.show();
                pDialog.setCancelable(false);
                new CountDownTimer(800 * 7, 800) {
                    public void onTick(long millisUntilFinished) {
                        // you can change the progress bar color by ProgressHelper every 800 millis
                        i++;
                        switch (i){
                            case 0:
                                pDialog.getProgressHelper().setBarColor(getResources().getColor(R.color.blue_btn_bg_color));
                                break;
                            case 1:
                                pDialog.getProgressHelper().setBarColor(getResources().getColor(R.color.material_deep_teal_50));
                                break;
                            case 2:
                                pDialog.getProgressHelper().setBarColor(getResources().getColor(R.color.success_stroke_color));
                                break;
                            case 3:
                                pDialog.getProgressHelper().setBarColor(getResources().getColor(R.color.material_deep_teal_20));
                                break;
                            case 4:
                                pDialog.getProgressHelper().setBarColor(getResources().getColor(R.color.material_blue_grey_80));
                                break;
                            case 5:
                                pDialog.getProgressHelper().setBarColor(getResources().getColor(R.color.warning_stroke_color));
                                break;
                            case 6:
                                pDialog.getProgressHelper().setBarColor(getResources().getColor(R.color.success_stroke_color));
                                break;
                        }
                    }

                    public void onFinish() {
                        i = -1;
                        pDialog.setTitleText("Success!")
                                .setConfirmText("OK")
                                .changeAlertType(VerySweetAlertDialog.SUCCESS_TYPE);
                    }
                }.start();
                break;
        }
    }
}
