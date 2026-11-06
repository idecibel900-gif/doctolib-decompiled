package com.henninghall.date_picker.ui;

import android.view.accessibility.AccessibilityManager;
import com.henninghall.date_picker.DatePickerPackage;
import java.util.Locale;

/* JADX INFO: loaded from: classes4.dex */
public abstract class Accessibility {
    private static final AccessibilityManager systemManager = (AccessibilityManager) DatePickerPackage.context.getApplicationContext().getSystemService("accessibility");
    private static Locale mLocale = Locale.getDefault();

    public static void setLocale(Locale locale) {
        mLocale = locale;
    }
}
