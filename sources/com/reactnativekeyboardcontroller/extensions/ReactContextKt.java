package com.reactnativekeyboardcontroller.extensions;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.appcompat.R$id;
import com.facebook.react.bridge.ReactContext;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public abstract class ReactContextKt {
    public static final View getRootView(ReactContext reactContext) {
        Window window;
        View decorView;
        Intrinsics.checkNotNullParameter(reactContext, "<this>");
        Activity currentActivity = reactContext.getCurrentActivity();
        if (currentActivity == null || (window = currentActivity.getWindow()) == null || (decorView = window.getDecorView()) == null) {
            return null;
        }
        return decorView.getRootView();
    }

    public static final ViewGroup getContent(ReactContext reactContext) {
        Window window;
        View decorView;
        View rootView;
        Intrinsics.checkNotNullParameter(reactContext, "<this>");
        Activity currentActivity = reactContext.getCurrentActivity();
        if (currentActivity == null || (window = currentActivity.getWindow()) == null || (decorView = window.getDecorView()) == null || (rootView = decorView.getRootView()) == null) {
            return null;
        }
        return (ViewGroup) rootView.findViewById(R$id.action_bar_root);
    }
}
