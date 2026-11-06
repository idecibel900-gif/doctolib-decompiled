package com.facebook.react.uimanager;

import android.view.View;
import com.facebook.react.bridge.JSApplicationCausedNativeException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public class IllegalViewOperationException extends JSApplicationCausedNativeException {
    private View view;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IllegalViewOperationException(String msg) {
        super(msg);
        Intrinsics.checkNotNullParameter(msg, "msg");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IllegalViewOperationException(String msg, View view, Throwable cause) {
        super(msg, cause);
        Intrinsics.checkNotNullParameter(msg, "msg");
        Intrinsics.checkNotNullParameter(cause, "cause");
        this.view = view;
    }
}
