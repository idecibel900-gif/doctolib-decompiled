package com.th3rdwave.safeareacontext;

import android.content.Context;
import android.view.View;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.UIManagerHelper;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public abstract class UIManagerHelperCompatKt {
    public static final ReactContext getReactContext(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        return UIManagerHelper.getReactContext(view);
    }

    public static final int getSurfaceId(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return UIManagerHelper.getSurfaceId(context);
    }
}
