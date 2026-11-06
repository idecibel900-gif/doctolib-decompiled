package com.facebook.react.devsupport;

import android.app.Activity;
import android.view.View;
import com.facebook.react.bridge.JavaScriptExecutorFactory;

/* JADX INFO: loaded from: classes3.dex */
public interface ReactInstanceDevHelper {
    View createRootView(String str);

    void destroyRootView(View view);

    Activity getCurrentActivity();

    JavaScriptExecutorFactory getJavaScriptExecutorFactory();

    void reload(String str);

    void toggleElementInspector();
}
