package com.refatfaisal.img;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends Activity {

    ImageView mImageView1,mImageView2,mImageView3,mImageView4,mImageView5;

    private static int CAMERA_REQUEST_1 = 10;
    private static int CAMERA_REQUEST_2 = 20;
    private static int CAMERA_REQUEST_3 = 30;
    private static int CAMERA_REQUEST_4 = 40;
    private static int CAMERA_REQUEST_5 = 50;

    Intent cameraIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeWidget();
        imageViewClickable();
    }

    private void initializeWidget()
    {
        mImageView1 = (ImageView)findViewById(R.id.mImageView1);
        mImageView2 = (ImageView)findViewById(R.id.mImageView2);
        mImageView3 = (ImageView)findViewById(R.id.mImageView3);
        mImageView4 = (ImageView)findViewById(R.id.mImageView4);
        mImageView5 = (ImageView)findViewById(R.id.mImageView5);
    }

    private void imageViewClickable()
    {
        mImageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CaptureAndDeleteImageAlert(CAMERA_REQUEST_1);
            }
        });
        mImageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CaptureAndDeleteImageAlert(CAMERA_REQUEST_2);
            }
        });
        mImageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CaptureAndDeleteImageAlert(CAMERA_REQUEST_3);
            }
        });

        mImageView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CaptureAndDeleteImageAlert(CAMERA_REQUEST_4);
            }
        });

        mImageView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CaptureAndDeleteImageAlert(CAMERA_REQUEST_5);
            }
        });
    }

    AlertDialog cameRaDialog;
    private void CaptureAndDeleteImageAlert(final int REQUEST)
    {
        final CharSequence[] items = getResources().getStringArray(R.array.cameraOption);
        AlertDialog.Builder builder = new AlertDialog.Builder(new ContextThemeWrapper(MainActivity.this, android.R.style.Theme_Holo_Light_Dialog));
        builder.setTitle("Image:");
        builder.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which)
                {
                    case 0:

                        captureImageAlert(REQUEST);
                        break;
                    case 1:

                        break;
                }
                cameRaDialog.dismiss();
            }
        });
        cameRaDialog = builder.create();
        cameRaDialog.show();
    }


    private void captureImageAlert(final int REQUEST)
    {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                MainActivity.this);

        // set title
        alertDialogBuilder.setTitle("");

        // set dialog message
        alertDialogBuilder
                .setMessage("Active Camera ?")
                .setCancelable(false)
                .setPositiveButton("Yes",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int id) {
                        // if this button is clicked, close
                        // current activity
                        cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                        startActivityForResult(cameraIntent,REQUEST);
                        // GPSActivity.this.finish();
                    }
                })
                .setNegativeButton("No",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int id) {
                        // if this button is clicked, just close
                        // the dialog box and do nothing
                        dialog.cancel();
                    }
                });
       // create alert dialog
        AlertDialog alertDialog = alertDialogBuilder.create();
        //show it
        alertDialog.show();

    }

    private void deletePhoto(String admCountryCode, String GrpCode, String subGrpCode, String locationCode, String contentCode)
    {
        if (checkPhotoAvailability()!=true)
        {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                    MainActivity.this);

            // set title
            alertDialogBuilder.setTitle("");

            // set dialog message
            alertDialogBuilder
                    .setMessage("No Image Available For Delete.")
                    .setCancelable(false)
                    .setPositiveButton("OK",new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog,int id) {
                            dialog.dismiss();
                        }
                    });

            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();

        }
        else
        {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                    MainActivity.this);

            // set title
            alertDialogBuilder.setTitle("");

            // set dialog message
            alertDialogBuilder
                    .setMessage("Want To Delete Image?")
                    .setCancelable(false)
                    .setPositiveButton("Yes",new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog,int id) {
                        }
                    })
                    .setNegativeButton("No",new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog,int id) {
                            dialog.cancel();
                        }
                    });
            // create alert dialog
            AlertDialog alertDialog = alertDialogBuilder.create();
            //show it
            alertDialog.show();

        }
    }

    private boolean checkPhotoAvailability()
    {
        if(1>2)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
}
