package com.facebook.react.bridge;

import android.app.Activity;
import kotlin.Deprecated;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003B\u0013\b\u0016\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\n\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0005¨\u0006\t"}, d2 = {"Lcom/facebook/react/bridge/ReactContextBaseJavaModule;", "Lcom/facebook/react/bridge/BaseJavaModule;", "<init>", "()V", "reactContext", "Lcom/facebook/react/bridge/ReactApplicationContext;", "(Lcom/facebook/react/bridge/ReactApplicationContext;)V", "getCurrentActivity", "Landroid/app/Activity;", "ReactAndroid_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class ReactContextBaseJavaModule extends BaseJavaModule {
    public ReactContextBaseJavaModule() {
        super(null);
    }

    public ReactContextBaseJavaModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @Deprecated
    protected final Activity getCurrentActivity() {
        return getReactApplicationContext().getCurrentActivity();
    }
}
