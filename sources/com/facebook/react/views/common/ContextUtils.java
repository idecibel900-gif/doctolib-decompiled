package com.facebook.react.views.common;

import android.content.Context;
import android.content.ContextWrapper;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class ContextUtils {
    public static final ContextUtils INSTANCE = new ContextUtils();

    private ContextUtils() {
    }

    public static final Object findContextOfType(Context context, Class clazz) {
        Context baseContext;
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        while (!clazz.isInstance(context)) {
            if (!(context instanceof ContextWrapper) || context == (baseContext = ((ContextWrapper) context).getBaseContext())) {
                return null;
            }
            context = baseContext;
        }
        return context;
    }
}
