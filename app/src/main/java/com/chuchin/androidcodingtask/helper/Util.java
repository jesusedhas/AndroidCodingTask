package com.chuchin.androidcodingtask.helper;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;

public class Util {


    //region View

    private static ProgressDialog progressDialog;

    //endregion

    //region Class methods



    public static void showDefaultDialog(String title, String messsage, Activity activity) {

        DialogInterface.OnClickListener dialog;
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);

        dialog = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        };

        builder.setTitle(title)
                .setMessage(messsage)
                .setPositiveButton("Aceptar", dialog)
                .show();
    }

    public static void showProgressDialog(String title, String message, Context context) {

        progressDialog = new ProgressDialog(context);
        progressDialog.setTitle(title);
        progressDialog.setMessage(message);
        progressDialog.setCancelable(false);
        progressDialog.show();

    }

    public static void dismissProgressDialog() {
        if (progressDialog != null)
            progressDialog.dismiss();
    }



    //endregion



}
