package com.reactnativereceivesharingintent;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

/* JADX INFO: loaded from: classes4.dex */
public class ReceiveSharingIntentModule extends ReactContextBaseJavaModule {
    public final String Log_Tag;
    private final ReactApplicationContext reactContext;
    private ReceiveSharingIntentHelper receiveSharingIntentHelper;

    public ReceiveSharingIntentModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.Log_Tag = "ReceiveSharingIntent";
        this.reactContext = reactApplicationContext;
        this.receiveSharingIntentHelper = new ReceiveSharingIntentHelper((Application) reactApplicationContext.getApplicationContext());
    }

    protected void onNewIntent(Intent intent) {
        Activity currentActivity = getCurrentActivity();
        if (currentActivity == null) {
            return;
        }
        currentActivity.setIntent(intent);
    }

    @ReactMethod
    public void getFileNames(Promise promise) {
        Activity currentActivity = getCurrentActivity();
        if (currentActivity == null) {
            return;
        }
        Intent intent = currentActivity.getIntent();
        if (intent.getBooleanExtra("INTENT_ALREADY_SENT", false)) {
            return;
        }
        this.receiveSharingIntentHelper.sendFileNames(this.reactContext, intent, promise);
        intent.putExtra("INTENT_ALREADY_SENT", true);
    }

    @ReactMethod
    public void clearFileNames() {
        Activity currentActivity = getCurrentActivity();
        if (currentActivity == null) {
            return;
        }
        this.receiveSharingIntentHelper.clearFileNames(currentActivity.getIntent());
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return "ReceiveSharingIntent";
    }
}
