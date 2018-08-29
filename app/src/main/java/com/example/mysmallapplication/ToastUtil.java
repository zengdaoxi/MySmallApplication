package com.example.mysmallapplication;

import android.content.Context;
import android.widget.Toast;


public class ToastUtil {
    private static Toast toast;

    public static Toast showShort(Context context, CharSequence message) {
        if (null == toast) {
            toast = Toast.makeText(context, message, Toast.LENGTH_SHORT);
        } else {
            toast.setText(message);
        }
        toast.show();

        return toast;
    }
}
