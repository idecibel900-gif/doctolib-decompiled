package com.facebook.react.uimanager;

import android.view.View;
import com.facebook.react.bridge.ReadableArray;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public interface ViewManagerDelegate {
    /* synthetic */ void kotlinCompat$receiveCommand(View view, String str, ReadableArray readableArray);

    void receiveCommand(View view, String str, ReadableArray readableArray);

    void setProperty(View view, String str, Object obj);

    /* synthetic */ default void kotlinCompat$receiveCommandNullableArgs(View view, String commandName, ReadableArray readableArray) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(commandName, "commandName");
        if (readableArray == null) {
            throw new IllegalStateException("Required value was null.");
        }
        kotlinCompat$receiveCommand(view, commandName, readableArray);
    }
}
