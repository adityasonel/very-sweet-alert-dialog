Very Sweet Alert Dialog
===================
VerySweetAlertDialog for Android inspired by SweetAlertDialog with a blend mixture of Material 2.0 design implementation.

## Setup
The simplest way to use VerySweetAlertDialog is to add the library dependency to your build.

add in your root `build.gradle` :
````
allprojects {
    repositories {
        ...
        maven { url "https://jitpack.io" }
    }
}
````
then add
````
implementation 'com.github.adityasonel:very-sweet-alert-dialog:v1.0.1'
````
in your app's `build.gradle`

## Usage

show material progress

    VerySweetAlertDialog pDialog = new VerySweetAlertDialog(this, VerySweetAlertDialog.PROGRESS_TYPE);
    pDialog.getProgressHelper().setBarColor(Color.parseColor("#A5DC86"));
    pDialog.setTitleText("Loading");
    pDialog.setCancelable(false);
    pDialog.show();

You can customize progress bar dynamically with materialish-progress methods via **VerySweetAlertDialog.getProgressHelper()**:
- resetCount()
- isSpinning()
- spin()
- stopSpinning()
- getProgress()
- setProgress(float progress)
- setInstantProgress(float progress)
- getCircleRadius()
- setCircleRadius(int circleRadius)
- getBarWidth()
- setBarWidth(int barWidth)
- getBarColor()
- setBarColor(int barColor)
- getRimWidth()
- setRimWidth(int rimWidth)
- getRimColor()
- setRimColor(int rimColor)
- getSpinSpeed()
- setSpinSpeed(float spinSpeed)

thanks to the project [materialish-progress](https://github.com/pnikosis/materialish-progress) and [@croccio](https://github.com/croccio) participation.

more usages about progress, please see the sample.

A basic message：

    new VerySweetAlertDialog(this)
        .setTitleText("Here's a message!")
        .show();

A title with a text under：

    new VerySweetAlertDialog(this)
        .setTitleText("Here's a message!")
        .setContentText("It's pretty, isn't it?")
        .show();

A error message：

    new VerySweetAlertDialog(this, VerySweetAlertDialog.ERROR_TYPE)
        .setTitleText("Oops...")
        .setContentText("Something went wrong!")
        .show();

A warning message：

    new VerySweetAlertDialog(this, VerySweetAlertDialog.WARNING_TYPE)
        .setTitleText("Are you sure?")
        .setContentText("Won't be able to recover this file!")
        .setConfirmText("Yes,delete it!")
        .show();

A success message：

    new VerySweetAlertDialog(this, VerySweetAlertDialog.SUCCESS_TYPE)
        .setTitleText("Good job!")
        .setContentText("You clicked the button!")
        .show();

A message with a custom icon：

    new VerySweetAlertDialog(this, VerySweetAlertDialog.CUSTOM_IMAGE_TYPE)
        .setTitleText("Sweet!")
        .setContentText("Here's a custom image.")
        .setCustomImage(R.drawable.custom_img)
        .show();

Bind the listener to confirm button：

    new VerySweetAlertDialog(this, VerySweetAlertDialog.WARNING_TYPE)
        .setTitleText("Are you sure?")
        .setContentText("Won't be able to recover this file!")
        .setConfirmText("Yes,delete it!")
        .setConfirmClickListener(new VerySweetAlertDialog.OnSweetClickListener() {
            @Override
            public void onClick(VerySweetAlertDialog sDialog) {
                sDialog.dismissWithAnimation();
            }
        })
        .show();

Show the cancel button and bind listener to it：

    new VerySweetAlertDialog(this, VerySweetAlertDialog.WARNING_TYPE)
        .setTitleText("Are you sure?")
        .setContentText("Won't be able to recover this file!")
        .setCancelText("No,cancel plx!")
        .setConfirmText("Yes,delete it!")
        .showCancelButton(true)
        .setCancelClickListener(new VerySweetAlertDialog.OnSweetClickListener() {
            @Override
            public void onClick(VerySweetAlertDialog sDialog) {
                sDialog.cancel();
            }
        })
        .show();

**Change** the dialog style upon confirming：

    new VerySweetAlertDialog(this, VerySweetAlertDialog.WARNING_TYPE)
        .setTitleText("Are you sure?")
        .setContentText("Won't be able to recover this file!")
        .setConfirmText("Yes,delete it!")
        .setConfirmClickListener(new VerySweetAlertDialog.OnSweetClickListener() {
            @Override
            public void onClick(VerySweetAlertDialog sDialog) {
                sDialog
                    .setTitleText("Deleted!")
                    .setContentText("Your imaginary file has been deleted!")
                    .setConfirmText("OK")
                    .setConfirmClickListener(null)
                    .changeAlertType(VerySweetAlertDialog.SUCCESS_TYPE);
            }
        })
        .show();

## License

    MIT License

    Copyright (c) 2018 AdityaSonel

    Permission is hereby granted, free of charge, to any person obtaining a copy
    of this software and associated documentation files (the "Software"), to deal
    in the Software without restriction, including without limitation the rights
    to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
    copies of the Software, and to permit persons to whom the Software is
    furnished to do so, subject to the following conditions:

    The above copyright notice and this permission notice shall be included in all
    copies or substantial portions of the Software.

    THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
    IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
    FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
    AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
    LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
    OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
    SOFTWARE.
